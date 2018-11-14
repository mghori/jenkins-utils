package gov.ca.cwds.jenkins

class SmokeTester {
  def script

  SmokeTester(script) {
    this.script = script
  }
  
  def runSmokeTest(path) {
    
    def cmd = [path, "http://dashboard:8888/system-information"]
    def test = cmd.execute().text
    script.echo "TEST:'${test}'"
    script.echo script.SMOKE_TEST_URL
    if (test.contains("smoketest failed")) {
        script.error ("'${test}'")
        return "smoke test failed"
    }
    script.echo "smoke test passed"
    return "smoke test passed"
  }
  
}
