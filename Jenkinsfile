pipeline{
    agent any

        stages {
        stage('SCM'){
            steps{
               git 'https://github.com/ErnestoJH90/Mvn.git'
            }
        }
        stage ('Install Mvn') {
            steps {
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                
            }
        }

        stage ('Package Mvn Project') {
            steps {
                
                bat 'mvn install'
            }
            post {
                success {
                   bat 'mvn clean package > report.txt'
                }
            }
        }
        stage('Mvn version') {
            steps {
                bat 'mvn -version'
            }
          }
        stage('test'){
            steps{
                bat 'mvn test'
              }
           }
    post{
       always{
          cleanWs()
               }
           }
        }
    }