plugins {
    java
    `maven-publish`
    groovy
    // signing
    kotlin("jvm") version "1.7.10"
}

val springBootVersion by extra("2.7.1")
val thymeleafVersion by extra("3.0.15.RELEASE")

group = "com.dra11y"
version = "1.2.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_13

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.thymeleaf:thymeleaf:$thymeleafVersion")
    implementation("org.springframework.boot:spring-boot-autoconfigure:$springBootVersion")
}

publishing {
    publications {
        create("mavenJava", MavenPublication::class) {
            from(components["java"])
        }
    }
}

// task javadocJar(type: Jar) {
//    classifier 'javadoc'
//    from javadoc
// }

// task sourcesJar(type: Jar) {
//    classifier 'sources'
//    from sourceSets.main.allSource
// }
//
// artifacts {
//    archives javadocJar, sourcesJar
// }
//
// signing {
//    useGpgCmd()
//    sign configurations.archives
// }

// uploadArchives {
//    repositories {
//        mavenDeployer {
//            beforeDeployment { MavenDeployment deployment -> signing.signPom(deployment) }
//
//            repository(url: "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/") {
//                authentication(userName: ossrhUsername, password: ossrhPassword)
//            }
//
//            snapshotRepository(url: "https://s01.oss.sonatype.org/content/repositories/snapshots/") {
//                authentication(userName: ossrhUsername, password: ossrhPassword)
//            }
//
//            pom.project {
//                name 'asset-pipeline-thymeleaf-taglib'
//                description 'Thymeleaf taglib to simplify the use of the asset-pipeline'
//                packaging 'jar'
//                url 'https://github.com/itds-ch/asset-pipeline-thymeleaf-taglib'
//
//                scm {
//                    connection 'scm:git:https://github.com/itds-ch/asset-pipeline-thymeleaf-taglib.git'
//                    developerConnection 'scm:git:https://github.com/itds-ch/asset-pipeline-thymeleaf-taglib.git'
//                    url 'https://github.com/itds-ch/asset-pipeline-thymeleaf-taglib'
//                }
//
//                licenses {
//                    license {
//                        name 'The Apache License, Version 2.0'
//                        url 'http://www.apache.org/licenses/LICENSE-2.0.txt'
//                    }
//                }
//
//                developers {
//                    developer {
//                        id 'm.kobel'
//                        name 'Moritz Kobel'
//                        email 'moritz.kobel@itds.ch'
//                    }
//                }
//            }
//        }
//    }
// }
