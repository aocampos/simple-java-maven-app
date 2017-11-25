pipeline {
    agent none
    /*agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }*/
    stages {
        stage('Build') {
            agent { docker 'maven:3-alpine'}
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            agent { docker 'maven:3-alpine'}
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Create image') {
            agent { docker 'maven:3-alpine'}
            steps {
                sh 'mvn docker:build'
            }
        }
        /*stage('Publish image') {
            steps {
                sh 'docker push aocampos/my-app:latest'
            }
        }*/
        stage('Deploy') {
            agent { docker 'lachlanevenson/k8s-kubectl:v1.8.3'}
            steps {
                sh 'kubectl apply -f deployment.yaml'
            }
        }
    }
}