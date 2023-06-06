pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Use the checkout step to clone the Git repository
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/dev']], // Specify the branch you want to checkout
                        userRemoteConfigs: [[url: 'https://github.com/hardikhard28/android-jenkins.git']] // Specify your Git repository URL
                    ])
                }
            }
        }
        
        
    }
}