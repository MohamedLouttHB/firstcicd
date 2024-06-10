pipeline {
    agent any
    tools{
        maven 'maven'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MohamedLouttHB/firstcicd']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t firstcicd .'
                }
            }
        }
               stage('Push image to dockerhub') {
                   steps {
                       script {
                           // Login to Docker Hub
                           withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                               sh 'echo $DOCKERHUB_PASSWORD | docker login -u $DOCKERHUB_USERNAME --password-stdin'
                           }

                           // Push Docker image to Docker Hub
                           sh 'docker tag firstcicd:latest medloutt/firstcicd:latest'
                           sh 'docker push medloutt/firstcicd:latest'
                       }
                   }
               }
           }
}