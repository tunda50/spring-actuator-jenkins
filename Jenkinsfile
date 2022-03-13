pipeline {
    agent any
    tools {
        maven 'Maven' 
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                bat 'mvn clean compile' 
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
            }
        }
         stage('Health Check') {
            steps {
                echo 'Health Check....'
            }
        }
    }
}