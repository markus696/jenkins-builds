getRepositories = { config ->
    dir("${config.to}") { deleteDir() }
    config.repos.each { repoName, repo ->
        dir("${config.to}/${repoName}") {
            checkout([
                $class: 'GitSCM',
                branches: [[name: "*/${repo.branch}/*"]],
                extensions: [
                        [$class: 'CloneOption', noTags: true, reference: '', shallow: false]
                ],
                userRemoteConfigs: [[url: "${repo.url}"]]
            ])
            sh 'touch file'
            sh 'echo hello > file'
        }
    }
}

pushRepositories = { config ->
    config.repos.each { repoName, repo ->
        dir("${config.from}/${repoName}") {
            withCredentials([gitUsernamePassword(credentialsId: "${repo.credsId}", gitToolName: 'Default')]) {
                sh "git checkout ${repo.branch}"
                sh 'git add .'
                sh 'git commit -m "From Jenkins"'
                sh "git push"
            }
        }
    }
}