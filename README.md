# AndroidAppiumFramework# Android Appium Framework

A lightweight and scalable mobile test automation framework using Appium, TestNG, and Java* for Android apps.

## Features
- Page Object Model (POM) structure
- Appium integration for Android devices/emulators
- Easy configuration via `appium.properties`
- TestNG support for test suites and reporting

## 🛠️ Requirements
- Java 8+
- Maven
- Android SDK & emulator or real device
- Appium server running

## 📦 Setup

```bash
git clone https://github.com/SupriyaChaudhari2/AndroidAppiumFramework.git
cd AndroidAppiumFramework
mvn clean install

#** Folder Structure**
src/main/java/pages – Page objects

src/test/java/tests – Test cases

appium.properties – Config file

**Test-Cases**
These were prioritized for automation, representing the core business flow that must function reliably.

Planned (Future Work):
Add Expense without entering amount (validation scenario)

Edit Expense or Income (modify amount, category, etc.)

