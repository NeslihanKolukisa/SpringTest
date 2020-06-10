pipeline {
    agent any
     tools {
            maven 'maven'
    }
    stages {
            stage('Compile Stage') {
                steps {
                        sh 'mvn clean compile'

                }
            }
            stage('Test') {
                steps {
                        sh 'mvn test'
                }
            }
        }
}