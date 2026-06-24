# SeleniumProjectmigration2

A Java-based Selenium automation framework for testing **Guidewire PolicyCenter** workflows. This repository appears to be a migrated or reorganized automation project containing a reusable test framework, page-level automation components, externalized test data, and smoke test coverage for core insurance policy flows.

## Overview

This project is designed to automate browser-based testing using:
- **Java**
- **Selenium WebDriver**
- **TestNG**
- **ExtentReports**
- **Excel-based test data**
- **Page Object Model (POM)**
- **BDD-style feature definition** support in parts of the repository

The automation is focused on **Guidewire applications**, especially **PolicyCenter**, and includes an example smoke test for creating a **motor insurance policy** using annual billing.

## Repository Structure

```text
SeleniumProjectmigration2/
├── README.md
└── SeleniumForMig/
    └── test-automation/
        └── TOIVO_TestAutomation/
            ├── TestData/
            │   ├── ApplicationsHub.xlsx
            │   └── LT/
            └── src/
                ├── main/
                │   ├── java/com/guidewire/
                │   │   ├── commonpagefunctions/
                │   │   ├── config/
                │   │   ├── menu/
                │   │   ├── policycenter/
                │   │   └── utilities/
                │   └── resources/
                │       └── Readme.feature
                └── test/
                    └── java/com/guidewire/
                        ├── basetest/
                        │   └── BaseTest.java
                        └── smoketests/
                            └── PC_Motor_SmokeTest_Motor_CreatePolicyUsingAnnualBillingType.java
```

## Framework Design

### 1. Base Test Layer
The framework uses a shared base class:
- `BaseTest.java`

This class is responsible for common automation setup and utilities, including:
- browser initialization
- environment selection
- loading credentials and test data from Excel
- report initialization
- screenshot capture on failures
- login/authentication helpers
- execution result handling
- reusable assertion and date helper methods

### 2. Page Object Layer
Under `src/main/java/com/guidewire/`, the project is organized into reusable application modules such as:
- `commonpagefunctions` — shared page interactions
- `config` — framework and environment constants
- `menu` — menu navigation components
- `policycenter` — PolicyCenter page objects and business actions
- `utilities` — helper classes for reporting, file handling, Excel operations, XML reading, keyboard actions, etc.

### 3. Test Layer
Under `src/test/java/com/guidewire/`, tests are grouped separately from framework code.

Examples:
- `basetest/BaseTest.java` — shared parent class for test execution
- `smoketests/...` — smoke coverage for business-critical flows

## Example Automated Flow

The repository includes the smoke test:

- `PC_Motor_SmokeTest_Motor_CreatePolicyUsingAnnualBillingType.java`

This test automates an end-to-end PolicyCenter scenario that includes:
1. loading data from a TestNG data provider
2. authenticating into the application
3. opening PolicyCenter
4. navigating to account creation
5. searching or creating a customer account
6. starting a new submission
7. selecting a motor insurance product
8. entering policy and vehicle details
9. selecting coverages and bonus details
10. quoting the policy
11. choosing a yearly payment plan
12. binding the quote
13. verifying submission completion
14. logging out

## Test Data Management

The project uses **external Excel files** for credentials, environment selection, and test input.

Key file observed in the repository:
- `TestData/ApplicationsHub.xlsx`

The framework also refers to multiple environment- and company-specific test data files. Based on the code, test data appears to be selected dynamically using:
- insurance company
- environment to run
- module name
- line of business

This approach helps keep test logic separate from test data and supports reuse across environments.

## Supported Execution Features

From the current codebase, the framework supports:
- **Chrome** and **Edge** browser execution
- **data-driven testing** using TestNG `@DataProvider`
- **screenshot capture on failure**
- **HTML reporting** with ExtentReports
- **run-mode checks** from test data sheets
- **environment-specific execution paths**
- **basic integration hooks for Jira/Zephyr-related reporting utilities**

## Feature File

The repository also contains:
- `src/main/resources/Readme.feature`

This includes a sample BDD-style login scenario, showing that the project may support or document behavior-driven flows alongside the main TestNG-driven automation.

Example scenario intent:
- open browser
- navigate to application URL
- access login/account area
- enter credentials
- validate successful login

## Prerequisites

Before running the automation, make sure the following are available on the machine:

- **Java JDK**
- **Maven or the project’s configured build/dependency tool**
- **Chrome and/or Edge browser**
- matching **browser drivers**
- access to the required **Guidewire environments**
- valid test credentials in the configured Excel sheets
- required third-party libraries referenced in the codebase

## How to Run

> Note: Build files such as `pom.xml` or `build.gradle` were not visible in the inspected paths, so the exact execution command may depend on files not yet reviewed or on the local project setup.

Typical execution flow for this type of framework would be:

1. Configure environment and user details in the Excel test data files.
2. Ensure browser drivers are available at the paths expected by the framework.
3. Open the project in your preferred Java IDE.
4. Run the desired TestNG suite or execute an individual test class.

You may run tests through:
- a TestNG XML suite
- direct IDE execution of a test class
- a Maven command, if a `pom.xml` exists in the full project

## Notable Implementation Details

From the inspected files:
- reporting is initialized through **ExtentReports**
- test results are also written back into Excel-based execution reports
- screenshots are captured automatically on failure
- browser setup logic includes download preferences and cleanup routines
- dynamic URLs and credentials are selected based on environment and company configuration
- the framework uses a **Page Object Model** to separate page logic from test logic

## Current State of the Repository

The repository currently appears to have:
- a very small commit history
- an initial framework upload
- minimal root-level documentation before this update

This README is intended to make the project easier to understand for new contributors, testers, and maintainers.

## Recommended Improvements

To make the project easier to onboard and maintain, consider adding:
- a `pom.xml` or `build.gradle` if not already present elsewhere
- a `testng.xml` suite file in the root or module directory
- setup instructions for browser drivers
- sample test data templates with sensitive data removed
- dependency and version documentation
- environment variable or config-file based secrets handling
- CI pipeline integration instructions

## Disclaimer

This README is based on the currently visible repository structure and inspected source files. If additional modules or build files exist outside the inspected paths, you may want to extend this documentation further with exact setup and execution instructions.
