package gov.ca.cwds.jenkins.semver

class SemVer {
  def script
  TagFetcher tagFetcher
  NewTagGenerator newTagGenerator
  PullRequestEvent pullRequestEvent
  VersionIncrement versionIncrement

  SemVer(script) {
    this.script = script
    this.tagFetcher = new TagFetcher(script)
    this.newTagGenerator = new NewTagGenerator()
    this.pullRequestEvent = new PullRequestEvent(script)
    this.versionIncrement = new VersionIncrement()
  }

  def newTag(label) {
    script.echo "label1"
    script.echo label
    def existingTags = tagFetcher.getTags()
    script.echo "existingTags"
    script.echo existingTags
    if (!IncrementTypes.values().collect({ it.toString()}).contains(label.toUpperCase())) {
      def event = pullRequestEvent.getEvent()
      def labels = event.labels.collect([]) { it.name }
      label = versionIncrement.increment(labels)
    } else {
      label = label.toUpperCase() as IncrementTypes
    }
    script.echo "label2"
    script.echo label
    script.echo existingTags
    newTagGenerator.newTag(existingTags, label)
  }
}
