val scala3Version = "3.5.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala-lifegame",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.3.0"
libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.4"
libraryDependencies += "co.fs2" %% "fs2-core" % "3.11.0"
