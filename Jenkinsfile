  
def gv

pipeline {
    agent any
    // agent {label "aws"}
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
                  git 'https://github.com/abdelrahman179/nodejs_app.git'
              }

          }
        stage("CI") {
            steps {
                script {
                    gv.CI()
                }
            }
        }
        stage("CD") {
            steps {
                script {
                    gv.CD()
                }
            }
        }
        post {
          success {
              slackSend(color: "good", message: "Nodejs app image built, pushed and up and running on port 3000.")
          }
          failure {
              slackSend(color: "danger", message: "Nodejs app failed to build the image")
          }
        }
    }   
}
