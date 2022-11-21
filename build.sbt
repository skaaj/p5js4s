ThisBuild / scalaVersion := "3.1.3"

resolvers += Resolver.defaultLocal

lazy val lib = (project in file("lib"))
  .settings(
    name := "p5js4s",
    organization := "io.skaaj"
  )
  .enablePlugins(ScalaJSPlugin)

lazy val samples = (project in file("samples"))
  .dependsOn(lib)
  .settings(
    name := "p5js4s-samples",
    version := "0.1",
    libraryDependencies += "io.skaaj" %%% "p5js4s" % "0.1.0-SNAPSHOT",
    scalaJSUseMainModuleInitializer := true
  )
  .enablePlugins(ScalaJSPlugin)
