package gov.ca.cwds.jenkins

class SmokeTest {
  def path

  SmokeTest(path) {
    this.path = path
  }
  
  def runSmokeTest(path) {
    echo smoketest
    println "smoketest"
    println path
    println "test"
  }
  
}
