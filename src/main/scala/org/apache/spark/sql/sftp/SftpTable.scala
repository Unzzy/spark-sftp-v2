package org.apache.spark.sql.sftp

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.connector.catalog.{ SupportsRead, SupportsWrite, Table, TableCapability }
import org.apache.spark.sql.connector.read.ScanBuilder
import org.apache.spark.sql.connector.write.{ LogicalWriteInfo, WriteBuilder }
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.util.CaseInsensitiveStringMap

import java.util
import scala.jdk.CollectionConverters.SetHasAsJava

final case class SftpTable(name: String, session: SparkSession, schema: StructType)
    extends Table
    with SupportsRead
    with SupportsWrite {

  override def capabilities(): util.Set[TableCapability] = Set(
    TableCapability.BATCH_READ,
    TableCapability.BATCH_WRITE,
  ).asJava

  override def newScanBuilder(options: CaseInsensitiveStringMap): ScanBuilder = SftpScanBuilder()

  override def newWriteBuilder(info: LogicalWriteInfo): WriteBuilder = SftpWriteBuilder()
}
