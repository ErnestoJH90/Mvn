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
                unstash 'kt-jen'
                bat 'cd kt-jen && mvn clean package'
                bat 'cd kt-jen/target && java -jar kt-jen.jar > Reports.txt'
                stash includes: 'kt-jen/target/kt-jen/Reports.txt', name: 'Reports', allowEmpty: false
            }
        }
        stage(Delivery){
            steps{
                unstash 'Reports'
                archiveArtifacts: 'Reports.txt', followSymlinks: false
            }
        }
    }
}