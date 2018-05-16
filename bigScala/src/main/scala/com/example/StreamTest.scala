package com.example

import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
  * Created by Administrator on 2017/12/14.
  */
object StreamTest {

  def main(args: Array[String]): Unit = {

//    val list = (0 to 50).map(_ => Random nextInt 100).toList.filter(isDivide3(_)).take(2)
//    println (list)

//    println (isDivide3_((0 to 100).map(_ => Random nextInt(100)).toList))
//    println (isDivider3__((0 to 100).map(_ => Random nextInt(100)).toList))

    val res = (0 to 100).map(_ => Random nextInt 100).toStream.filter(isDivide3(_)).take(2).toList
    println (res)

    test(() => 200)

    test1("a", "b", "c", "d")


  }

  def test1 (a : String*) : Unit = {
    if(a.isEmpty){
      println ("end")
    }else{
      println (a.head)
      test1(a.tail:_*)
    }
  }


  def test(a : () => Int) = {
    println (a)
  }


  def isDivide3(a : Int) = {
    println (s"a:${a}, result:${a % 3 == 0}")
    a % 3 == 0
  }


  def isDivide3_(list : List[Int]) : ListBuffer[Int] = {
      val res = ListBuffer[Int]()
      list.foreach(a => {

        if(a % 3 == 0) res.append(a)
        if(res.size == 2) {
          return res
        }
      })
      return res
  }

  def isDivider3__(list : List[Int]) : List[Int] = {
    list.foldLeft(Nil : List[Int])((res, item) => {
//      println (s"a:${item}, result:${item % 3 == 0}")
      if(res.size == 2) return res
      if(item % 3 == 0) item :: res
      else res
    })
  }

}
