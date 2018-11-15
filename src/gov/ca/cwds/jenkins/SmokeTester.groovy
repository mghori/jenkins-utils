package gov.ca.cwds.jenkins

class SmokeTester {
  def script

  SmokeTester(script) {
    this.script = script
  }
  
  def runSmokeTest(path, url) {
    script.echo "${path}"
    script.echo "${path} ${url}"
    def test = script.sh (script: "${path} ${url}", returnStdout: true).trim()
    if (test.contains("smoketest passed")) {
        script.echo "smoke test passed"
        return "smoke test passed"
    }
    script.error ("'${test}'")
  }
  
}
