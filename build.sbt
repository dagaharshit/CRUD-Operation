name := "mycurd"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
     "mysql" % "mysql-connector-java" % "5.1.16",
     "com.typesafe" % "config" % "1.2.1",
     "ch.qos.logback" % "logback-classic" % "1.0.13",
     "org.scalatest"   %%       "scalatest"   %      "2.2.2"
)
	
