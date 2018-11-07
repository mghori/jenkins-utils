package gov.ca.cwds.jenkins

class SmokeTest {
  def path

  SmokeTest(path) {
    this.path = path
  }
  
  def runSmokeTest(path) {
    Logger.log("smoketest")
    Logger.log(path)
    def test = path.execute().text
    Logger.log(test)
    if (test.contains("smoketest failed")) {
        throw new Exception("'${test}'")
    }
    Logger.log("message")
  }
  
}
