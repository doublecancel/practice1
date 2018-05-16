package utils

import java.sql.DriverManager

import org.jooq.impl.DSL

import scala.util.Random

/**
  * Created by Administrator on 2017/12/20.
  */
object InsertSmsMonitorLog {

  def main(args: Array[String]): Unit = {

    (1 to 100).foreach(_ => insert)

  }

  def getContext = {
    DSL.using(connection)
  }

  def insert = {
    getContext.insertInto(DSL.table("tb_ucpaas_sms_monitor_log"),
      DSL.field("account"),
      DSL.field("real_name"),
      DSL.field("user_type"),
      DSL.field("sid"),
      DSL.field("mobile"),
      DSL.field("trigger_quota"),
      DSL.field("quota_id"),
      DSL.field("sms_type"),
      DSL.field("warn_type"),
      DSL.field("warn_content"),
      DSL.field("create_date"),
      DSL.field("status")
    ).values(
      "账号1",
      "真实名称",
      random(4).toString,
      "c239b6f3aec69b14ace0ae129a9547c1",
      "13120971538",
      getTriggerName,
      "6",
      getSmsType,
      "1",
      "【云之讯】请求异常，时间01:00-02:00 账号sakura828@163.com（A），认证名 云之讯有限公司，请求总数9898989失败50.0%，异常：超频30.0%，账户余额不足15.0% ，应用余额不足4.0%其他1.0%，建议：检测用户是否有做图像验证",
      "2017-12-20",
      "1"
    ).execute

  }

  def random(a : Int) = {
    Random nextInt a
  }

  def getTriggerName = {
    val list = List("触发超频", "触发黑名单", "触发白名单")
    list apply random(3)
  }

  def getSmsType : String = {
    val list = List(0, 4, 5)
    (list apply random(3)).toString
  }

  val connection = DriverManager.getConnection(
    "jdbc:mysql://172.16.5.58:3306/ucpaas?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true",
    "root",
    "Ucpaas@D!A#")

}
