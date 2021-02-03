pipeline {
    agent any

       tool name: 'Maven', type: 'maven'
    
    stages {
        stage('SCM'){
            steps{
               git 'https://github.com/ErnestoJH90/Mvn.git'
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
                bat 'sh \'mvn -Dmaven.test.failure.ignore=true install\'' 
            }
            post {
                success {
                   bat ' junit \'target/surefire-reports/**/*.xml\' '
                }
            }
        stage('Mvn version') {
            steps {
                bat 'mvn -version'
            }
        }
        }
    }
}