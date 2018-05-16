package com.partialf


/**
  * Created by Administrator on 2017/12/18.
  */
class Test {

}
object Test extends App{


  val map = Map(1 -> "a", 2 -> "b", 3 -> "c", "d" -> 123)
  map.map{
    case (k, v) if v.isInstanceOf[Int] => s"${k} : ${v}-result"
    case (k, v) if v.isInstanceOf[String] => s"${k} : ${v}s-result"
  }.foreach(print(_))


  println
  val list = List(1, 2, 3, 4, "b")
  list.map{case a : Int => print(s"result : ${a}")
  case b : String => print(s"result : ${b}")}

  println
  list.collect{case a : Int => print(s"result: ${a}")}


}
