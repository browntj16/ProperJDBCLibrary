ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.6"

lazy val root = (project in file("."))
  .settings(
    name := "ProperJDBCProject",
    libraryDependencies += "com.oracle.database.jdbc" % "ojdbc17" % "23.8.0.25.04"
  )
