pipeline{
    agent any

    tools {
        maven 'Mvn'
    }
    stages{
        stage('ejecutando en el master') {
            steps {
                sh 'ip addr show' // Solo Linux
            }
        }
        stage('Verify Branch') {
            steps {
                echo "${env.GIT_BRANCH}"
            }
        }
        stage('Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/LinuxKt']], extensions: [], userRemoteConfigs: [[credentialsId: '78829de0-82f4-4ff1-a6e2-7eb7a5182d5e', url: 'https://github.com/ErnestoJH90/Mvn.git']])
            }
        }
        stage('Mvn Version') {
            steps {
                sh 'mvn --version'
            }
        }
        stage('Build'){
            steps{
                sh 'cd KtJenkins && mvn clean package'
                sh 'java -cp KtJenkins/target/KtJenkins-1.0-SNAPSHOT.jar com.KtJenkins.app.App > Reports.txt'
            }
        }
        //stage('SonarQube Analysis') {
          //  def mvn = tool 'Default Maven';
            //withSonarQubeEnv() {
              //  sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Mvn -Dsonar.projectName='Mvn'"
            //}
        //}
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