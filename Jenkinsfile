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
            maven cmd: 'verify -Divy.engine.list.url=http://zugprobldmas/job/Trunk_DesignerAndServer/ -Divy.engine.version=[7.1.0,]'
            archiveArtifacts '*/target/*.jar'
            junit '**/target/surefire-reports/**/*.xml' 
          }
      }
    }
  }
}
