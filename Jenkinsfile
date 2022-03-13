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
                
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                bat 'xcopy /y "target\\spring-actuator-jenkins.war" "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps"'
            }
              
        }
         stage('Health Check') {
            steps {
                echo 'Health Check....'
                script{
                    sleep 30 // Sleep 30 seconds to keep the actuator up
                    def get = new URL("http://localhost:8082/spring-actuator-jenkins/actuator/health").openConnection();
                    def getRC = get.getResponseCode();
                    println(getRC);
                    assert getRC == 200
                  
                    if(getRC.equals(200)) {
                        def jsonString = get.getInputStream().getText();
                        get=null;
                        println("befor parsing"+jsonString);
                        def jsonObj = readJSON text: jsonString
                        println("after parsing");
                        println(jsonObj['status']);
                        assert jsonObj['status'] == 'UP'
                        jsonString=null;
                        jsonObj=null;
                    }
                    get=null;
                    getRC=null;
                }
            }
        }
    }
}
