val cleanup = tasks.register("cleanup") {
    doLast {
        throw GradleException("cleanup should fail too!")
    }
	dependsOn("failing")
}

val failing = tasks.register("failing") {
	doFirst {
        throw GradleException("OH no! I Failed! I need cleanup!")
    }
    finalizedBy(cleanup)
}
