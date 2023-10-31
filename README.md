Qudrtajon
---

# Spring Boot CI/CD Project

## General requirements

- Jenkins have to build your project according to the Maven/Gradle build script.
  ![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/maven.png)
- Project is deployed at your local Tomcat Server by Jenkins job.
  ![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/tomcat.png)
- Jenkins should be integrated with SonarQube.
  ![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/jenkins-sonarqube-config.png)

## 🚀 Application requirements

Before diving in, make sure you have:

- Build tool: Maven/Gradle.
  ![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/aplication-pom.png)

- Tomcat Server - should be installed as Service and start automatic.
  ![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/tomcat-service.png)

- Unit testing framework: JUnit (the latest version).
  ![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/JUnit.png)

- Database: MySQL or PostgreSQL (the latest version).
  ![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/postgres.png)
-
- Continuous Integration server: Jenkins LTS
  ![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/jenkins.png)

- Code analysis tool: SonarQube
  ![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/SonarQube.png)

## 🛠️ Setup Guide

### 1️⃣ Jenkins Setup

## Jenkins Credentials

**Administrator:**
Username: administrator
Password: administrator

**Developer:**
Username: developer
Password: developer

![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/credentials.png)

### 2️⃣ Configure Jenkins build job

Build trigger
![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/build-triggers.png)
run log
![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/task1-success.png)
Work space
![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/tash1-success2.png)

### 3️⃣ Build and Package

Intelij sonarQube plugin statistic
![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/intelij-plugen-sonarqube.png)
sonarQube project statistic
![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/sonarqube-project.png)
![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/sonarqube-project-analayse.png)
![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/jenkins-analayse-build-success.png)
![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/jenkins-Pipeline-success.png)

``` groovy
pipeline {
    agent any
    tools {
        jdk 'jdk17'
        maven 'maven'
    }

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', changelog: false, poll: false, url: 'https://github.com/komilovqudratjon/ci-cd-test.git'
            }
        }
    stage('Sonar Analysis') {
        steps {
        // Run Maven build and generate JaCoCo report
           bat "mvn clean verify"
        
        // Run SonarQube analysis with the appropriate parameters
           bat '''mvn sonar:sonar \
          -Dsonar.host.url=http://localhost:9000/ \
          -Dsonar.token=sqa_d997f87cfe52cfecc128280f6044e3a5f1dce520 \
          -Dsonar.java.binaries=target\\classes \
          -Dsonar.coverage.jacoco.xmlReportPaths=target\\coverage-reports\\jacoco.xml ^
          -Dsonar.verbose=true \
          -Dsonar.projectKey=task-three'''
    }
}

    }
}

```

### 4️⃣ Configure Tomcat

Download and initiate Tomcat from their [official website](http://tomcat.apache.org/). Tweak the settings to align with
your project needs.

### 5️⃣ Jenkins Pipeline

On Jenkins:

- Construct a new job for the Spring Boot application.
- Lay down the pipeline stages: build, code coverage (with JaCoCo), static code analysis (with SonarQube), and
  deployment to Tomcat.

## 💡 Note

Monitor the code's quality post-deployment using SonarQube.

## 🤝 Contribute

Open source thrives on contributions. Feel free to fork, modify, and create pull requests. Let's make this project
better together!

---

Please adjust the content to further align with your project specifics or personal style preferences.