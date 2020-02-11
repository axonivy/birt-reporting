pipeline {
  agent {
    dockerfile true
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: '5'))
  }

  triggers {
    cron '@midnight'
  }

  stages {
    stage('build') {
      steps {
        script {
          maven cmd: 'clean verify ' +
            '-Divy.engine.list.url=https://jenkins.ivyteam.io/job/ivy-core_product/job/master/lastSuccessfulBuild/ ' +
            '-Dmaven.test.failure.ignore=true '
        }
        archiveArtifacts '*/target/*.jar'
        junit '**/target/surefire-reports/**/*.xml'
      }
    }
  }
}
