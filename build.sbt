name := """juge6-web-api"""
organization := "jp.juge6"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.10"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

// Adds additional packages into Twirl
// TwirlKeys.templateImports += "jp.juge6.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "jp.juge6.binders._"

mainClass in assembly := Some("play.core.server.ProdServerStart")
fullClasspath in assembly += Attributed.blank(PlayKeys.playPackageAssets.value)
excludeDependencies ++= Seq(
  ExclusionRule("javax.activation")
)
assembly / assemblyMergeStrategy := {
  case r if r.startsWith("reference.conf")          => MergeStrategy.concat
  case manifest if manifest.contains("MANIFEST.MF") =>
    MergeStrategy.discard
  case referenceOverrides
      if referenceOverrides.contains("reference-overrides.conf") =>
    MergeStrategy.concat
  case x => MergeStrategy.first
}