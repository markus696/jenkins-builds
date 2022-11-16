
def some_pipeline_module

pipeline {
    agent any
    stages {
        stage('Stage 1') {
            some_pipeline_module = load 'some-pipeline.groovy'
            steps {
                echo 'Hello world!'
                echo "${some_pipeline_module.a}"
            }
        }
    }
}