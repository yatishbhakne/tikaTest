ThisBuild / scalaVersion := "2.13.8"

val tika = Seq(
  libraryDependencies ++= Seq(
    "org.apache.tika" % "tika-core" % "2.4.1",
    "org.apache.tika" % "tika-parsers" % "2.4.1" pomOnly()
  )
)

val logback = {
  val version = "1.2.11"
  Seq(
    libraryDependencies ++= Seq(
      "ch.qos.logback" % "logback-core" % version,
      "ch.qos.logback" % "logback-classic" % version,
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    )
  )
}

lazy val app = (project in file("app"))
  .settings(
    assembly / assemblyJarName := "tikaTest.jar",
    tika ++ logback,
    dockerBaseImage := "openjdk:8-jre-alpine",
    Docker / packageName := "yatishbhakne/tika-test"
    // more settings here ...
  ).enablePlugins(DockerPlugin)
    .enablePlugins(AshScriptPlugin)
