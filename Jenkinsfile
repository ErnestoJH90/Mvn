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

        stage ('Build Mvn Project') {
            steps {
                bat 'mvn -Dmaven.test.failure.ignore=true install'
            }
            post {
                success {
                   bat ' junit /target/surefire-reports/hello/world.xml '
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
        }
    }