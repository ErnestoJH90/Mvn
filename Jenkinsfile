pipeline {
    agent any
    tools {
        maven 'maven 3.6.3'
        jdk 'jdk-15.0.2'
    }
    stages {
        stage('SCM'){
            steps{
               git url: 'https://github.com/ErnestoJH90/Mvn.git'
            }
        }
        stage ('Install Mvn') {
            steps {
                bat '''sh \'\'\'
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                \'\'\''''
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