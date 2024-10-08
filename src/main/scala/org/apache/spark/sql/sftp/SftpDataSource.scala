package org.apache.spark.sql.sftp

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.connector.catalog.{ Table, TableProvider }
import org.apache.spark.sql.connector.expressions.Transform
import org.apache.spark.sql.sources.DataSourceRegister
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.util.CaseInsensitiveStringMap

import java.util

final class SftpDataSource extends TableProvider with DataSourceRegister {

  override def inferSchema(options: CaseInsensitiveStringMap): StructType = new StructType()

  override def getTable(
      schema: StructType,
      partitioning: Array[Transform],
      properties: util.Map[String, String]
  ): Table = SftpTable("sftp", SparkSession.active, schema)

  override def shortName(): String = "sftp"
}
