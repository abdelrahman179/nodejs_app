  
def gv

pipeline {
    agent any
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('preparation') {
              steps {
                  // Get some code from a GitHub repository
                  git 'https://github.com/abdelrahman179/nodejs_app.git'
              }

          }
        stage("CI") {
            steps {
                script {
                    echo "Building the app ... "
                    gv.CI()
                }
            }
        }
        stage("CD") {
            steps {
                script {
                    echo "Deploying to DockerHub ... "
                    gv.CD()
                }
            }
        }
    }   
}
