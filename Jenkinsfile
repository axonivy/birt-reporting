pipeline {
  agent {
    dockerfile true
  }

  options {
    buildDiscarder(logRotator(artifactNumToKeepStr: '10'))
  }

  triggers {
    cron '@midnight'
  }

  stages {
    stage('build') {
      steps {
          script {
            maven cmd:'verify -Divy.engine.list.url=http://zugprobldmas/job/Trunk_All/'
          }
          // -Dproject-build-plugin.version=7.2.0-SNAPSHOT
          // -Divy.engine.list.url=http://zugprobldmas/job/$SRC_JOB/
          // -Divy.engine.version=[7.1.0,]
      }
      archiveArtifacts '*/target/*.jar'
    }
  }
}