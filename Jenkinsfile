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
                timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline o UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }
	     }
	     }