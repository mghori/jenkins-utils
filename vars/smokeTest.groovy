#!/usr/bin/env groovy
import gov.ca.cwds.jenkins.ContainerScanner

def call() {
  smokeTest = new SmokeTest()
  smokeTest.runSmokeTest();
}
