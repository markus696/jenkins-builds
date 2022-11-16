import java.io.File

def some_pipeline_module

func('some-module.groovy')

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

def func(path) {
    evaluate readTrusted(path)
}