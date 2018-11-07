package gov.ca.cwds.jenkins

class SmokeTest {
  def path

  SmokeTest(path) {
    this.path = path
  }
  
  def runSmokeTest(path) {
    Logger.log("smoketest")
    Logger.log(path)
    Logger.log("message")
  }
  
}
