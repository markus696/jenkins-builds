def vi_module(path) {
    evaluate readTrusted(path)
}

def config

vi_module 'some-module.groovy'

pipeline {
    agent any
    parameters {
        string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
    }
    stages {
        stage('Stage 1') {
            steps {
                script {
                    config = vi_module('config.groovy')

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

