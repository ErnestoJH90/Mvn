pipeline{
    agent any

    tools {
        maven 'Mvn'
    }
    stages{
        stage('Checkout'){
            steps{
               checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/ErnestoJH90/Mvn']]])
               
            }
        }
        stage('Mvn Version'){
            steps{
                bat 'mvn --version'
            }
        }
        stage('Build'){
            steps{
                
                bat 'cd KtJenkins && mvn clean package'
                bat 'java -cp KtJenkins/target/KtJenkins-1.0-SNAPSHOT.jar com.KtJenkins.app.App'
                //bat 'cd KtJenkins && java -jar KtJenkins.jar > Reports.txt'
            }
        }
            
        /**stage('Delivery'){
            steps{
                archiveArtifacts artifacts: 'Reports.txt', followSymlinks: false
            }
        }**/
            
    }
    post {
       always {
         cleanWs()
         }
     }
}