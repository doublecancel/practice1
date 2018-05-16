package com.example

/**
  * Created by Administrator on 2017/12/12.
  */
object Formatter {
  def main(args: Array[String]): Unit = {


    val str = "< div style = \"border-bottom: 1px #dedede solid;\" >\n"+
      " <table class=\"gridtable\" style=\"border-width: 0px;\">\n"+
      "   <tr>\n"+
      "     <td style=\"border-width: 0px;width:400px;\" colspan=\"2\">关联渠道：DKIF2568945</td>\n"+
      "  </tr>\n"+
      " </table>\n"+
      " </ div >\n"+
    " <div style=\"border-bottom: 1px #dedede solid;\"\n"+
      "   <table class=\"gridtable\" style=\"border-width: 0px;\">\n"+
      "    <tr>\n"+
      "      <td style=\"border-width: 0px;width:200px;\">批次名称：测试批次1</td>\n"+
      "      <td style=\"border-width: 0px;width:200px;\">包内兑换券数量：10</td>\n"+
      "    </tr>\n"+
      "   <tr>\n"+
      "     <td style=\"border-width: 0px;width:400px;\" colspan=\"2\">兑换券号：KF124556，KF124556，KF124556，KF124556，...</td>\n"+
          "   </tr>\n"+
    "  </table>\n"+
    "</div>'"


    format(str)
  }

  def format(str : String) = {
    str.split("\n").foreach(a => println("html += '" + a + "';"))
  }

}
