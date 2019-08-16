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
          maven cmd: 'clean verify sonar:sonar ' +
            '-Divy.engine.list.url=http://zugprojenkins/job/ivy-core_product/job/master/lastSuccessfulBuild/ ' +
            '-Dsonar.host.url=http://zugprosonar ' +
            '-Dsonar.projectKey=birt-reporting '
        }
        archiveArtifacts '*/target/*.jar'
        junit '**/target/surefire-reports/**/*.xml'
      }
    }
  }
}
