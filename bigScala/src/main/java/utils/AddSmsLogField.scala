package utils

import java.sql.DriverManager

import org.jooq.impl.DSL

/**
  * Created by Administrator on 2018/1/22.
  */
class AddSmsLogField {

  def main(args: Array[String]): Unit = {

  }


  val connection = DriverManager.getConnection(
    "jdbc:mysql://172.16.5.58:3306/ucpaas_statistics?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true",
    "root",
    "Ucpaas@D!A#")


  def getSmsLogTables = {
    getContext
  }

  def getContext = {
    DSL.using(connection)
  }

}
