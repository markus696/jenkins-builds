import java.io.File

def some_pipeline_module

func('some-module.groovy')

pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                script {
                    some_pipeline_module = load 'some-module.groovy'
                    echo 'Hello world!'
                    echo "${some_pipeline_module.a}"
                    echo "${a}"
                }

            }
        }
    }
}

def func(path) {
    evaluate readTrusted(path)
}