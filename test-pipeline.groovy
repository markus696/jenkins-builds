#!/usr/bin/env groovy

def vi_include(String path) {
    evaluate readTrusted(path)
}

vi_include 'vi_modules/repo_downloader.groovy'

buildConfig = [:]

pipeline {
    agent { node('master') }
    environment {
        some = 'some'
    }

    parameters {
        string(name: 'STRING_BRANCH_VICORE'         , defaultValue: 'main', description: 'Ветка vi-core репозитория')
        string(name: 'STRING_BRANCH_THIRD_PARTY'    , defaultValue: 'main', description: 'Ветка vi-third-party репозитория')
        string(name: 'STRING_BRANCH_DLCOMMON'       , defaultValue: 'main', description: 'Ветка dlcommon репозитория')
    }

    stages {        
        stage('Initializing') {
            steps {
                script {
                    buildConfig = vi_include 'vi_configs/szvi-ik5.config.groovy'
                    getRepositories repos: buildConfig.repositories, to: "${WORKSPACE}/repos"



                    pushRepositories repos: buildConfig.repositories, from: "${WORKSPACE}/repos"
                }
            }
        }
    }

    post {       
        success {
            echo 'RESULT: SUCCESS!'   
        }
        failure {
            echo 'RESULT: FAILED!'
        }
        aborted {
            echo 'RESULT: ABORTED!'
        }

        fixed {
            echo 'RESULT: Build fixed!'
        }

        regression {
            echo 'RESULT: Build broken!'
        }

        always {
            echo 'PIPELINE FINISHED!'
        } 
    }
}