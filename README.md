Cucumber-BDD--TrendsAutomation

The framework is Cucumber-BDD based and uses Selenium, Java libraries and incorporates Page Object Model.

Features include:

Support for all major web browsers (Windows + MacOS)
Support for reporting (using Extent Reports)
Support for capturing screenshots
Utilities class which has resuable methods that help perform common web actions.

Order of the flow is as follows (file names as in the project are mentioned below)

Feature File (TestFeatures.feature) -> Glue File (StepsGlue) -> Interface (TestStepsService) -> Implementation (TestStepsImpl) -> Page Class (any one of the 3 classes under "..//ui//pages)

The above files can be used to create your own test flows for your web application.

