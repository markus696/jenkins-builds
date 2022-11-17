getRepositories = { config ->
    config.from.each { repoName, repo ->
        dir("${config.to}/${repoName}") {
            checkout([
                $class: 'GitSCM',
                branches: [[name: "${repo.branch}"]],
                userRemoteConfigs: [[/*credentialsId: "${repo.credsId}",*/ url: "${repo.url}"]]
            ])
        }
    }
}