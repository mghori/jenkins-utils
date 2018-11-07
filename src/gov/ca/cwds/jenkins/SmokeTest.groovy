package gov.ca.cwds.jenkins

class SmokeTest {
  def path

  SmokeTest(path) {
    this.path = path
  }
  
  def runSmokeTest(path) {
    echo "smoketest"
    echo "${workspace}
    echo "${path}
    def test = sh (script: path,  returnStdout: true)
    echo "Test: ${test}"
    if (test.contains("smoketest passed")) {
          throw new Exception("'${test}'")
    }
  }
  
}
