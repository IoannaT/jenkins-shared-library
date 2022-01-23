import com.tsinky.DemoName

def call() {

		// declarative pipeline
    pipeline{
        agent {
          label "mac"
        }

        stages{
            stage("multiple_stages") {
                stages{
                    stage("first stage"){
                        steps{
														dir("atest"){
															echo "new dir atest created"
														}
                            helloWorld()
                        }
                    }

                    stage("second stage") {
                        steps{
                            script {
                                def demoName = new DemoName()
                                def myname =  demoName.getName('firstname')
                                sh "echo Hello $myname"
                            }
                        }
                    }
                }
            }
        }
    }
}
