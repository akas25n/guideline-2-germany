package com.guideline2germany;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.guideline2germany")
public class OnionArchitectureTest {

    @ArchTest
    static final ArchRule entities_should_not_depend_on_other_layers =
    noClasses().that().resideInAPackage("..entity..")
            .should().dependOnClassesThat().resideInAnyPackage("..service..", "..repository..", "..controller..");

    @ArchTest
    static final ArchRule services_should_depend_only_on_entities_and_repositories =
            classes().that().resideInAPackage("..service..")
                    .should().onlyDependOnClassesThat()
                    .resideInAnyPackage("..service..", "..entity..", "..repository..", "java..", "javax..");
}
