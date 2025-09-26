pipeline{
    agent any

    tools {
        maven 'Mvn'
    }
    stages{
        stage('ejecutando en LinuxKt') {
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
        stage('Build') {
            steps {
                dir('KtJenkins') {
                    sh 'mvn clean package'
                    sh 'java -cp target/KtJenkins-1.0-SNAPSHOT.jar com.KtJenkins.app.App > ../Reports.txt'
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                dir('KtJenkins') {
                    script {
                        def mvnHome = tool 'Mvn'
                        withSonarQubeEnv() {
                            sh "${mvnHome}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Mvn -Dsonar.projectName='Mvn'"
                        }
                    }
                }
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
