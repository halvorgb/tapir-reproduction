name := "tapir-reproduction"

version := "0.1"

scalaVersion := "2.13.1"

val TapirVersion = "0.12.2"
val CirceVersion = "0.12.1"

resolvers in ThisBuild ++= Seq(
  "jitpack.io" at "https://jitpack.io"
)

libraryDependencies in ThisBuild ++= List(
  "com.softwaremill.sttp.tapir" %% "tapir-core" % TapirVersion,
  "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % TapirVersion,
  "io.circe" %% "circe-generic" % CirceVersion,
  "io.circe" %% "circe-generic-extras" % CirceVersion
)