pipeline {
    agent none
    stages {
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
			        //docker.withRegistry('https://registry.hub.docker.com', 'docker-hub') {
			        docker.withRegistry('http://192.168.0.3:5000') {
			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
}