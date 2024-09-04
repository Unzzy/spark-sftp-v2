package org.apache.spark.sql.sftp

import org.apache.spark.sql.connector.read.{ Scan, ScanBuilder }

final case class SftpScanBuilder() extends ScanBuilder {
  override def build(): Scan = ???
}
