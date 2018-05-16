package com.partialf

/**
  * Created by Administrator on 2017/12/18.
  */
object ForTest extends App{

  for (i <- 1 to 3; j <- 1 to 3) print(s"i : ${i}, j : ${j},  ")
  println
  for (i <- 1 to 3 ; j <- 1 to 3 if i != j) print(s"i : ${i}, j : ${j},  ")
  println
  val a = for (i <- 1 to 10 ) yield i % 3
  println(a)
  val b = for (i <- "abc"; j <- 1 to 10) yield i + 1

}
