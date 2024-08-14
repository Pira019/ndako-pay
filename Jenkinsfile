pipeline {
        agent any
        stages {
        
	      stage("Build") { 
	            steps {
	                bat './mvnw clean install' // Compile le projet
	            }
	        }
          stage("build & SonarQube analysis") { 
            steps {
              withSonarQubeEnv(installationName : 'sonarQube') {
                bat './mvnw org.sonarsource.scanner.maven:sonar-maven-plugin:4.0.0.4121:sonar'
              }
            }
          }
          
          stage("Quality Gate") {
            steps {
              timeout(time: 2, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
         
        }
      }