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
    stage('List Files') {
        steps {
            bat "dir C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\task-three\\target\\"
        }
    }

    stage('Deploy to Tomcat') {
       steps {
         deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://localhost:8081/')], contextPath: 'cicd-test', war: '**/target/cicd.war'        }
    }
  }
}

```
docker-compose.yml
``` yaml
version: '3'

services:
  sonarqube:
    image: sonarqube
    ports:
      - "9000:9000"
    environment:
      - SONARQUBE_JDBC_URL=jdbc:postgresql://db:5432/sonar
      - SONARQUBE_JDBC_USERNAME=sonar
      - SONARQUBE_JDBC_PASSWORD=secret
    volumes:
      - sonarqube_conf:/opt/sonarqube/conf
      - sonarqube_data:/opt/sonarqube/data
      - sonarqube_extensions:/opt/sonarqube/extensions
      - sonarqube_bundled-plugins:/opt/sonarqube/lib/bundled-plugins
    depends_on:
      - db

  db:
    image: postgres
    environment:
      - POSTGRES_USER=sonar
      - POSTGRES_PASSWORD=secret
    volumes:
      - postgresql_data:/var/lib/postgresql
      # this volume is used for sonarqube to store its data
      - sonarqube_db:/var/lib/postgresql/data

volumes:
  sonarqube_conf:
  sonarqube_data:
  sonarqube_extensions:
  sonarqube_bundled-plugins:
  postgresql_data:
  sonarqube_db:

```
it will works at http://localhost:9000

### 4️⃣ Configure Tomcat
# FUll VIDEO WATCH HERE WAIT...

[![Thumbnail or GIF alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/four-and-five-tasks.gif)](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/four-and-five-tasks.mp4)


![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/five-task.png)


### 5️⃣ Jenkins Pipeline
![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/blue-ocean.png)
![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/git-jenkins-file.png)




## 🤝 Contribute

Hi Maksim,

I've completed the tasks. Please review and let me know if there are any issues. Thank you!

---
