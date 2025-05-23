#!groovy

pipeline {

  agent any

  environment {
    git_commit_message = ''
    git_commit_diff = ''
    git_commit_author = ''
    git_commit_author_name = ''
    git_commit_author_email = ''
  }

  stages {


stage('Checkout') {
      steps {
        script {
           // The below will clone your repo and will be checked out to master branch by default.
           //git credentialsId: 'jenkins-user-github', url: 'https://github.com/aakashsehgal/FMU.git'

           git url: 'https://github.com/bettertester21/DatadrivenFrameworkCICD'
           // Do a ls -lart to view all the files are cloned. It will be clonned. This is just for you to be sure about it.
           sh "ls -lart ./*"
           // List all branches in your repo.
           sh "git branch -a"
           // Checkout to a specific branch in your repo.
           sh "git checkout main"
          }
       }
    }

    // Build
    stage('Build') {
      agent {
        label 'node'
      }
      steps {
        deleteDir()
        checkout scm
      }
    }

    // Static Code Analysis
    stage('Static Code Analysis') {
      agent {
        label 'node'
      }
      steps {
        deleteDir()
        checkout scm
        sh "echo 'Run Static Code Analysis'"
      }
    }

    // Unit Tests
    stage('Unit Tests') {
      agent {
        label 'node'
      }
      steps {
        deleteDir()
        checkout scm
        sh "echo 'Run Unit Tests'"
      }
    }

    // Acceptance Tests
    stage('Acceptance Tests') {
      agent {
        label 'node'
      }
      steps {
        deleteDir()
        checkout scm
        sh "echo 'Run Acceptance Tests'"
      }
    }

  }
  post {
    success {
      sh "echo 'Send mail on success'"
      // mail to:"me@example.com", subject:"SUCCESS: ${currentBuild.fullDisplayName}", body: "Yay, we passed."
    }
    failure {
      sh "echo 'Send mail on failure'"
      // mail to:"me@example.com", subject:"FAILURE: ${currentBuild.fullDisplayName}", body: "Boo, we failed."
    }
  }
}
