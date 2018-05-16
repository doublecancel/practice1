package com.example

import java.io.{FileNotFoundException, IOException}

/**
  * Created by Administrator on 2017/12/12.
  */
class PatternMatchTest {



}

sealed abstract class A

case class B(name:String,pwd:String) extends A
case class C(name:String,pwd:String) extends A
case class D(name:String,pwd:String) extends A
case class E(name:String,pwd:String) extends A

object PatternMatchTest {


  def main(args: Array[String]): Unit = {
    val d = D("lxl-D", "ddd")
    val b = B("lxl-B", "bbb")
    val c = C("lxl-C", "ccc")
    val e = E("lxl-C", "ccc")
    who(e)

    constantMatch(123)

    listMatch(List("d", "e"))

    typeMatch(Array(1))
  }


  def constantMatch(a : Any) = {
    a match {
      case true => println ("true")
      case "a" => println ("String")
      case Nil => println ("Nil")
      case 123 => println ("123")
      case _ => println ("other")
    }
  }

  def exceptionMatch(e : Exception) = {
    e match {
      case  a : IOException => println (s"ioexception : ${a}")
      case  a : FileNotFoundException => println (s"FileNotFoundException : ${a}")
      case _ => println ("other exception")
    }
  }




  def listMatch[A] (list : List[A]) = {
    list match {
      case List(a, b) if(a == b) => println (s"list constains two members and equals")
      case List(d, _*) => println (s"begin with ${d}")
      case List("a", "b", tail) => println (s"begin with a, b, ${tail}")
      case "e" :: tail if(tail.contains("f")) => println (s"list begin with e and tail contains f")
      case head :: tail => println (s"head:${head}, tail:${tail}")
      case Nil => println ("nil")
      case _ => println ("others")
    }
  }

  def typeMatch(a : Any) = {
    a match {
      case b : Int => println (s"a is Int : ${b}")
      case b : String => println (s"a is string : ${b}")
      case b : Array.type => println (s"a is array : ${b}")
      case _ => println ("unknow type")
    }
  }



  def who(domain : A) = {
    domain match {
      case B(a, b) => println (a + "," + b)
      case C(a, b) => println (a + "," + b)
      case D(a, b) => println (a + "," + b)
      case _ => println ("other")
    }
  }

}
