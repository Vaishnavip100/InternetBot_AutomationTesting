# 🧪 InternetBot Selenium Automation Framework

## 📌 Overview

This project is a Selenium + Java Test Automation Framework built to automate and validate functionalities of the practice application:

👉 https://the-internet.herokuapp.com

The framework follows the **Page Object Model (POM)** design pattern and includes advanced features like parallel execution, reporting, retry logic, and data-driven testing.

---
## 🛠️ Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Apache POI
* Extent Reports
* WebDriverManager

---
## 🚀 Key Features

* Page Object Model (POM) design
* TestNG framework integration
* Data-driven testing using Excel
* Extent Reports (HTML reporting)
* Screenshot capture on failure
* Retry mechanism for flaky tests

---
## 📁 Project Structure

```
InternetBot/
│
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── BasePage.java              → Common reusable actions (click, wait, etc.)
│   │   │
│   │   ├── pages/
│   │   │   ├── LoginPage.java             → Login functionality
│   │   │   ├── HomePage.java              → Navigation methods
│   │   │   ├── AlertsPage.java            → JS alert handling
│   │   │   ├── CheckboxPage.java          → Checkbox interactions
│   │   │   ├── DropdownPage.java          → Dropdown handling
│   │   │   ├── FileUploadPage.java        → File upload actions
│   │   │   └── DynamicLoadingPage.java    → Dynamic content handling
│   │   │
│   │   └── utils/
│   │       ├── ConfigReader.java          → Reads config.properties
│   │       ├── ExcelUtil.java             → Excel data reader
│   │       ├── ExtentManager.java         → Extent report setup
│   │       └── ScreenshotUtil.java        → Screenshot capture utility
│
│   ├── test/java/
│   │   ├── base/
│   │   │   └── BaseTest.java              → Driver setup (ThreadLocal)
│   │   │
│   │   ├── listeners/
│   │   │   ├── TestListener.java          → Screenshot + report integration
│   │   │   └── RetryListener.java         → Applies retry logic globally
│   │   │
│   │   ├── tests/
│   │   │   ├── LoginTest.java                     → Validates login scenarios
│   │   │   ├── AlertsTest.java                    → Handles and verifies JavaScript alerts 
│   │   │   ├── CheckboxesAndDropdownsTest.java    → Tests checkbox toggle and dropdown selection functionality
│   │   │   ├── FileUploadTest.java                → Verifies file upload behavior and UI validation
│   │   │   └── DynamicLoadingTest.java            → Validates dynamic content loading and refresh behavior
│   │   │
│   │   └── utils/
│   │       └── RetryAnalyzer.java         → Retry failed tests
│
│   └── test/resources/
│       ├── config.properties              → Environment config
│       └── testdata/
│           ├── LoginData.xlsx             → DataProvider file
│           ├── sample.txt                 → Upload file
│           └── samplePdf.pdf              → Alternate file
│
├── reports/                               → Extent Reports (auto-generated)
├── screenshots/                           → Failure screenshots
│
├── pom.xml                                → Maven dependencies & plugins
└── testng.xml                             → Test execution config
```

---
## 🧪 Test Modules Covered

### 1. Authentication

* Valid login
* Invalid login
* Success message validation
* Logout verification

### 2. JavaScript Alerts

* Alert accept
* Confirm dismiss
* Prompt input handling

### 3. Checkboxes & Dropdowns

* Checkbox toggle validation
* Dropdown selection
* Option count verification

### 4. File Upload

* File upload validation
* Handling different file types
* UI validation

### 5. Dynamic Loading

* Wait for dynamic elements
* Verify loaded content
* Refresh and re-validation

---

## ▶️ How to Run

### Using Maven

```bash
mvn test
```

### Using TestNG

Right-click `testng.xml` → Run as TestNG Suite

---

## 📊 Reports

After execution:

* 📁 Extent Report → `reports/ExtentReport.html`
* 📁 Screenshots → `screenshots/`

---

## ⚙️ Configuration

Located in:

```text
src/test/resources/config.properties
```

```properties
browser=chrome
baseUrl=https://the-internet.herokuapp.com
timeout=10
username=tomsmith
password=SuperSecretPassword!
```

---
## 👩‍💻 Author
Vaishnavi

---
## ✅ Conclusion

This framework demonstrates a scalable and maintainable automation solution using Selenium with practices like POM, screenshot on failure, retry, parallel execution and reporting.
