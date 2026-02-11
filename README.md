# InsiderOne QA Assessment

## Project Structure

```
├── src/main/java/com/insiderone/
│   ├── pageObject/                    # Page Objects (POM)
│   │   ├── mainPage/                  # Main page
│   │   └── careersPage/               # Careers pages
│   │       ├── qualityAssurancePage/   # QA page
│   │       └── openPositionsPage/     # Open Positions page
│   └── api/                           # API service classes
│       └── PetApi.java
├── src/test/java/tests/
│   ├── main/                          # Main page tests
│   ├── careers/                       # Careers page tests
│   └── api/                           # API tests
├── loadtest/                          # Load tests
│   └── locustfile.py                  # Locust script
└── build.gradle
```

## Tech Stack

- Java 17
- Gradle 
- Selenide 
- JUnit 5
- Rest-Assured
- Allure Reports
- Locust

## How to Run

### UI Tests

```bash
./gradlew test
```

Run with specific browser:

```bash
./gradlew test -Pbrowser=chrome
./gradlew test -Pbrowser=firefox
```

### Allure Report

```bash
./gradlew allureServe
```

### Load Tests

```bash
cd loadtest
python3 -m locust --headless -u 1 -r 1 --run-time 30s
```
