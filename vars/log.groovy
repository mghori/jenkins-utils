#!/usr/bin/env groovy
import gov.ca.cwds.jenkins.Logger

def call(String message) {
  def config = new HashMap()
  def binding = getBinding()
  config.putAll(binding.getVariables())
  Logger.setOutput(config['out'])
  
  logger = new Logger(message)
  smokeTest.runSmokeTest(path);
}
