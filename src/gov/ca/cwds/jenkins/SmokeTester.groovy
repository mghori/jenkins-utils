package gov.ca.cwds.jenkins

class SmokeTester {
  def script

  SmokeTester(script) {
    this.script = script
  }
  
  def runSmokeTest(path) {
    
    def cmd = [path, script.SMOKE_TEST_URL]
    def test = cmd.execute().text
    if (test.contains("smoketest passed")) {
        script.echo "smoke test passed"
        return "smoke test passed"
    }
    script.error ("'${test}'")
    script.echo "smoke test failed"
    return "smoke test failed"
  }
  
}
