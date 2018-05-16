package com.example


/**
  * Created by Administrator on 2017/12/14.
  */
import com.example.MyStream._

import scala.util.Random

object test {
  def main(args: Array[String]): Unit = {

    val list = (0 to 100).map(_ => Random nextInt 100).toList
    val stream = MyStream(list:_*)
    val l = stream.filter(_ % 3 == 0).take(2).toList
    println (l)
  }


  def test2(a : => Int) = {

  }


}

trait MyStream[+A] {
  def filter(p : A => Boolean) : MyStream[A] = {
    this match {
      case Cons(h, t) =>
        if(p(h())) cons(h(), t().filter(p))
        else t().filter(p)
      case Empty => empty
    }
  }

  def take(a : => Int) : MyStream[A] = {
    if(a > 0) this match {
      case Cons(h, t) if(a == 1) => cons(h(), MyStream.empty)
      case Cons(h, t) => cons(h(), t().take(a - 1))
      case _ => MyStream.empty
    }
    else MyStream()
  }

  def toList : List[A] = {
    this match {
      case Cons(h, y) => h() :: y().toList
      case Empty => Nil
    }
  }

}

object MyStream {

  def cons[A] (head : => A, tail : => MyStream[A]) : MyStream[A] = {
    lazy val a = head
    lazy val t = tail
    Cons(() => a, () => t)
  }

  def apply[A] (a : A*) : MyStream[A] = {
    if(a.isEmpty) empty
    else cons(a.head, apply(a.tail: _*))
  }

  def empty[A] : MyStream[A] = Empty

}
case class Cons[+A](h : () => A, tail : () => MyStream[A]) extends MyStream[A]
case object Empty extends MyStream[Nothing]
