


vi_module "some-module.groovy"

pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                echo 'Hello world!'
                echo "${a}"
                throw 1
            }
        }
    }
}

def vi_module(String path) {
    evaluate(new File(path))
}