pipeline{
    agent any

    tools {
        maven 'Mvn'
    }
    stages{
        stage('Checkout'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'Ernestojh_JenGitHub', url: 'https://github.com/ErnestoJH90/Mvn.git']])
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
                bat 'java -cp KtJenkins/target/KtJenkins-1.0-SNAPSHOT.jar com.KtJenkins.app.App > Reports.txt'
            }
        }
            
        stage('Delivery'){
            steps{
                archiveArtifacts artifacts: 'Reports.txt', followSymlinks: false
            }
        }
            
    }
    post {
       always {
         cleanWs()
         }
     }
}