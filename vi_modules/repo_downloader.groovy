getRepositories = { config ->
    dir("${config.to}") { deleteDir() }
    config.repos.each { repoName, repo ->
        dir("${config.to}/${repoName}") {
            checkout([
                $class: 'GitSCM',
                branches: [[name: "*/${repo.branch}/*"]],
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
            gitPush([
                    $class: 'GitSCM',
                    credentialsId: "${repo.credsId}",
                    userRemoteConfigs: [[url: "${repo.url}"]]
            ])
        }
    }
}