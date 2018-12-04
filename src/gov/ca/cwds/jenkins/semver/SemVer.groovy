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
    script.echo "newTag label"
    script.echo label
    def existingTags = tagFetcher.getTags()
    script.echo "existingTags"
    if (!IncrementTypes.values().collect({ it.toString()}).contains(label.toUpperCase())) { 
      script.echo "increment 1"
      //def event = pullRequestEvent.getEvent()
      script.echo "pull request event"
      //def labels = event.labels.collect([]) { it.name }
      def labels = ["patch"]
      script.echo "pull request event labels"
      label = versionIncrement.increment(labels)
    } else {
      script.echo "increment 2"
      label = label.toUpperCase() as IncrementTypes
    }
    script.echo "label2"
    newTagGenerator.newTag(existingTags, label)
  }
}
