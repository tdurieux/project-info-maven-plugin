package com.github.tdurieux.repair.maven.plugin;

import java.util.List;

public class ModuleInfo extends ProjectInfo {
    private String name;

    public ModuleInfo() {
    }

    public ModuleInfo(String baseDir, int complianceLevel, List<String> sources, List<String> tests, List<String> binSources, List<String> binTests, List<String> classpath, List<String> failingTests, String name) {
        super(baseDir, complianceLevel, sources, tests, binSources, binTests, classpath, failingTests);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
