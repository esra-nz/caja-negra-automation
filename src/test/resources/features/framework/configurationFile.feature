Feature: As the framework loader  I want to load the configuration of the framework from a yaml file  So that the framework has access to the various configurations of the framework

  Scenario: Ability to set the default browser in the configuration
    Given The configuration path
    When the framework is initiated
    Then any code in the framework has access to the configuration setting

