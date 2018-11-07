package gov.ca.cwds.jenkins

class SmokeTest {
  def path

  SmokeTest(path) {
    this.path = path
  }
  
  def runSmokeTest(path) {
     def test = path.execute().text
    if (test.contains("smoketest failed")) {
        throw new Exception("'${test}'")
    }
  }
  
}
