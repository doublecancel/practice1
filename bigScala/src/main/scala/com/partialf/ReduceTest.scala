package com.partialf

/**
  * Created by Administrator on 2017/12/20.
  */
object ReduceTest {

  def main(args: Array[String]): Unit = {

    val res = List(1, 2, 3, 4, 5).reduce(_ + _ )
    println (res)

    val res2 = List(1, 2, 3, 4, 5).fold(0)(_ + _)
    println (res2)
  }

}
