name := "sql"

scalaVersion := "2.10.5"

libraryDependencies ++= Seq( "org.apache.spark" %% "spark-core" % "1.6.2" % "provided",
	"org.apache.spark" %% "spark-sql" % "1.6.2",
	"com.datastax.spark" %% "spark-cassandra-connector" %  "1.6.0-M2" withSources() withJavadoc()
);


