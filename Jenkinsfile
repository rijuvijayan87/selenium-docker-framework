pipeline {
  agent {
    node {
          label "master"
        }
      }

      stages {
        stage("SonarQube analysis") {
           steps {
              script {
                  def sonarScanner = tool name: 'SonarQube', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                  bat "${sonarScanner}/bin/sonar-scanner -e -Dsonar.host.url=xxx"
                }
             }
          }
        }

        stage('Build Jar') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v ${HOME}/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                script {
                	app = docker.build("rijuvijayan/selenium-docker-framework")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
			        docker.withRegistry('http://192.168.0.3:5000') {
			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
}