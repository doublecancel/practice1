package utils

import java.sql.DriverManager

import org.jooq.SQLDialect
import org.jooq.impl.DSL

/**
  * Created by Administrator on 2017/12/22.
  */
object InsertSmsRequest {


  val connection = DriverManager.getConnection(
    "jdbc:mysql://172.16.5.58:3306/ucpaas?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true",
    "root",
    "Ucpaas@D!A#")


  def context = DSL.using(connection, SQLDialect.MYSQL)

  def createTable = {

    context.createTable(DSL.table(""))


  }

  def main(args: Array[String]): Unit = {

  }





}
