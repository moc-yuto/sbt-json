val toJson = taskKey[Unit]("show input json task")

val filename = "test.json"

// 共通設定
lazy val commonSettings = Seq(
  organization := "com.example",
  version := "0.1.0",
  scalaVersion := "2.11.4",
  scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Xlint")
)

// jsonプロジェクト設定
lazy val json = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    toJson := {
      ParseJson.open(filename)
    }
  )
