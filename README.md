# Project Info

The goal of this maven plugin is to 

## Install


```bash
mvn org.apache.maven.plugins:maven-dependency-plugin:2.1:get \
    -DrepoUrl=https://tdurieux.github.io/maven-repository/snapshots/ \
    -Dartifact=com.github.tdurieux:project-config-maven-plugin:1.0-SNAPSHOT
``` 

## Usage

```bash
cd /somewhere/my-project-with-failing-tests

# check the failing tests
mvn test -DtrimStackTrace=false

# look for the configuration
mvn mvn com.github.tdurieux:project-config-maven-plugin:info -q > info.json
```

## Output

```json
{
  "baseDir": "<root>/maven-project-config",
  "tests": ["<root>/maven-project-config/src/test/java"],
  "failingTests": [],
  "sources": ["<root>/maven-project-config/src/main/java"],
  "binSources": ["<root>/maven-project-config/target/classes"],
  "classpath": [
    "<root>/.m2/repository/javax/inject/javax.inject/1/javax.inject-1.jar",
    "<root>/.m2/repository/org/apache/maven/resolver/maven-resolver-api/1.3.1/maven-resolver-api-1.3.1.jar",
    "<root>/.m2/repository/javax/annotation/jsr250-api/1.0/jsr250-api-1.0.jar",
    "<root>/.m2/repository/org/json/json/20180813/json-20180813.jar",
    "<root>/.m2/repository/org/apache/maven/doxia/doxia-sink-api/1.0/doxia-sink-api-1.0.jar",
    "<root>/.m2/repository/org/apache/maven/maven-model/3.6.0/maven-model-3.6.0.jar",
    "<root>/.m2/repository/org/codehaus/plexus/plexus-archiver/2.2/plexus-archiver-2.2.jar",
    "<root>/.m2/repository/org/apache/maven/maven-repository-metadata/3.6.0/maven-repository-metadata-3.6.0.jar",
    "<root>/.m2/repository/org/eclipse/sisu/org.eclipse.sisu.inject/0.3.3/org.eclipse.sisu.inject-0.3.3.jar",
    "<root>/.m2/repository/com/google/j2objc/j2objc-annotations/1.1/j2objc-annotations-1.1.jar",
    "<root>/.m2/repository/org/apache/maven/maven-artifact/3.0/maven-artifact-3.0.jar",
    "<root>/.m2/repository/org/apache/maven/maven-plugin-api/3.6.0/maven-plugin-api-3.6.0.jar",
    "<root>/.m2/repository/com/google/code/findbugs/jsr305/3.0.2/jsr305-3.0.2.jar",
    "<root>/.m2/repository/com/google/inject/guice/4.2.1/guice-4.2.1-no_aop.jar",
    "<root>/.m2/repository/org/apache/maven/wagon/wagon-provider-api/3.2.0/wagon-provider-api-3.2.0.jar",
    "<root>/.m2/repository/org/codehaus/plexus/plexus-classworlds/2.5.2/plexus-classworlds-2.5.2.jar",
    "<root>/.m2/repository/org/apache/maven/plugin-tools/maven-plugin-annotations/3.6.0/maven-plugin-annotations-3.6.0.jar",
    "<root>/.m2/repository/org/checkerframework/checker-compat-qual/2.0.0/checker-compat-qual-2.0.0.jar",
    "<root>/.m2/repository/org/eclipse/sisu/org.eclipse.sisu.plexus/0.3.3/org.eclipse.sisu.plexus-0.3.3.jar",
    "<root>/.m2/repository/exceptionparser/exceptionparser/1.0-SNAPSHOT/exceptionparser-1.0-SNAPSHOT.jar",
    "<root>/.m2/repository/org/codehaus/mojo/animal-sniffer-annotations/1.14/animal-sniffer-annotations-1.14.jar",
    "<root>/.m2/repository/org/apache/commons/commons-lang3/3.8.1/commons-lang3-3.8.1.jar",
    "<root>/.m2/repository/org/apache/maven/reporting/maven-reporting-api/3.0/maven-reporting-api-3.0.jar",
    "<root>/.m2/repository/org/apache/maven/maven-settings-builder/3.6.0/maven-settings-builder-3.6.0.jar",
    "<root>/.m2/repository/junit/junit/3.8.1/junit-3.8.1.jar",
    "<root>/.m2/repository/org/apache/maven/maven-settings/3.6.0/maven-settings-3.6.0.jar",
    "<root>/.m2/repository/org/codehaus/plexus/plexus-utils/3.0.15/plexus-utils-3.0.15.jar",
    "<root>/.m2/repository/commons-io/commons-io/2.2/commons-io-2.2.jar",
    "<root>/.m2/repository/org/apache/maven/surefire/surefire-report-parser/2.22.1/surefire-report-parser-2.22.1.jar",
    "<root>/.m2/repository/org/sonatype/plexus/plexus-cipher/1.4/plexus-cipher-1.4.jar",
    "<root>/.m2/repository/org/apache/maven/maven-model-builder/3.6.0/maven-model-builder-3.6.0.jar",
    "<root>/.m2/repository/com/google/errorprone/error_prone_annotations/2.1.3/error_prone_annotations-2.1.3.jar",
    "<root>/.m2/repository/com/google/guava/guava/25.1-android/guava-25.1-android.jar",
    "<root>/.m2/repository/org/apache/maven/maven-resolver-provider/3.6.0/maven-resolver-provider-3.6.0.jar",
    "<root>/.m2/repository/classworlds/classworlds/1.1-alpha-2/classworlds-1.1-alpha-2.jar",
    "<root>/.m2/repository/org/apache/maven/resolver/maven-resolver-impl/1.3.1/maven-resolver-impl-1.3.1.jar",
    "<root>/.m2/repository/org/apache/maven/plugin-testing/maven-plugin-testing-harness/3.3.0/maven-plugin-testing-harness-3.3.0.jar",
    "<root>/.m2/repository/org/apache/maven/resolver/maven-resolver-spi/1.3.1/maven-resolver-spi-1.3.1.jar",
    "<root>/.m2/repository/org/codehaus/plexus/plexus-container-default/1.0-alpha-9-stable-1/plexus-container-default-1.0-alpha-9-stable-1.jar",
    "<root>/.m2/repository/com/google/collections/google-collections/1.0/google-collections-1.0.jar",
    "<root>/.m2/repository/aopalliance/aopalliance/1.0/aopalliance-1.0.jar",
    "<root>/.m2/repository/org/codehaus/plexus/plexus-component-annotations/1.7.1/plexus-component-annotations-1.7.1.jar",
    "<root>/.m2/repository/org/apache/maven/maven-core/3.6.0/maven-core-3.6.0.jar",
    "<root>/.m2/repository/org/sonatype/plexus/plexus-sec-dispatcher/1.4/plexus-sec-dispatcher-1.4.jar",
    "<root>/.m2/repository/org/codehaus/plexus/plexus-io/2.0.4/plexus-io-2.0.4.jar",
    "<root>/.m2/repository/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar",
    "<root>/.m2/repository/org/apache/maven/shared/maven-shared-utils/3.2.1/maven-shared-utils-3.2.1.jar",
    "<root>/.m2/repository/org/apache/maven/resolver/maven-resolver-util/1.3.1/maven-resolver-util-1.3.1.jar",
    "<root>/.m2/repository/org/apache/maven/maven-compat/3.6.0/maven-compat-3.6.0.jar",
    "<root>/.m2/repository/org/codehaus/plexus/plexus-interpolation/1.25/plexus-interpolation-1.25.jar",
    "<root>/.m2/repository/org/apache/maven/maven-builder-support/3.6.0/maven-builder-support-3.6.0.jar",
    "<root>/.m2/repository/javax/enterprise/cdi-api/1.0/cdi-api-1.0.jar",
    "<root>/.m2/repository/org/apache/maven/surefire/surefire-logger-api/2.22.1/surefire-logger-api-2.22.1.jar"
  ],
  "complianceLevel": 8,
  "modules": [{
    "baseDir": "<root>/maven-project-config",
    "tests": ["<root>/maven-project-config/src/test/java"],
    "failingTests": [],
    "sources": ["<root>/maven-project-config/src/main/java"],
    "binSources": ["<root>/maven-project-config/target/classes"],
    "classpath": [
      "<root>/.m2/repository/org/apache/maven/plugin-tools/maven-plugin-annotations/3.6.0/maven-plugin-annotations-3.6.0.jar",
      "<root>/.m2/repository/org/apache/maven/maven-artifact/3.0/maven-artifact-3.0.jar",
      "<root>/.m2/repository/org/apache/maven/maven-model/3.6.0/maven-model-3.6.0.jar",
      "<root>/.m2/repository/org/apache/maven/maven-plugin-api/3.6.0/maven-plugin-api-3.6.0.jar",
      "<root>/.m2/repository/org/eclipse/sisu/org.eclipse.sisu.plexus/0.3.3/org.eclipse.sisu.plexus-0.3.3.jar",
      "<root>/.m2/repository/javax/enterprise/cdi-api/1.0/cdi-api-1.0.jar",
      "<root>/.m2/repository/javax/annotation/jsr250-api/1.0/jsr250-api-1.0.jar",
      "<root>/.m2/repository/org/codehaus/plexus/plexus-classworlds/2.5.2/plexus-classworlds-2.5.2.jar",
      "<root>/.m2/repository/org/apache/maven/maven-core/3.6.0/maven-core-3.6.0.jar",
      "<root>/.m2/repository/org/apache/maven/maven-settings/3.6.0/maven-settings-3.6.0.jar",
      "<root>/.m2/repository/org/apache/maven/maven-settings-builder/3.6.0/maven-settings-builder-3.6.0.jar",
      "<root>/.m2/repository/org/sonatype/plexus/plexus-sec-dispatcher/1.4/plexus-sec-dispatcher-1.4.jar",
      "<root>/.m2/repository/org/sonatype/plexus/plexus-cipher/1.4/plexus-cipher-1.4.jar",
      "<root>/.m2/repository/org/apache/maven/maven-builder-support/3.6.0/maven-builder-support-3.6.0.jar",
      "<root>/.m2/repository/org/apache/maven/maven-repository-metadata/3.6.0/maven-repository-metadata-3.6.0.jar",
      "<root>/.m2/repository/org/apache/maven/maven-model-builder/3.6.0/maven-model-builder-3.6.0.jar",
      "<root>/.m2/repository/org/apache/maven/maven-resolver-provider/3.6.0/maven-resolver-provider-3.6.0.jar",
      "<root>/.m2/repository/org/slf4j/slf4j-api/1.7.25/slf4j-api-1.7.25.jar",
      "<root>/.m2/repository/org/apache/maven/resolver/maven-resolver-impl/1.3.1/maven-resolver-impl-1.3.1.jar",
      "<root>/.m2/repository/org/apache/maven/resolver/maven-resolver-api/1.3.1/maven-resolver-api-1.3.1.jar",
      "<root>/.m2/repository/org/apache/maven/resolver/maven-resolver-spi/1.3.1/maven-resolver-spi-1.3.1.jar",
      "<root>/.m2/repository/org/apache/maven/resolver/maven-resolver-util/1.3.1/maven-resolver-util-1.3.1.jar",
      "<root>/.m2/repository/org/apache/maven/shared/maven-shared-utils/3.2.1/maven-shared-utils-3.2.1.jar",
      "<root>/.m2/repository/org/eclipse/sisu/org.eclipse.sisu.inject/0.3.3/org.eclipse.sisu.inject-0.3.3.jar",
      "<root>/.m2/repository/com/google/inject/guice/4.2.1/guice-4.2.1-no_aop.jar",
      "<root>/.m2/repository/aopalliance/aopalliance/1.0/aopalliance-1.0.jar",
      "<root>/.m2/repository/com/google/guava/guava/25.1-android/guava-25.1-android.jar",
      "<root>/.m2/repository/com/google/code/findbugs/jsr305/3.0.2/jsr305-3.0.2.jar",
      "<root>/.m2/repository/org/checkerframework/checker-compat-qual/2.0.0/checker-compat-qual-2.0.0.jar",
      "<root>/.m2/repository/com/google/errorprone/error_prone_annotations/2.1.3/error_prone_annotations-2.1.3.jar",
      "<root>/.m2/repository/com/google/j2objc/j2objc-annotations/1.1/j2objc-annotations-1.1.jar",
      "<root>/.m2/repository/org/codehaus/mojo/animal-sniffer-annotations/1.14/animal-sniffer-annotations-1.14.jar",
      "<root>/.m2/repository/javax/inject/javax.inject/1/javax.inject-1.jar",
      "<root>/.m2/repository/org/codehaus/plexus/plexus-component-annotations/1.7.1/plexus-component-annotations-1.7.1.jar",
      "<root>/.m2/repository/org/apache/commons/commons-lang3/3.8.1/commons-lang3-3.8.1.jar",
      "<root>/.m2/repository/org/apache/maven/surefire/surefire-report-parser/2.22.1/surefire-report-parser-2.22.1.jar",
      "<root>/.m2/repository/org/apache/maven/surefire/surefire-logger-api/2.22.1/surefire-logger-api-2.22.1.jar",
      "<root>/.m2/repository/org/apache/maven/reporting/maven-reporting-api/3.0/maven-reporting-api-3.0.jar",
      "<root>/.m2/repository/org/apache/maven/doxia/doxia-sink-api/1.0/doxia-sink-api-1.0.jar",
      "<root>/.m2/repository/org/codehaus/plexus/plexus-utils/3.0.15/plexus-utils-3.0.15.jar",
      "<root>/.m2/repository/exceptionparser/exceptionparser/1.0-SNAPSHOT/exceptionparser-1.0-SNAPSHOT.jar",
      "<root>/.m2/repository/com/google/collections/google-collections/1.0/google-collections-1.0.jar",
      "<root>/.m2/repository/org/apache/maven/maven-compat/3.6.0/maven-compat-3.6.0.jar",
      "<root>/.m2/repository/org/codehaus/plexus/plexus-interpolation/1.25/plexus-interpolation-1.25.jar",
      "<root>/.m2/repository/org/apache/maven/wagon/wagon-provider-api/3.2.0/wagon-provider-api-3.2.0.jar",
      "<root>/.m2/repository/org/apache/maven/plugin-testing/maven-plugin-testing-harness/3.3.0/maven-plugin-testing-harness-3.3.0.jar",
      "<root>/.m2/repository/commons-io/commons-io/2.2/commons-io-2.2.jar",
      "<root>/.m2/repository/org/codehaus/plexus/plexus-archiver/2.2/plexus-archiver-2.2.jar",
      "<root>/.m2/repository/org/codehaus/plexus/plexus-container-default/1.0-alpha-9-stable-1/plexus-container-default-1.0-alpha-9-stable-1.jar",
      "<root>/.m2/repository/junit/junit/3.8.1/junit-3.8.1.jar",
      "<root>/.m2/repository/classworlds/classworlds/1.1-alpha-2/classworlds-1.1-alpha-2.jar",
      "<root>/.m2/repository/org/codehaus/plexus/plexus-io/2.0.4/plexus-io-2.0.4.jar",
      "<root>/.m2/repository/org/json/json/20180813/json-20180813.jar"
    ],
    "name": "Plugin to Automatically Fix failing test with",
    "complianceLevel": 8,
    "binTests": ["<root>/maven-project-config/target/test-classes"]
  }],
  "binTests": ["<root>/maven-project-config/target/test-classes"]
}

```
