getRepositories = { config ->
    dir("${config.to}") { deleteDir() }
    config.from.each { repoName, repo ->
        dir("${config.to}/${repoName}") {
            checkout([
                $class: 'GitSCM',
                branches: [[name: "*/${repo.branch}/*"]],
                userRemoteConfigs: [[url: "${repo.url}"]]
            ])
        }
    }
}