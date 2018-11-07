#!/usr/bin/env groovy
import gov.ca.cwds.jenkins.SmokeTest

def call(String path) {
  smokeTest = new SmokeTest(path)
  smokeTest.runSmokeTest(path);
}
