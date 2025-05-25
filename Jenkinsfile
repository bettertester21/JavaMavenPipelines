// pipeline {
//     agent any
//     stages {
//         stage('Build') {
//             steps {
//                 sh 'mvn -B -DskipTests clean package'
//             }
//         }
//     }
// }

String url = 'https://github.com/bettertester21/JavaMavenPipelines.git';
String[] res = url.split('/');
String repoName = res[res.length-1];
if (repoName.endsWith('.git')) repoName=repoName.substring(0, repoName.length()-4);

checkout([
  $class: 'GitSCM',
  branches: [[name: 'refs/heads/'+env.BRANCH_NAME]],
  doGenerateSubmoduleConfigurations: false,
  extensions: [
    [$class: 'RelativeTargetDirectory', relativeTargetDir: repoName],
    [$class: 'GitLFSPull'],
    [$class: 'CheckoutOption', timeout: 20],
    [$class: 'CloneOption',
        depth: 3,
        noTags: false,
        reference: '/other/optional/local/reference/clone',
        shallow: true,
        timeout: 120],
    [$class: 'SubmoduleOption', depth: 5, disableSubmodules: false, parentCredentials: true, recursiveSubmodules: true, reference: '', shallow: true, trackingSubmodules: true]
  ],
  submoduleCfg: [],
  userRemoteConfigs: [
    [credentialsId: 'foobar',
    url: url]
  ]
])