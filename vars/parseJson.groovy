import groovy.json.JsonSlurperClassic

def call(String text) {
		def jsonSlurper = new JsonSlurperClassic()
		def jsonObj = jsonSlurper.parseText(text)
		return jsonObj
}
