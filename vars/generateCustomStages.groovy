def call(List name) {

	def stageName = "stage $name"

  return {
			stage("$stageName") {
					steps {
							echo "Hello $name from custom $stageName"
					}
			}
  }

}
