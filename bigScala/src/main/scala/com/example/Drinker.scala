package com.example

/**
  * Created by Administrator on 2017/12/14.
  */
object Drinker {

  var mon : Int = 10

  def drink = mon -= 1

  def count : Int = {
    drink;mon
  }


  def callByValue(a : Int) : Unit = {
    (0 to 10).foreach(_ => println(a))
  }

  def callByName(a :  => Int) : Unit = {
    (0 to 10).foreach(_ => println(a))
  }


  def main(args: Array[String]): Unit = {

//    callByValue(count)
//    println ("-----------------------------------------------")
//    callByName(count)
//

    val tuple = ("abc", 10L)


    val stream = numFrom(10)
    print(stream)


  }


  def numFrom(n : Int) : Stream[Int] = n #:: Stream(n + 1)


}

case class Drinker(name : String, pwd : Long)
