package gov.ca.cwds.jenkins

class Logger {

 // Standard output
private static out = System.out

public static setOutput(out) {
this.out = out
}


public static log(String message) {
Logger.out.println(message)
}
}

def config = new HashMap()
def binding = getBinding()
config.putAll(binding.getVariables())
Logger.setOutput(config['out'])

