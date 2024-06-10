pipeline {
    agent any
    tools{
        maven 'maven'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MohamedLouttHB/firstcicd']]])
                sh 'mvn clean install'
            }
        }

        stage('Build image') {
            steps {
                script {
                    // Build Docker image
                    sh 'docker build -t firstcicd .'
                }
            }
        }

        stage('Push image') {
            steps {
                script {
                    // Login to Docker Hub
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                        sh 'echo $DOCKERHUB_PASSWORD | docker login -u $DOCKERHUB_USERNAME --password-stdin'
                    }

                    // Tag Docker image
                    sh 'docker tag firstcicd:latest medloutt/firstcicd:latest'

                    // Push Docker image to Docker Hub with debug information
                    sh 'docker push medloutt/firstcicd:latest'
                }
            }
        }
    }
}
