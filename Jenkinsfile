pipeline {
    agent none
    stages {
        stage('Sonarqube') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
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