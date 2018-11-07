#!/usr/bin/env groovy
import gov.ca.cwds.jenkins.ContainerScanner

def call(String path) {
  smokeTest = new SmokeTest(path)
  smokeTest.runSmokeTest(path);
}
