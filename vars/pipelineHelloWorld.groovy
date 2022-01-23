import com.tsinky.DemoName

def call(nodeName) {

		// scripted pipeline
		node (nodeName) {
		    stage ("intro") {

						// retrieve nickname from resources
						def namesJsonObj = loadResourceFile()
						def nicknameStr = namesJsonObj.names.nickname
						echo "${nicknameStr}"

						// use src class to get firstname
						def demoName = new DemoName()
			      def myname =  demoName.getName('firstname')
			      sh "echo Hello $myname"

			      // Call another global var
			      helloWorld()

				}
		}
}
