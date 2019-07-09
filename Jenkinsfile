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
          maven cmd: 'verify ' +
          '-Dproject-build-plugin.version=7.4.0-SNAPSHOT ' +
          '-Divy.engine.list.url=http://zugprojenkins/job/ivy-core_product/job/master/lastSuccessfulBuild/ ' +
          '-Divy.engine.version=[7.1.0,]'
        }
        archiveArtifacts '*/target/*.jar'
        junit '**/target/surefire-reports/**/*.xml'
      }
    }
  }
}
