# 📦 QA Automation Template — Java + Selenium + Cucumber

Template siap pakai untuk project QA Automation baru.

## 🚀 Cara Pakai Template Ini

### 1. Salin folder ini untuk project baru
```bash
cp -r qa-automation-template nama-project-baru
cd nama-project-baru
```

### 2. Sesuaikan `pom.xml`
```xml
<groupId>com.namaproject</groupId>
<artifactId>nama-project-baru</artifactId>
```

### 3. Sesuaikan `config.properties`
```properties
base.url=https://url-aplikasi-yang-diuji.com
browser=chrome
headless=false
```

### 4. Buat Page Object baru (extends BasePage)
```java
public class HalamanLogin extends BasePage {
    public HalamanLogin(WebDriver driver) {
        super(driver);
    }
    // tambahkan elemen dan method
}
```

### 5. Buat Step Definition (extends BaseStep)
```java
public class LoginStep extends BaseStep {
    HalamanLogin halamanLogin;
    // tambahkan step methods
}
```

### 6. Jalankan
```bash
mvn test
```

## 📁 Struktur Folder
```
src/test/java/
├── config/       → ConfigReader (baca config.properties)
├── hooks/        → Setup & teardown WebDriver
├── pages/        → Page Object Model
│   └── components/ → Reusable UI components (navbar, modal, dll)
├── runner/       → TestRunners
├── steps/        → Step Definitions
└── utils/        → DriverManager, WaitHelper, ScreenshotHelper

src/test/resources/
├── config/       → config.properties
├── features/     → File .feature (Gherkin)
└── testdata/     → Data test (JSON, CSV, dll)
```
