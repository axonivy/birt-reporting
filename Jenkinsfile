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
            maven cmd:'verify -Divy.engine.list.url=http://zugprobldmas/job/Linux_Trunk_DesignerAndServer/'
            archiveArtifacts '*/target/*.jar'
          }
          // -Dproject-build-plugin.version=7.2.0-SNAPSHOT
          // -Divy.engine.list.url=http://zugprobldmas/job/$SRC_JOB/
          // -Divy.engine.version=[7.1.0,]
      }
    }
  }
}
