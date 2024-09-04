import sbt._

object Dependencies {

  object Version {
    val Spark = "3.3.0"
  }

  object Libraries {
    val sparkCore = "org.apache.spark" %% "spark-core" % Version.Spark
    val sparkSql  = "org.apache.spark" %% "spark-sql"  % Version.Spark % "provided"
  }

  val sftpConnector = Def.setting {
    import Libraries._

    Seq(
      sparkCore,
      sparkSql
    )
  }

}