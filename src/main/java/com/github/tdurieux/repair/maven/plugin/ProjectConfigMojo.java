package com.github.tdurieux.repair.maven.plugin;

import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.surefire.log.api.NullConsoleLogger;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.plugins.surefire.report.ReportTestSuite;
import org.apache.maven.plugins.surefire.report.SurefireReportParser;
import org.apache.maven.project.MavenProject;
import org.apache.maven.reporting.MavenReportException;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Mojo( name = "info", aggregator = true,
        defaultPhase = LifecyclePhase.TEST,
        requiresDependencyResolution = ResolutionScope.TEST)
public class ProjectConfigMojo extends AbstractMojo {

    @Parameter(property = "java.version", defaultValue = "-1")
    private String javaVersion;

    @Parameter(property = "maven.compiler.source", defaultValue = "-1")
    private String source;

    @Parameter(property = "maven.compile.source", defaultValue = "-1")
    private String oldSource;

    @Parameter(defaultValue="${project}", readonly=true, required=true)
    protected MavenProject project;

    @Parameter( defaultValue = "${reactorProjects}", readonly = true )
	protected List<MavenProject> reactorProjects;


    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        // String baseDir, int complianceLevel, List<String> sources, List<String> tests, List<String> binSources, List<String> binTests, List<String> classpath, List<String> failingTests
        ProjectInfo projectInfo = new ProjectInfo(this.project.getBasedir().getAbsolutePath(),
                getComplianceLevel(),
                getSourceFolders(),
                getTestFolders(),
                getBinFolders(),
                getTestBinFolders(),
                getClasspath(),
                getFailingTests());

        for (MavenProject mavenProject : reactorProjects) {
            ModuleInfo info = new ModuleInfo();
            if (mavenProject == project) {
                info.setName("root");
            } else {
                info.setName(mavenProject.getName());
            }
            info.setComplianceLevel(getComplianceLevel());
            info.setBaseDir(mavenProject.getBasedir().getAbsolutePath());
            info.setClasspath(getClasspath(mavenProject));

            info.setFailingTests(getFailingTest(mavenProject));
            info.setSources(getSourceFolder(mavenProject));
            info.setTests(getTestFolder(mavenProject));
            info.setBinSources(getBinFolder(mavenProject));
            info.setBinTests(getTestBinFolder(mavenProject));

            projectInfo.addModule(info);
        }
        System.out.println(projectInfo.toString());
    }

    public int getComplianceLevel() {
        int complianceLevel = 7;
        if (!source.equals("-1")) {
            complianceLevel = Integer.parseInt(source.substring(2));
        } else if (!oldSource.equals("-1")) {
            complianceLevel = Integer.parseInt(oldSource.substring(2));
        } else if (!javaVersion.equals("-1")) {
            complianceLevel = Integer.parseInt(javaVersion.substring(2, 3));
        }
        return complianceLevel;
    }

    private File getSurefireReportsDirectory( MavenProject subProject ) {
        String buildDir = subProject.getBuild().getDirectory();
        return new File( buildDir + "/surefire-reports" );
    }

    public List<String> getFailingTests() {
        List<String> result = new ArrayList<>();

        for (MavenProject mavenProject : reactorProjects) {
            result.addAll(getFailingTest(mavenProject));
        }

        return result;
    }

    private List<String> getFailingTest(MavenProject mavenProject) {
        List<String> result = new ArrayList<>();
        File surefireReportsDirectory = getSurefireReportsDirectory(mavenProject);
        SurefireReportParser parser = new SurefireReportParser(Collections.singletonList(surefireReportsDirectory), Locale.ENGLISH, new NullConsoleLogger());

        try {
            List<ReportTestSuite> testSuites = parser.parseXMLReportFiles();
            for (ReportTestSuite reportTestSuite : testSuites) {
                if (reportTestSuite.getNumberOfErrors()+reportTestSuite.getNumberOfFailures() > 0) {
                    result.add(reportTestSuite.getFullClassName());
                }
            }
        } catch (MavenReportException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> getClasspath() {
        Set<String> classpath = new HashSet<>();
        for (MavenProject mavenProject : reactorProjects) {
            classpath.addAll(getClasspath(mavenProject));
        }
        return new ArrayList<>(classpath);
    }

    private  List<String> getClasspath(MavenProject mavenProject) {
        List<String> binFolders = getTestBinFolder(mavenProject);
        binFolders.addAll(getBinFolder(mavenProject));
        List<String> classpath  = new ArrayList<>();
        try {
            for (String s : mavenProject.getTestClasspathElements()) {
                File f = new File(s);
                if (f.exists() && !binFolders.contains(f.getAbsolutePath())) {
                    classpath.add(f.getAbsolutePath());
                }
            }
        } catch (DependencyResolutionRequiredException e) {
            e.printStackTrace();
        }
        return classpath;
    }

    public List<String> getSourceFolders() {
        Set<String> sourceFolder = new HashSet<>();
        for (MavenProject mavenProject : reactorProjects) {
            sourceFolder.addAll(getSourceFolder(mavenProject));
        }
        return new ArrayList<>(sourceFolder);
    }

    private List<String> getSourceFolder(MavenProject mavenProject) {
        List<String> sources = new ArrayList<>();
        File sourceDirectory = new File(mavenProject.getBuild().getSourceDirectory());
        if (sourceDirectory.exists()) {
            sources.add(sourceDirectory.getAbsolutePath());
        }
        File generatedSourceDirectory = new File(mavenProject.getBuild().getOutputDirectory() + "/generated-sources");
        if (generatedSourceDirectory.exists()) {
            sources.add(generatedSourceDirectory.getAbsolutePath());
        }
        return sources;
    }

    public List<String> getTestFolders() {
		Set<String> sourceFolder = new HashSet<>();
		for (MavenProject mavenProject : reactorProjects) {
            sourceFolder.addAll(getTestFolder(mavenProject));
        }
		return new ArrayList<>(sourceFolder);
	}

    private List<String> getTestFolder(MavenProject mavenProject) {
        List<String> sources = new ArrayList<String>();
        File sourceDirectory = new File(mavenProject.getBuild().getTestSourceDirectory());
        if (sourceDirectory.exists()) {
            sources.add(sourceDirectory.getAbsolutePath());
        }
        return sources;
    }

    public List<String> getBinFolders() {
        Set<String> sourceFolder = new HashSet<>();
        for (MavenProject mavenProject : reactorProjects) {
            sourceFolder.addAll(getBinFolder(mavenProject));
        }
        return new ArrayList<>(sourceFolder);
    }

    private List<String> getBinFolder(MavenProject mavenProject) {
        List<String> sources = new ArrayList<String>();
        File sourceDirectory = new File(mavenProject.getBuild().getOutputDirectory());
        if (sourceDirectory.exists()) {
            sources.add(sourceDirectory.getAbsolutePath());
        }
        return sources;
    }

    public List<String> getTestBinFolders() {
        Set<String> sourceFolder = new HashSet<>();
        for (MavenProject mavenProject : reactorProjects) {
            sourceFolder.addAll(getTestBinFolder(mavenProject));
        }
        return new ArrayList<>(sourceFolder);
    }

    private List<String> getTestBinFolder(MavenProject mavenProject) {
        List<String> sources = new ArrayList<String>();
        File sourceDirectory = new File(mavenProject.getBuild().getTestOutputDirectory());
        if (sourceDirectory.exists()) {
            sources.add(sourceDirectory.getAbsolutePath());
        }
        return sources;
    }

}
