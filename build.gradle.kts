import jdk.jfr.Configuration.create

plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

sourceSets.create("jmh").java {
    srcDirs("src/jmh/java")
}


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    "jmhImplementation"("org.openjdk.jmh:jmh-core:1.35")
    "jmhImplementation"("org.openjdk.jmh:jmh-generator-annprocess:1.35")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<JavaExec>("jmh") {
    dependsOn("jmhClasses")
    mainClass.set("org.openjdk.jmh.Main")
    classpath = sourceSets["jmh"].runtimeClasspath
}

tasks.classes {
    finalizedBy("jmhClasses")
}
