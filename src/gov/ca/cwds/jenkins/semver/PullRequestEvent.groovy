package gov.ca.cwds.jenkins.semver

class PullRequestEvent {
  def script

  PullRequestEvent(script) {
    this.script = script
  }

  def getEvent() {
    script.echo "pull_request_event"
    script.echo script.env.pull_request_event
    script.readJSON text: script.env.pull_request_event
  }
}
