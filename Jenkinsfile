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
                stash includes: 'target/*.jar', name: 'targetfiles'
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
                script{
                       unstash 'targetfiles'
                       sh 'javaw -jar'
                     }
                }
        }
         stage('Health Check') {
            steps {
                echo 'Health Check....'
            }
        }
    }
}
