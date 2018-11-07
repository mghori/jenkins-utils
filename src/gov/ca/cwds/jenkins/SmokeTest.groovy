package gov.ca.cwds.jenkins

class SmokeTest {
  def path

  SmokeTest(path) {
    this.path = path
  }
  
  def runSmokeTest(path) {
    out.println "smoketest"
    out.println path
    out.println "test"
  }
  
}
