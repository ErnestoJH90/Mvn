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
                bat 'mvn clean package'
                //bat 'cd kt-jen & mvn clean package'
                //bat 'java -cp target/kt-jen-1.0-SNAPSHOT.jar com.kt-jen.app.App'
                //bat 'cd kt-jen/target && java -jar kt-jen.jar > Reports.txt'
            }
        }
        /**stage('Delivery'){
            steps{
                archiveArtifacts artifacts: 'Reports.txt', followSymlinks: false
            }
        **/}
    }
}