pipeline{
    agent any
        tools{
            maven 'Maven'
        }
        stages {
        stage('SCM'){
            steps{
               git 'https://github.com/ErnestoJH90/Mvn.git'
            }
        }
        stage ('Build') {
            steps {
                    unstash 'kt-jen'
                    bat 'cd kt-jen && mvn clean package'
                    bat 'cd kt-jen/target && java -jar kt-jen.jar > report.txt'
                    stash includes: 'mvn/kt-jen/target/kt-jen/report.txt', name: 'report', allowEmpty: false
                
            }
        }

        stage ('Package Mvn Project') {
            steps {
                
                bat 'mvn clean install'
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
        }
    }