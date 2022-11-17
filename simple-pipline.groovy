def vi_module(path) {
    evaluate readTrusted(path)
}

vi_module 'some-module.groovy'

pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                script {
                    def config = readYaml file: 'configs/ik5/config.yaml'
                    echo config.toString()
                }
                /*dir('repos') {
                    checkout([$class: 'GitSCM',
                              branches: [[name: 'master']],
                              userRemoteConfigs: [[url: 'https://github.com/markus696/data_mover.git']]])
                }*/
            }
        }
    }
}

