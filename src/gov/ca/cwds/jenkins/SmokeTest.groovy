package gov.ca.cwds.jenkins

class SmokeTest {
  
  def runSmokeTest() {
    def test = sh (script: './test/smoketest.sh',  returnStdout: true)
    if (test.contains("smoketest passed")) {
          throw new Exception("'${test}'")
    }
  }
  
}
