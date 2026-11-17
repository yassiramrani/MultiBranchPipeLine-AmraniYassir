pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
        timestamps()
    }

    stages {
        stage('Checkout') {
            steps {
                deleteDir()
                checkout scm
                echo "Branche Jenkins : ${env.BRANCH_NAME}"
                sh 'git log -1 --format="%h %s"'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B clean compile'
            }
        }
        stage('Test, package et exécution') {
            steps {
                sh 'mvn -B package'
                sh 'java -jar target/tp-multibranch.jar'
            }
        }
    }
    post {
        success {
            archiveArtifacts artifacts: 'target/tp-multibranch.jar', fingerprint: true
        }
    }
}
