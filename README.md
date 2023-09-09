# REST Assured API Test Automation Architecture

Ready-to-use API Test Automation Architecture using Java and REST Assured.

## Installation Steps

In order to use the framework:

1. [Fork](https://github.com/Tahanima/rest-assured-api-test-automation-architecture/fork) the repository.
2. Clone, i.e, download your copy of the repository to your local machine using
```
git clone https://github.com/[your_username]/rest-assured-api-test-automation-architecture.git
```
3. Import the project in [IntelliJ IDEA](https://www.jetbrains.com/idea/download/).
4. Make your desired changes.
5. Use IntelliJ IDEA to run your desired tests. Alternatively, you can use the terminal to run the tests, for example `./gradlew test`.
6. Build and browse the allure report using
```
./gradlew allureServe
```

## Languages and Frameworks

The project uses the following:
- *[Java 11](https://openjdk.java.net/projects/jdk/11/)* as the programming language.
- *[REST Assured](https://rest-assured.io/)* as the HTTP client.
- *[Jackson](https://github.com/FasterXML/jackson)* as the JSON parser.
- *[Univocity Parsers](https://www.univocity.com/pages/univocity_parsers_tutorial)* to parse and handle CSV files.
- *[JUnit 5](https://junit.org/junit5/)* as the testing framework.
- *[Lombok](https://projectlombok.org/)* to generate getters, setters, builders and more.
- *[Owner](http://owner.aeonbits.org/)* to minimize the code to handle properties file.
- *[Allure Report](https://qameta.io/allure-report/)* as the test reporting strategy.
- *[Gradle](https://gradle.org/)* as the Java build tool.
- *[IntelliJ IDEA](https://www.jetbrains.com/idea/)* as the IDE.

## Project Structure

The project is structured as follows:

```bash
📦 rest-assured-api-test-automation-architecture
├─ .github
│  └─ workflows
│     └─ test-execution.yml
├─ .gitignore
├─ LICENSE
├─ README.md
├─ build.gradle
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
├─ gradlew.bat
├─ settings.gradle
└─ src
   ├─ main
   │  ├─ java
   │  │  └─ io
   │  │     └─ github
   │  │        └─ tahanima
   │  │           ├─ client
   │  │           │  └─ UserClient.java
   │  │           ├─ config
   │  │           │  ├─ Configuration.java
   │  │           │  └─ ConfigurationManager.java
   │  │           ├─ dto
   │  │           │  ├─ BaseDto.java
   │  │           │  └─ UserDto.java
   │  │           ├─ model
   │  │           │  └─ User.java
   │  │           ├─ report
   │  │           │  └─ AllureManager.java
   │  │           └─ util
   │  │              ├─ Endpoint.java
   │  │              └─ RequestSpec.java
   │  └─ resources
   │     ├─ allure.properties
   │     └─ config.properties
   └─ test
      ├─ java
      │  └─ io
      │     └─ github
      │        └─ tahanima
      │           ├─ annotation
      │           │  └─ DataSource.java
      │           ├─ e2e
      │           │  ├─ BaseE2ETest.java
      │           │  └─ UserE2ETest.java
      │           └─ util
      │              ├─ CsvToDtoMapper.java
      │              ├─ DataArgumentsProvider.java
      │              └─ JsonFormatter.java
      └─ resources
         └─ testdata
            └─ user.csv
```
