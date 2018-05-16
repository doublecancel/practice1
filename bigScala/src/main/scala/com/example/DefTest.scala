package com.example

/**
  * Created by Administrator on 2017/12/14.
  */
object DefTest {
  def main(args: Array[String]): Unit = {

    def p = new People
    p.name = "a"


    val p1  = new People
    p1.name = "b"

    lazy val p2 = new People
//    p2.name = "c"

    println ("finished")
  }



}

class People {
  var name : String = _


}
