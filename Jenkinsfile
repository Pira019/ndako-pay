pipeline {
        agent any
        stages {
          stage("build & SonarQube analysis") { 
            steps {
              withSonarQubeEnv(installationName : 'sonarQube') {
                bat './mvnw clean org.sonarsource.scanner.maven:sonar-maven-plugin:4.0.0.4121:sonar'
              }
            }
          }
          stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
        }
      }