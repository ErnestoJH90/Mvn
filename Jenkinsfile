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
                
                bat 'cd kt-jen && mvn clean package'
                bat 'cd kt-jen/target && java -jar kt-jen.jar > Reports.txt'
            }
        }
        stage('Delivery'){
            steps{
                unstash 'Reports'
                archiveArtifacts artifacts: 'Reports.txt', followSymlinks: false
            }
        }
    }
}