Qudrtajon
---

# Spring Boot CI/CD Project

## Overview

This project showcases the integration of a Spring Boot application with CI/CD tools like Jenkins, SonarQube, and Tomcat. The core functionality involves cloning a Spring Boot application from GitHub, testing its integrity, and deploying it via an automated workflow.

## 🚀 Prerequisites

Before diving in, make sure you have:

- **Java**: The latest version installed.
- **GitHub**: An active account.
- **Maven**: Installed and configured.
- **Jenkins**: Access to a Jenkins server with Maven and JaCoCo plugins.
- **SonarQube**: Installed for code quality checks.
- **Tomcat**: Installed for deployment purposes.

## 🛠️ Setup Guide

### 1️⃣ Clone the Spring Boot Project

```bash
git clone git@github.com:komilovqudratjon/ci-cd-test.git
```
Ensure the project's REST API is up and running.

### 2️⃣ Maven Setup

After navigating to the project directory, check the `pom.xml`. Make sure the Maven configuration is accurate and that Tomcat is set with the provided scope. The project should use Spring Boot version `2.7.3`.

```xml
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-core</artifactId>
    <scope>provided</scope>
</dependency>
```

### 3️⃣ Build and Package

Generate the WAR file:

```bash
mvn clean package
```

### 4️⃣ Configure Tomcat

Download and initiate Tomcat from their [official website](http://tomcat.apache.org/). Tweak the settings to align with your project needs.

### 5️⃣ Jenkins Pipeline

On Jenkins:

- Construct a new job for the Spring Boot application.
- Lay down the pipeline stages: build, code coverage (with JaCoCo), static code analysis (with SonarQube), and deployment to Tomcat.

## 💡 Note

Monitor the code's quality post-deployment using SonarQube.

## 🤝 Contribute

Open source thrives on contributions. Feel free to fork, modify, and create pull requests. Let's make this project better together!

---

Please adjust the content to further align with your project specifics or personal style preferences.