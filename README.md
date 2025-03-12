# Open Rewrite Sample

## Logs of Open Rewrite migration command

```
mvn rewrite:run
[INFO] Scanning for projects...
[INFO]
[INFO] -------------------< fr.example:sample-open-rewrite >-------------------
[INFO] Building sample-open-rewrite 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] >>> rewrite-maven-plugin:6.3.0:run (default-cli) > process-test-classes @ sample-open-rewrite >>>
[INFO]
[INFO] --- maven-resources-plugin:3.2.0:resources (default-resources) @ sample-open-rewrite ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] Copying 1 resource
[INFO] Copying 1 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.13.0:compile (default-compile) @ sample-open-rewrite ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 60 source files with javac [debug parameters target 8] to target\classes
[WARNING] bootstrap class path not set in conjunction with -source 8
[WARNING] source value 8 is obsolete and will be removed in a future release
[WARNING] target value 8 is obsolete and will be removed in a future release
[WARNING] To suppress warnings about obsolete options, use -Xlint:-options.
[INFO]
[INFO] --- maven-resources-plugin:3.2.0:testResources (default-testResources) @ sample-open-rewrite ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] Copying 1 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.13.0:testCompile (default-testCompile) @ sample-open-rewrite ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 6 source files with javac [debug parameters target 8] to target\test-classes
[WARNING] bootstrap class path not set in conjunction with -source 8
[WARNING] source value 8 is obsolete and will be removed in a future release
[WARNING] target value 8 is obsolete and will be removed in a future release
[WARNING] To suppress warnings about obsolete options, use -Xlint:-options.
[INFO]
[INFO] <<< rewrite-maven-plugin:6.3.0:run (default-cli) < process-test-classes @ sample-open-rewrite <<<
[INFO]
[INFO]
[INFO] --- rewrite-maven-plugin:6.3.0:run (default-cli) @ sample-open-rewrite ---
[INFO] Using active recipe(s) [org.openrewrite.java.migrate.UpgradeToJava21, org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2]
[INFO] Using active styles(s) []
[INFO] Validating active recipes...
[WARNING] This Gauge has been already registered (MeterId{name='cache.size', tags=[tag(cache=Maven POMs - default)]}), the Gauge registration will be ignored. Note that subsequent logs will be logged at debug level.
[INFO] Project [sample-open-rewrite] Resolving Poms...
[INFO] Project [sample-open-rewrite] Parsing source files
[INFO] Running recipe(s)...
[WARNING] Changes have been made to pom.xml by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]                         org.openrewrite.maven.UpdateMavenProjectPropertyJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]                     org.openrewrite.maven.UpdateMavenProjectPropertyJavaVersion: {version=17}
[WARNING]             org.openrewrite.java.migrate.UpgradePluginsForJava17
[WARNING]                 org.openrewrite.maven.UpgradePluginVersion: {groupId=org.apache.maven.plugins, artifactId=maven-compiler-plugin, newVersion=3.x}
[WARNING]             org.openrewrite.java.migrate.AddLombokMapstructBinding
[WARNING]                 org.openrewrite.maven.AddDependency: {groupId=org.projectlombok, artifactId=lombok-mapstruct-binding, version=0.2.0, acceptTransitive=false}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]                 org.openrewrite.maven.UpdateMavenProjectPropertyJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_7
[WARNING]                         org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_6
[WARNING]                             org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_5
[WARNING]                                 org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_4
[WARNING]                                     org.openrewrite.java.spring.boot2.SpringBoot2JUnit4to5Migration
[WARNING]                                         org.openrewrite.java.testing.junit5.JUnit4to5Migration
[WARNING]                                             org.openrewrite.java.testing.junit5.UseMockitoExtension
[WARNING]                                                 org.openrewrite.java.testing.mockito.Mockito1to4Migration
[WARNING]                                                     org.openrewrite.java.dependencies.UpgradeDependencyVersion: {groupId=org.mockito, artifactId=*, newVersion=4.x}
[WARNING]                                             org.openrewrite.maven.ExcludeDependency: {groupId=junit, artifactId=junit}
[WARNING]                                             org.openrewrite.java.dependencies.RemoveDependency: {groupId=org.junit.vintage, artifactId=junit-vintage-engine}
[WARNING]                     org.openrewrite.maven.UpgradeParentVersion: {groupId=org.springframework.boot, artifactId=spring-boot-starter-parent, newVersion=3.0.x}
[WARNING]                     org.openrewrite.java.springdoc.UpgradeSpringDoc_2
[WARNING]                         org.openrewrite.java.dependencies.ChangeDependency: {oldGroupId=org.springdoc, oldArtifactId=springdoc-openapi-ui, newArtifactId=springdoc-openapi-starter-webmvc-ui, newVersion=2.1.x}
[WARNING]                 org.openrewrite.maven.UpgradeParentVersion: {groupId=org.springframework.boot, artifactId=spring-boot-starter-parent, newVersion=3.1.x}
[WARNING]                 org.openrewrite.java.dependencies.UpgradeDependencyVersion: {groupId=org.springdoc, artifactId=*, newVersion=2.2.x}
[WARNING]             org.openrewrite.maven.UpgradeParentVersion: {groupId=org.springframework.boot, artifactId=spring-boot-starter-parent, newVersion=3.2.x}
[WARNING]             org.openrewrite.java.dependencies.UpgradeDependencyVersion: {groupId=org.springdoc, artifactId=*, newVersion=2.5.x}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\classroom\ClassroomController.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.validation, newPackageName=jakarta.validation, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\classroom\internal\entity\Classroom.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxPersistenceToJakartaPersistence
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.persistence, newPackageName=jakarta.persistence, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\classroom\internal\entity\Planning.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxPersistenceToJakartaPersistence
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.persistence, newPackageName=jakarta.persistence, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\classroom\spi\dto\ClassroomDTO.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.validation, newPackageName=jakarta.validation, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\classroom\spi\dto\PlanningDTO.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.validation, newPackageName=jakarta.validation, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\core\enumeration\ValueOfEnum.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.validation, newPackageName=jakarta.validation, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\core\enumeration\ValueOfEnumValidator.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.validation, newPackageName=jakarta.validation, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\establishment\EstablishmentController.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.validation, newPackageName=jakarta.validation, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\establishment\internal\entity\Activity.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxPersistenceToJakartaPersistence
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.persistence, newPackageName=jakarta.persistence, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\establishment\internal\entity\Employee.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxPersistenceToJakartaPersistence
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.persistence, newPackageName=jakarta.persistence, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\establishment\internal\entity\Establishment.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxPersistenceToJakartaPersistence
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.persistence, newPackageName=jakarta.persistence, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\establishment\spi\dto\ActivityDTO.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.validation, newPackageName=jakarta.validation, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\establishment\spi\dto\EmployeeDTO.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.validation, newPackageName=jakarta.validation, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\establishment\spi\dto\EstablishmentDTO.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.validation, newPackageName=jakarta.validation, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\student\internal\entity\Absence.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxPersistenceToJakartaPersistence
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.persistence, newPackageName=jakarta.persistence, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\student\internal\entity\Rate.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxPersistenceToJakartaPersistence
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.persistence, newPackageName=jakarta.persistence, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\student\internal\entity\Student.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxPersistenceToJakartaPersistence
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.persistence, newPackageName=jakarta.persistence, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\student\spi\dto\AbsenceDTO.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.validation, newPackageName=jakarta.validation, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\student\spi\dto\RateDTO.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.validation, newPackageName=jakarta.validation, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\student\spi\dto\StudentDTO.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.validation, newPackageName=jakarta.validation, recursive=true}
[WARNING] Changes have been made to src\main\java\fr\example\sample_open_rewrite\student\StudentController.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.migrate.jakarta.JakartaEE10
[WARNING]                         org.openrewrite.java.migrate.jakarta.JavaxMigrationToJakarta
[WARNING]                             org.openrewrite.java.migrate.jakarta.JavaxValidationMigrationToJakartaValidation
[WARNING]                                 org.openrewrite.java.ChangePackage: {oldPackageName=javax.validation, newPackageName=jakarta.validation, recursive=true}
[WARNING] Changes have been made to src\test\java\fr\example\sample_open_rewrite\classroom\ClassroomIntegrationTests.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_7
[WARNING]                         org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_6
[WARNING]                             org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_5
[WARNING]                                 org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_4
[WARNING]                                     org.openrewrite.java.spring.boot2.SpringBoot2JUnit4to5Migration
[WARNING]                                         org.openrewrite.java.testing.junit5.JUnit4to5Migration
[WARNING]                                             org.openrewrite.java.testing.junit5.AssertToAssertions
[WARNING]                                             org.openrewrite.java.testing.junit5.UpdateBeforeAfterAnnotations
[WARNING]                                             org.openrewrite.java.testing.junit5.UpdateTestAnnotation
[WARNING]                                         org.openrewrite.java.spring.boot2.UnnecessarySpringRunWith
[WARNING]                                             org.openrewrite.java.testing.junit5.RunnerToExtension: {runners=[org.springframework.test.context.junit4.SpringRunner, org.springframework.test.context.junit4.SpringJUnit4ClassRunner], extension=org.springframework.test.context.junit.jupiter.SpringExtension}
[WARNING]                                         org.openrewrite.java.spring.boot2.UnnecessarySpringExtension
[WARNING] Changes have been made to src\test\java\fr\example\sample_open_rewrite\classroom\internal\domain\ClassroomServiceTest.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_7
[WARNING]                         org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_6
[WARNING]                             org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_5
[WARNING]                                 org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_4
[WARNING]                                     org.openrewrite.java.spring.boot2.SpringBoot2JUnit4to5Migration
[WARNING]                                         org.openrewrite.java.testing.junit5.JUnit4to5Migration
[WARNING]                                             org.openrewrite.java.testing.junit5.UseMockitoExtension
[WARNING]                                                 org.openrewrite.java.testing.junit5.RunnerToExtension: {runners=[org.mockito.runners.MockitoJUnitRunner, org.mockito.junit.MockitoJUnitRunner, org.mockito.runners.MockitoJUnit44Runner, org.mockito.junit.MockitoJUnit44Runner], extension=org.mockito.junit.jupiter.MockitoExtension}
[WARNING]                                             org.openrewrite.java.testing.junit5.AssertToAssertions
[WARNING]                                             org.openrewrite.java.testing.junit5.UpdateTestAnnotation
[WARNING] Changes have been made to src\test\java\fr\example\sample_open_rewrite\establishment\EstablishmentIntegrationTests.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_7
[WARNING]                         org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_6
[WARNING]                             org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_5
[WARNING]                                 org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_4
[WARNING]                                     org.openrewrite.java.spring.boot2.SpringBoot2JUnit4to5Migration
[WARNING]                                         org.openrewrite.java.testing.junit5.JUnit4to5Migration
[WARNING]                                             org.openrewrite.java.testing.junit5.AssertToAssertions
[WARNING]                                             org.openrewrite.java.testing.junit5.UpdateBeforeAfterAnnotations
[WARNING]                                             org.openrewrite.java.testing.junit5.UpdateTestAnnotation
[WARNING]                                         org.openrewrite.java.spring.boot2.UnnecessarySpringRunWith
[WARNING]                                             org.openrewrite.java.testing.junit5.RunnerToExtension: {runners=[org.springframework.test.context.junit4.SpringRunner, org.springframework.test.context.junit4.SpringJUnit4ClassRunner], extension=org.springframework.test.context.junit.jupiter.SpringExtension}
[WARNING]                                         org.openrewrite.java.spring.boot2.UnnecessarySpringExtension
[WARNING] Changes have been made to src\test\java\fr\example\sample_open_rewrite\establishment\internal\domain\EstablishmentServiceTest.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_7
[WARNING]                         org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_6
[WARNING]                             org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_5
[WARNING]                                 org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_4
[WARNING]                                     org.openrewrite.java.spring.boot2.SpringBoot2JUnit4to5Migration
[WARNING]                                         org.openrewrite.java.testing.junit5.JUnit4to5Migration
[WARNING]                                             org.openrewrite.java.testing.junit5.UseMockitoExtension
[WARNING]                                                 org.openrewrite.java.testing.junit5.RunnerToExtension: {runners=[org.mockito.runners.MockitoJUnitRunner, org.mockito.junit.MockitoJUnitRunner, org.mockito.runners.MockitoJUnit44Runner, org.mockito.junit.MockitoJUnit44Runner], extension=org.mockito.junit.jupiter.MockitoExtension}
[WARNING]                                             org.openrewrite.java.testing.junit5.AssertToAssertions
[WARNING]                                             org.openrewrite.java.testing.junit5.UpdateTestAnnotation
[WARNING] Changes have been made to src\test\java\fr\example\sample_open_rewrite\student\internal\domain\StudentServiceTest.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_7
[WARNING]                         org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_6
[WARNING]                             org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_5
[WARNING]                                 org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_4
[WARNING]                                     org.openrewrite.java.spring.boot2.SpringBoot2JUnit4to5Migration
[WARNING]                                         org.openrewrite.java.testing.junit5.JUnit4to5Migration
[WARNING]                                             org.openrewrite.java.testing.junit5.UseMockitoExtension
[WARNING]                                                 org.openrewrite.java.testing.junit5.RunnerToExtension: {runners=[org.mockito.runners.MockitoJUnitRunner, org.mockito.junit.MockitoJUnitRunner, org.mockito.runners.MockitoJUnit44Runner, org.mockito.junit.MockitoJUnit44Runner], extension=org.mockito.junit.jupiter.MockitoExtension}
[WARNING]                                             org.openrewrite.java.testing.junit5.AssertToAssertions
[WARNING]                                             org.openrewrite.java.testing.junit5.UpdateBeforeAfterAnnotations
[WARNING]                                             org.openrewrite.java.testing.junit5.UpdateTestAnnotation
[WARNING] Changes have been made to src\test\java\fr\example\sample_open_rewrite\student\StudentIntegrationTests.java by:
[WARNING]     org.openrewrite.java.migrate.UpgradeToJava21
[WARNING]         org.openrewrite.java.migrate.UpgradeToJava17
[WARNING]             org.openrewrite.java.migrate.Java8toJava11
[WARNING]                 org.openrewrite.java.migrate.UpgradeBuildToJava11
[WARNING]                     org.openrewrite.java.migrate.UpgradeJavaVersion: {version=11}
[WARNING]             org.openrewrite.java.migrate.UpgradeBuildToJava17
[WARNING]                 org.openrewrite.java.migrate.UpgradeJavaVersion: {version=17}
[WARNING]         org.openrewrite.java.migrate.UpgradeBuildToJava21
[WARNING]             org.openrewrite.java.migrate.UpgradeJavaVersion: {version=21}
[WARNING]         org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
[WARNING]             org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_1
[WARNING]                 org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0
[WARNING]                     org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_7
[WARNING]                         org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_6
[WARNING]                             org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_5
[WARNING]                                 org.openrewrite.java.spring.boot2.UpgradeSpringBoot_2_4
[WARNING]                                     org.openrewrite.java.spring.boot2.SpringBoot2JUnit4to5Migration
[WARNING]                                         org.openrewrite.java.testing.junit5.JUnit4to5Migration
[WARNING]                                             org.openrewrite.java.testing.junit5.AssertToAssertions
[WARNING]                                             org.openrewrite.java.testing.junit5.UpdateBeforeAfterAnnotations
[WARNING]                                             org.openrewrite.java.testing.junit5.UpdateTestAnnotation
[WARNING]                                         org.openrewrite.java.spring.boot2.UnnecessarySpringRunWith
[WARNING]                                             org.openrewrite.java.testing.junit5.RunnerToExtension: {runners=[org.springframework.test.context.junit4.SpringRunner, org.springframework.test.context.junit4.SpringJUnit4ClassRunner], extension=org.springframework.test.context.junit.jupiter.SpringExtension}
[WARNING]                                         org.openrewrite.java.spring.boot2.UnnecessarySpringExtension
[WARNING] Please review and commit the results.
[WARNING] Estimate time saved: 5m
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:31 min
[INFO] Finished at: 2025-03-13T00:02:26+01:00
[INFO] ------------------------------------------------------------------------
```
