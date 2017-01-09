lazy val calc = project.in(file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies in calc += "org.scalatestplus" %% "play" % "1.2.0" % "test"
