pipeline {
    agent any

    environment {
        SONARQUBE_SERVER = 'LocalSonarQube'  // SonarQube configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/amitb1989/todo-list.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'  // Use `bat` instead of `sh` on Windows
            }
        }

        stage('SonarQube Scan') {
            steps {
                withSonarQubeEnv('LocalSonarQube') {
                    bat 'mvn sonar:sonar -Dsonar.projectKey=Java_project_pipeline -Dsonar.host.url=http://localhost:9000 -Dsonar.login=squ_4e3cff0dde1de5dd0ab7aa1d3916f882647218d2'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Upload Build Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }

        stage('Cleanup') {
            steps {
                cleanWs()
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
