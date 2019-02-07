# Project Info

The goal of this maven plugin is to get the project information to be able to run repair tools on it. 

## Install


```bash
mvn org.apache.maven.plugins:maven-dependency-plugin:3.1.1:get -DremoteRepositories=https://tdurieux.github.io/maven-repository/snapshots/ -Dartifact=com.github.tdurieux:project-config-maven-plugin:1.0-SNAPSHOT;
``` 

## Usage

```bash
cd /somewhere/my-project-with-failing-tests

# check the failing tests
mvn test -DtrimStackTrace=false

# look for the configuration
mvn com.github.tdurieux:project-config-maven-plugin:info -q > info.json
```

## Output

```js
{
  // base directory of the project  
  "baseDir": "<root>/maven-project-config",
  // all test sources
  "tests": ["<root>/maven-project-config/src/test/java"],
  // all failing tests
  "failingTests": [],
  // all sources
  "sources": ["<root>/maven-project-config/src/main/java"],
  "binSources": ["<root>/maven-project-config/target/classes"],
  "classpath": [
    // full classpath
    "<root>/.m2/repository/javax/inject/javax.inject/1/javax.inject-1.jar",
    "<root>/.m2/repository/org/apache/maven/resolver/maven-resolver-api/1.3.1/maven-resolver-api-1.3.1.jar",
    "<root>/.m2/repository/javax/annotation/jsr250-api/1.0/jsr250-api-1.0.jar",
    "<root>/.m2/repository/org/json/json/20180813/json-20180813.jar",
  ],
  "complianceLevel": 8,
  "modules": [{
    // module base directory  
    "baseDir": "<root>/maven-project-config",
    // module test sources
    "tests": ["<root>/maven-project-config/src/test/java"],
    // module failing tests
    "failingTests": [],
    // module sources
    "sources": ["<root>/maven-project-config/src/main/java"],
    // module source binaries
    "binSources": ["<root>/maven-project-config/target/classes"],
    "classpath": [
      // module classpath  
      "<root>/.m2/repository/org/apache/maven/plugin-tools/maven-plugin-annotations/3.6.0/maven-plugin-annotations-3.6.0.jar",
      "<root>/.m2/repository/org/apache/maven/maven-artifact/3.0/maven-artifact-3.0.jar",
      "<root>/.m2/repository/org/apache/maven/maven-model/3.6.0/maven-model-3.6.0.jar",
      "<root>/.m2/repository/org/apache/maven/maven-plugin-api/3.6.0/maven-plugin-api-3.6.0.jar",
    ],
    "name": "Plugin to Automatically Fix failing test with",
    "complianceLevel": 8,
    "binTests": ["<root>/maven-project-config/target/test-classes"]
  }],
  "binTests": ["<root>/maven-project-config/target/test-classes"]
}

```
