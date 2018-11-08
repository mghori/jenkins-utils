package gov.ca.cwds.jenkins

class SmokeTest {
  def script
  def path

  SmokeTest(script, path) {
    this.script = script
    this.path = path
  }
  
  def runSmokeTest(path) {
     script.echo "running smoke test"
     def test = path.execute().text
    if (test.contains("smoketest failed")) {
        script.error ("'${test}'")
    }
  }
  
}
