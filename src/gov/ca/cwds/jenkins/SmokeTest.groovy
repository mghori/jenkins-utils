package gov.ca.cwds.jenkins

class SmokeTest {
  def path

  SmokeTest(path) {
    this.path = path
  }
  
  def runSmokeTest(path) {
    println "smoketest"
    println path
    def test = sh (script: path,  returnStdout: true)
    println test
    if (test.contains("smoketest passed")) {
          throw new Exception("'${test}'")
    }
  }
  
}
