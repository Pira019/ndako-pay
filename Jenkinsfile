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
          
          stage("Quality Gate"){
		  timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
		    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
		    if (qg.status != 'OK') {
		      error "Pipeline aborted due to quality gate failure: ${qg.status}"
		    }
		  }
           
         
        }
     }
     }