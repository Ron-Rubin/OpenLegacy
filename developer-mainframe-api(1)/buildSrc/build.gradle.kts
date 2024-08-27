import java.util.Properties

repositories {
  gradlePluginPortal()
  mavenCentral()
  mavenLocal()
  val olUsername = "public"
  val olPassword = "AKCp8oho7Ry3trcRKpongThJAFkmjf1LYV4vADAuDQS5VDcCZuHTBN826YVURXKiHsEzTG3AG"
  maven {
    name = "openlegacy-m2-public"
    url = uri("https://openlegacy.jfrog.io/openlegacy/ol-public")
    credentials {
    username = olUsername
    password = olPassword
    }
  }
  maven {
    name = "ol-3rd-party-libs"
    url = uri("https://openlegacy.jfrog.io/openlegacy/ol-3rd-party-libs")
    credentials {
    username = olUsername
    password = olPassword
    }
  }
}

configurations.all {
  resolutionStrategy {
    val kotlinVersion: String by project
    val kotlinCoroutinesVersion: String by project
    val jacksonVersion: String by project
    cacheChangingModulesFor(0, TimeUnit.SECONDS)
    eachDependency {
      when {
        requested.group == "org.jetbrains.kotlin" -> {
        this.useVersion(kotlinVersion)
        }
        requested.group == "org.jetbrains.kotlinx" && requested.name.startsWith("kotlinx-coroutines") -> {
        this.useVersion(kotlinCoroutinesVersion)
        }
        requested.group == "com.fasterxml.jackson.core" -> {
        this.useVersion(jacksonVersion)
        }
      }
    }
  }
}

Properties().apply {
  val props = this
  rootDir.toPath().resolveSibling(Project.GRADLE_PROPERTIES).toFile().apply {
    val file = this
    file.inputStream().use {
    props.load(it)
    }
  }
}.forEach { key, value -> project.extra.set(key as String, value) }

dependencies {
  val openlegacyVersion: String by project
  implementation("io.openlegacy:core:$openlegacyVersion")
}
