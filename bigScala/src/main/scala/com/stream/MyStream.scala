package com.stream

import scala.util.Random


/**
  * Created by Administrator on 2017/12/14.
  */
trait MyStream[+A] {
  import com.stream.MyStream._
  def filter (p : A => Boolean) : MyStream[A] = {
    this match {
      case Cons(h, t) =>
        if(p(h()))  cons(h(), t().filter(p))
        else t().filter(p)
      case _ => MyStream.empty
    }
  }


  def take (n : => Int) : MyStream[A] = {
    if(n > 0) this match {
      case Cons(h, _) if n == 1 => cons(h(), empty)
      case Cons(h, t) => cons(h(), t().take(n - 1))
      case _ => empty
    }
    else MyStream()
  }

  def toList : List[A] = {
    this match {
      case Cons(h, t) => h() :: t().toList
      case Empty => Nil
    }
  }

  def foldRight[B](z : => B)(f : (A , => B) => B) : B = this match {
    case Cons(h, t) => f(h(), t().foldRight(z)(f))
    case _ => z
  }


}
object MyStream {

  def main(args: Array[String]): Unit = {

    val params = (1 to 100).map(_ => Random nextInt 500).toList

    val res = MyStream(params:_*).filter(_ % 3 == 0).take(5).toList
    print(res)


    val list = List(1, 2, 3 , 4, 5)



    def f1 = (a : Int, b : String) => "fdasfdsafdsa"


  }

  def apply [A] (a : A*) : MyStream[A] = {
    if(a.isEmpty) empty
    else cons(a.head, apply(a.tail:_*))
  }

  def empty = Empty

  def cons[A](h : => A, t : => MyStream[A]) : MyStream[A] = {
    lazy val head = h
    lazy val tail = t
    Cons(() => head, () => tail)
  }

}

case class Cons [+A](h : () => A, t : () => MyStream[A]) extends MyStream[A]
case object Empty extends MyStream[Nothing]
