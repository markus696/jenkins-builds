[
    artifactsDir: 'artifacts',
    repositories: [
        'vi-core': [
            url: 'https://github.com/markus696/data_mover.git',
            credsId: '5856b969-7a4f-46a7-b6df-3e10aa0a3355',
            branch: "${STRING_BRANCH_VICORE}",
        ],
        'vi-third-party': [
            url: 'https://github.com/markus696/data_mover.git',
            credsId: '5856b969-7a4f-46a7-b6df-3e10aa0a3355',
            branch: "${STRING_BRANCH_THIRD_PARTY}",
        ],
        'dlcommon': [
            url: 'https://github.com/markus696/data_mover.git',
            credsId: '5856b969-7a4f-46a7-b6df-3e10aa0a3355',
            branch: "${STRING_BRANCH_DLCOMMON}",
        ]
    ]
]