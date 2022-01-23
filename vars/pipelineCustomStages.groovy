import com.tsinky.DemoName

def call() {

		def listNames = []
		def testStages = [:]

    pipeline{

        agent {
          label "mac"
        }

      	stages {
						stage("generate custom stages") {
								steps {
										script {
												listNames.add("Ioanna")
												listNames.add("Tsinky")

												listNames.each
												{name->
															testStages.put (name, generateCustomStages())
												}
										}
								}
						}
						when {
								expression{ !testStages.empty }
						}
						stages {
								script{
										for (stage in testStages.values()){
												stage.call()
										}
								}
						}
				}
		}
}
