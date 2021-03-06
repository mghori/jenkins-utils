package gov.ca.cwds.jenkins.semver

class TagFetcher {
  def script

  def TagFetcher(script) {
    this.script = script
  }

  def getTags() {
    script.echo "getTags"
    def pwd = script.sh(script: "pwd", returnStdout: true)
    script.echo pwd
    def rawTags = script.sh(script: "git tag", returnStdout: true)
    script.echo "rawTags"
    script.echo rawTags
    def list = rawTags.split("\n").findAll { it =~ /(^\d+\.\d+\.\d+)/ }
    script.echo "list collect"
    list.collect { tag ->
       (tag =~ /(^\d+\.\d+\.\d+)/).with { it.hasGroup() ? it[0][0] : null }
    }.unique()
  }
}
