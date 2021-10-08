![Java](https://img.shields.io/badge/java-%23df2c25.svg?style=for-the-badge&logo=java&logoColor=white)
![Karate](https://img.shields.io/badge/Pact-%23ffffff.svg?style=for-the-badge&logo=CloudBees&logoColor=black)
![JUnit5](https://img.shields.io/badge/JUnit5-%2325A162.svg?style=for-the-badge&logo=JUnit5&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-%230f303b.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
<a href="https://linkedin.com/in/leonardo-duprates">
<img alt="LinkedIn" src="https://img.shields.io/badge/linkedin-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white"/>
</a>

# Pact Contract Testing

Pact is a code-first tool for testing HTTP and message integrations using contract tests.

## Project Architecture

```shell
PactConstratTesting/
├── src
│   ├── test
│       ├── java/com/example/pact
│           ├── consumer
│           ├── provider
```

## Built With

- [Pact](https://docs.pact.io/)
- [JUnit5](https://junit.org/junit5/)

## Design Patterns

This project uses the design patterns from [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
.

## Getting Started

1\. Java installation instructions: [java.com](https://java.com/en/download/help/download_options.html)

2\. Gradle installation instructions: [gradle.org](https://gradle.org/install/)

3\. Build Project

```shell
$ ./gradlew build
```

4\. Run Tests

```shell
$  ./gradlew test
```

5\. Run Consumer Tests & Publish

```shell
$  ./gradlew test --tests PersonConsumerContractTest pactPublish
```

5\. Run Provider Tests & Verify

```shell
$  ./gradlew test --tests PersonProviderContractTest -Dpact.verifier.publishResults=true
```

## Docker

Container Image: [postgres](https://hub.docker.com/_/postgres)
Container Image: [pact-broker](https://hub.docker.com/r/dius/pact-broker)

1\. Docker Compose Up:

```shell
$ docker-compose up
```

2\. Docker Compose Stop:

```shell
$ docker-compose stop
```

## Links

- [Java](https://java.com/)
- [Gradle](https://gradle.org/)
- [Pact](https://docs.pact.io/)
- [Maven Repository](https://mvnrepository.com/)
