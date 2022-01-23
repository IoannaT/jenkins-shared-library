def call(){
		def namesFile = libraryResource(resource: 'com/tsinky/names.json')
		def namesJsonObj = parseJson(namesFile)
		return namesJsonObj
}
