def CI() {
    echo "Building the docker image..."
     withCredentials([usernamePassword(credentialsId: 'Docker_Hub', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                    sh 'docker build . -f dockerfile -t abdelrahmanzaki179/node-js-app:2.1'
                    sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                    sh 'docker push abdelrahmanzaki179/node-js-app:2.1'
                }
} 

def CD() {
    echo 'Running the application on localhost:3000 successfully ... '
    withCredentials([usernamePassword(credentialsId: 'Docker_Hub', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                  sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                  sh 'docker run -p 3000:3000 -d abdelrahmanzaki179/node-js-app:2.1'
              }
} 

return this
