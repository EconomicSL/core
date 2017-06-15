publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) {
    Some("snapshots" at nexus + "content/repositories/snapshots")
  } else {
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
  }
}

publishMavenStyle := true

pomExtra := {
  <url>https://github.com/EconomicSL/core</url>
  <licenses>
    <license>
      <name>The Apache Software License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
    </license>
  </licenses>
  <scm>
    <connection>scm:git:github.com/EconomicSL/core.git</connection>
    <developerConnection>scm:git:git@github.com/EconomicSL/core.git</developerConnection>
    <url>github.com/EconomicSL/core.git</url>
  </scm>
  <developers>
    <developer>
      <id>davidrpugh</id>
      <name>David R. Pugh</name>
      <url>http://davidrpugh.github.io/</url>
    </developer>
  </developers>
}
