
def some_pipeline = load 'some-pipeline.groovy'

pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                echo 'Hello world!'
                echo "${some_pipeline.a}"
            }
        }
    }
}