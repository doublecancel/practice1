package com.IOTest

/**
  * Created by Administrator on 2017/12/25.
  */
object Test1 {

  def main(args: Array[String]): Unit = {

    import scala.io._
    val source = Source.fromFile("F:\\github\\practice\\bigScala\\src\\main\\scala\\com\\IOTest\\Test1.scala", "UTF-8")

    println (source.mkString)

    Source.stdin.getLines()

  }

}
