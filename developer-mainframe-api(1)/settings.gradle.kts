rootProject.apply {
  name = "developer-mainframe-api"
}

pluginManagement {
  repositories {
    maven {
      url = uri("${System.getProperty("user.home")}/.m2/repository")
    }
    gradlePluginPortal()
  }
}


