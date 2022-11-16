import java.io.File

def some_pipeline_module

vi_module 'some-module.groovy'

pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                script {
                    echo 'Hello world!'
                    echo "${a}"
                }

            }
        }
    }
}

def vi_module(path) {
    evaluate readTrusted(path)
}