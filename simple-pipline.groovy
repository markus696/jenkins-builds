def some_pipeline_module

pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                script {
                    some_pipeline_module = load 'some-pipeline.groovy'
                    echo 'Hello world!'
                    echo "${some_pipeline_module.a}"
                }

            }
        }
    }
}

def func(path) {
    load path
}