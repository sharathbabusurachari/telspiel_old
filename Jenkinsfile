pipeline {
    agent any
    tools {
        maven 'MAVEN'
        
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the env using pipeline'
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/sharathbabusurachari/telspiel']])
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }}
        stage('Test') {
            steps {
                echo 'Testing the env using pipeline'
            }}
        stage('Deploy') {
            steps {
                echo 'Deploying the env using pipeline'
                sh '''
                chmod 755 $WORKSPACE/javadeploy.sh;
                bash $WORKSPACE/javadeploy.sh;

                #echo "${status}"
                
                #if (status == 0) {
                #    echo "Deployment is Successful..."
                #} else {
                #    echo "Deployment is Failed..."
                 #   sh "exit 1"
                '''}
                }
            }

    post {
        always {
            junit(
                allowEmptyResults:true,
            testResults: '*test-reports/.xml'
            )
        }
    }
    
}
