pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/amitb1989/todo-list.git'
            }
        }

        stage('Compile Java Code') {
            steps {
                bat 'javac *.java'  // Compile Java files
            }
        }

        stage('Run Java Program') {
            steps {
                bat 'java ToDoList'  // Change this to the main class
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '*.class', fingerprint: true
            }
        }

        stage('Cleanup') {
            steps {
                cleanWs()
            }
        }
    }
}
