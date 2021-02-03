pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
        jdk 'jdk-15.0.2'
    }
    stages {
        stage ('Install Mvn') {
            steps {
                bat '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                bat 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        stage('Build') {
            steps {
                bat 'mvn -version'
            }
        }
        }
    }
}