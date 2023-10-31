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

    stage('Deploy to Tomcat') {
      steps {
        deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://localhost:8080/')], contextPath: null, war: '**/*.war'
       }
    }
  }
}
