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
            '-Divy.engine.list.url=http://zugprojenkins/job/ivy-core_product/job/master/lastSuccessfulBuild/ '
        }
        archiveArtifacts '*/target/*.jar'
        junit '**/target/surefire-reports/**/*.xml'
      }
    }
  }
}
