# jenkins-shared-library
Demo repo for Jenkins shared libraries usage.
--
Shared Library is *not* configured with Implicit import.

## Variations of Jenkinsfile, utilizing shared libraries

* Case A: Pipeline as global var
```
@Library("jenkins-shared-library") _
pipelineHelloWorld("mac")
```

* Case B: Declarative Pipeline, calling global var pipelineHelloWorld
```
@Library("jenkins-shared-library") _
pipeline {
   agent{ label "mac"}
   stages{
       stage("intro"){
           steps{
               script{
                   helloWorld()
               }
           }           
       }
   }
}
```

* Case C: Scripted Pipeline calling global var helloWorld
```
@Library("jenkins-shared-library") _
node("mac") {
     stage("test") {
         helloWorld()
     }
}
```

* Case D: Scripted Pipeline importing source class and calling global var
```
import com.tsinky.DemoName
@Library("jenkins-shared-library") _
node ("mac") {
    stage ("test") {

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
```
