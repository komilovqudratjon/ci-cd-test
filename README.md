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

![Alt text](https://raw.githubusercontent.com/komilovqudratjon/ci-cd-test/main/file/credentials.png)





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