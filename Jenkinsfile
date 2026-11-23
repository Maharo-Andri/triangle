// TP2 - pipeline-triangle
// Before the first build, in Jenkins:
//   - Credentials: 'git_credentials' (GitHub user + personal access token)
//                  'dockerhub'       (Docker Hub user + access token)
//   - Tools: a Maven installation named 'Maven3'
// Replace CHANGE_ME below (GitHub user, Docker Hub user, e-mail).
pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        GITHUB_REPO = 'https://github.com/Maharo-Andri/triangle.git'
        IMAGE       = 'maharoandri/triangle:1.0.0'
    }

    stages {
        stage('git checkout') {
            steps {
                git credentialsId: 'git_credentials', url: "${GITHUB_REPO}", branch: 'main'
            }
        }

        stage('Build the application') {
            steps {
                sh 'mvn -B clean install -DskipTests'
            }
        }

        stage('Unit Test Execution') {
            steps {
                sh 'mvn -B test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Build the docker image') {
            steps {
                sh "docker build --tag ${IMAGE} ."
            }
        }

        stage('Push the docker image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub',
                                                  usernameVariable: 'DOCKERHUB_USER',
                                                  passwordVariable: 'DOCKERHUB_PASS')]) {
                    sh 'echo "$DOCKERHUB_PASS" | docker login -u "$DOCKERHUB_USER" --password-stdin'
                }
                sh "docker push ${IMAGE}"
            }
        }
    }

    post {
        failure {
            emailext body: 'Ce Build $BUILD_NUMBER a échoué : $BUILD_URL',
                     recipientProviders: [requestor()],
                     subject: 'build $JOB_NAME #$BUILD_NUMBER : échec',
                     to: 'mhrmaharo@gmail.com'
        }
    }
}
