pipeline {
    agent none
    stages {
        stage('Sonarqube') {
             steps {
                withSonarQubeEnv('SonarQube') {
                sh 'mvn clean compile sonar:sonar -Dsonar.host.url=http://192.168.0.3:9000 -Dsonar.login=549bd38d85c9259aa047b08bba9f8e5887732b19 -Dsonar.test.inclusions=**/*Test*/**'
                }
            }
            timeout(time: 5, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
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