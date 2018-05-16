package com.example

/**
  * Created by Administrator on 2017/12/12.
  */
class OptionTest {

}

object OptionTest {


  def main(args: Array[String]): Unit = {

    val option = Option(201)
    println (s"result : ${getOrElse(option)}")

    option.withFilter(a => {println ("1");a > 1})
//      .withFilter(a =>{ println ("2");a > 200})
//      .withFilter(a => { println ("3");a > 300})
      .foreach(a => println(a))

    test(test2 _)
  }

  def test(a : Int => String) = {

  }

  def test2(a : Int) = a.toString


  def getOrElse[A](a : Option[A]) = {
    a match {
      case None => ""
      case Some(a) => a.toString
    }
  }

}

