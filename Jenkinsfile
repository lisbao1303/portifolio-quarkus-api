pipeline {
    agent any
    environment {
        GCP_PROJECT = 'restapispringboot'
        REGION = 'us-central1'
        IMAGE_NAME = 'portifolio-quarkus-api'
        DOCKER_REGISTRY = "${REGION}-docker.pkg.dev/${GCP_PROJECT}/quarkus-app"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Prepare Environment') {
                    steps {
                        // Carregar o arquivo secreto
                        withCredentials([file(credentialsId: 'env_port_quarkus', variable: 'ENV_FILE')]) {
                            // Copiar o arquivo .env para o workspace
                            sh 'cp $ENV_FILE .env'
                        }
                    }
        }
        stage('Build Quarkus Application') {
            steps {
                sh 'mvn clean package -Dquarkus.package.type=uber-jar'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_REGISTRY}/${IMAGE_NAME}:latest")
                }
            }
        }
        stage('Authenticate with Google Cloud') {
                    steps {
                        script {
                            // Usando a credencial da conta de serviço do Google Cloud
                            withCredentials([file(credentialsId: 'my-google-cloud-service-file', variable: 'GOOGLE_CREDENTIALS_JSON')]) {
                                // Ativar as credenciais da conta de serviço uma vez no início do pipeline
                                sh """
                                    export GOOGLE_APPLICATION_CREDENTIALS=\$GOOGLE_CREDENTIALS_JSON
                                    gcloud auth activate-service-account --key-file=\$GOOGLE_APPLICATION_CREDENTIALS
                                    gcloud config set project $GCP_PROJECT
                                """
                            }
                        }
                    }
                }
        stage('Push Docker Image') {
            steps {
                            script {
                                // Autentica o Docker com o Google Cloud Registry
                                sh """
                                    gcloud auth configure-docker ${REGION}-docker.pkg.dev --quiet
                                    docker push ${DOCKER_REGISTRY}/${IMAGE_NAME}:latest
                                """
                            }
                        }
        }
        stage('Deploy to Cloud Run') {
            steps {
                sh """
                gcloud run deploy ${IMAGE_NAME} \
                  --image ${DOCKER_REGISTRY}/${IMAGE_NAME}:latest \
                  --platform managed \
                  --region ${REGION} \
                  --allow-unauthenticated \
                  --project ${GCP_PROJECT}
                """
            }
        }
    }
    post {
        success {
            echo "Deploy realizado com sucesso!"
        }
        failure {
            echo "Erro durante o deploy."
        }
    }
}
