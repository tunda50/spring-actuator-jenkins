pipeline {
    agent any
    tools {
        maven 'Maven' 
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                bat 'mvn clean package' 
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                 bat 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                bat 'javaw -jar  spring-actuator-jenkins-0.0.1-SNAPSHOT.jar'
            }
        }
         stage('Health Check') {
            steps {
                echo 'Health Check....'
            }
        }
    }
}
