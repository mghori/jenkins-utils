#!/usr/bin/env groovy

import gov.ca.cwds.jenkins.semver.LabelChecker

def call(String projectName) {
  echo "projectName"
  echo projectName
  labelChecker = new LabelChecker(this)
  labelChecker.check(projectName)
}
