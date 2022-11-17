[
    artifactsDir: 'artifacts',
    repositories: [
        'vi-core': [
            url: 'https://github.com/markus696/data_mover.git',
            credsId: '5cfad9ed-0b3b-4175-8312-2777cd718a3b',
            branch: "${STRING_BRANCH_VICORE}",
        ],
        'vi-third-party': [
            url: 'https://github.com/markus696/data_mover.git',
            credsId: '5cfad9ed-0b3b-4175-8312-2777cd718a3b',
            branch: "${STRING_BRANCH_THIRD_PARTY}",
        ],
        'dlcommon': [
            url: 'https://github.com/markus696/data_mover.git',
            credsId: '5cfad9ed-0b3b-4175-8312-2777cd718a3b',
            branch: "${STRING_BRANCH_DLCOMMON}",
        ]
    ]
]