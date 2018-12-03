package com.github.tdurieux.repair.maven.plugin;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProjectInfo {
    private String baseDir;
    private int complianceLevel;
    private List<String> sources;
    private List<String> tests;
    private List<String> binSources;
    private List<String> binTests;
    private List<String> classpath;
    private List<String> failingTests;
    private List<ModuleInfo> modules = new ArrayList<>();

    public ProjectInfo() {
    }

    public ProjectInfo(String baseDir, int complianceLevel, List<String> sources, List<String> tests, List<String> binSources, List<String> binTests, List<String> classpath, List<String> failingTests) {
        this();
        this.baseDir = baseDir;
        this.complianceLevel = complianceLevel;
        this.sources = sources;
        this.tests = tests;
        this.binSources = binSources;
        this.binTests = binTests;
        this.classpath = classpath;
        this.failingTests = failingTests;
    }

    public String getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

    public int getComplianceLevel() {
        return complianceLevel;
    }

    public void setComplianceLevel(int complianceLevel) {
        this.complianceLevel = complianceLevel;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public List<String> getTests() {
        return tests;
    }

    public void setTests(List<String> tests) {
        this.tests = tests;
    }

    public List<String> getBinSources() {
        return binSources;
    }

    public void setBinSources(List<String> binSources) {
        this.binSources = binSources;
    }

    public List<String> getBinTests() {
        return binTests;
    }

    public void setBinTests(List<String> binTests) {
        this.binTests = binTests;
    }

    public List<String> getClasspath() {
        return classpath;
    }

    public void setClasspath(List<String> classpath) {
        this.classpath = classpath;
    }

    public List<String> getFailingTests() {
        return failingTests;
    }

    public void setFailingTests(List<String> failingTests) {
        this.failingTests = failingTests;
    }

    public void addModule(ModuleInfo info) {
        this.modules.add(info);
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject(this);
        for (int i = 0; i < modules.size(); i++) {
            ModuleInfo moduleInfo = modules.get(i);
            jsonObject.append("modules", new JSONObject(moduleInfo));
        }
        return jsonObject.toString(2);
    }
}
