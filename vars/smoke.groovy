#!/usr/bin/env groovy
import gov.ca.cwds.jenkins.SmokeTest

def call(String path) {
  smokeTest = new SmokeTest(this, path)
  smokeTest.runSmokeTest(path);
}
