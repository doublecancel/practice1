package com.example

/**
  * Created by Administrator on 2017/12/11.
  */
object  Finder {

  def main(args: Array[String]): Unit = {

    val list  = List(1, 2, 3, 4, 5, 6)
    println (list.find(a => a > 3))

    println(fiberate(10))

  }


  def isSorted[A](array : Array[A], ps : (A, A) => Boolean) : Boolean = {

    @annotation.tailrec
    def loop(n : Int) : Boolean = {

      if(n >= array.length - 1) true
      else if(!ps(array(n), array(n + 1))) false
      else loop(n + 1)
    }

    loop(0)

  }

  def findFirst[A](array : Array[A], ps : A => Boolean) : Int = {

    @annotation.tailrec
    def loop(n : Int) : Int = {
      if(n == array.length) -1
      else if(ps(array(n))) n
      else loop(n + 1)
    }

    loop(0)
  }

  def fiberate(n : Int) = {

    @annotation.tailrec
    def loop(n : Int, pre : Int, cur : Int) : Int = {
      if (n == 0) cur
      else loop(n - 1, cur, pre + cur)
    }

    loop(n, 0, 1)
  }






}
