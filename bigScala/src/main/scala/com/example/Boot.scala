package com.example

/**
  * Created by Administrator on 2017/10/17.
  */
object Boot extends App{



  val l = List(1, 2, 3)
  val s = l match {
    case list @ List(10, _*) => println (s"a:${list}")
    case list : List[_] => println (s"b : ${list}")
    case  _ => println ("not match")
  }

  val a : Option[Int] = Some(1)
  a match {
    case h @ Some(_) => println (h == a)
    case None => println ("none")
  }


}
