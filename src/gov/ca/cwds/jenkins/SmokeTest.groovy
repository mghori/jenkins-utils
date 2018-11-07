package gov.ca.cwds.jenkins

class SmokeTest {
  def path

  SmokeTest(path) {
    this.path = path
  }
  
  def runSmokeTest(path) {
    println "smoketest"
    println path
    println "test"
    def boo = "${env.WORKSPACE}"
    println boo
  }
  
}
