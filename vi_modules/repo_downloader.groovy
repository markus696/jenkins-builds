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
            gitPush(gitScm:[$class: 'GitSCM',
                    userRemoteConfigs: [[name: "refs/heads", credentialsId: "${repo.credsId}", url: "${repo.url}"]],
            ], targetRepo: "refs/heads", targetBranch: "${repo.branch}" )
        }
    }
}