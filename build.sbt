import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "diffie-helman",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.16"
  )
