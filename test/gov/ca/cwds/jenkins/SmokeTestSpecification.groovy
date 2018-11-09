package gov.ca.cwds.jenkins

import spock.lang.Specification

class SmokeTestSpecification extends Specification {

  class PipeLineScript {
    def build(hash) {
    }

    def PipeLineScript() { }
  }

  def "#runSmokeTest"() {
    def buildArguments

    given:
    def pipeline = Mock(PipeLineScript)
    def passed = './test/resources/smoketest/passed.sh'
    def failed = './test/resources/smoketest/failed.sh'
    def smokeTestPassed = new SmokeTest(pipeline, passed)
    def smokeTestFailed = new SmokeTest(pipeline, failed)
    

    when:
    def smoke = smokeTestPassed.runSmokeTest(passed)
    def smoke1 = smokeTestFailed.runSmokeTest(failed)

    then:
    smoke == "smoke test passed"
    smoke1  == "smoke test failed"

  }
}