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
            sh "git checkout origin ${repo.branch}"
            sh 'git add .'
            sh 'git status'
            sh 'git commit -m "From Jenkins"'
            sh 'git push'
        }
    }
}