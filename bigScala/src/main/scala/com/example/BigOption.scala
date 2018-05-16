package com.example

/**
  * Created by Administrator on 2017/12/12.
  */
object BigOption {
  def apply[A](value : A): BigOption[A] = {
    if(value == null) BigNone else BigSome(value)
  }
  def empty = BigNone


  def main(args: Array[String]): Unit = {

    val option = BigOption.apply("123")
    println (option.getOrElse(123))

    println (option.map(a => s"a-${a}").getOrElse("none"))

  }
}

sealed abstract class BigOption[+A] {
  self =>
  def get : A
  def isEmpty : Boolean

  def getOrElse[B >: A](default : => B) : B = if(isEmpty) default else this.get
  def map[B](f : A => B) : BigOption[B] = if(isEmpty) BigNone else BigSome(f(this.get))

  def fold[B](ifEmpty : => B)(f : A => B) : B = if(isEmpty) ifEmpty else f(this.get) //空逻辑和map操作
  def flatMap[B](f : A => BigOption[B]) : BigOption[B] = if(isEmpty) BigNone else f(this.get)

  def filter(f :  A => Boolean) : BigOption[A] = if(f(this.get) || isEmpty) this else BigNone

  def foreach(f : A => Unit) = if(!isEmpty) f(this.get)

  def withFilter (p : A => Boolean) = new WithFilter(p)
  class WithFilter (p : A => Boolean) {
    def map[B](f : A => B) : BigOption[B] = self filter p map f
    def flatmap[B](f : A => BigOption[B]) : BigOption[B] = self filter p flatMap f
    def foreach(f : A => Unit) : Unit = self filter p foreach f
    def withFilter (s : A => Boolean) : WithFilter = new WithFilter(x => p(x) && s(x))
  }

  def contains (a : Any) = !isEmpty && this.get == a

  def exists (a : Any) = !isEmpty && this.get == a

  def forall(f : A => Boolean) = isEmpty || f(this.get)

  def orElse[B >: A](f : => BigOption[B]) = if(isEmpty) f else this

  def toLeft[X](right : => X) : Either[A, X] = if(isEmpty) Left(this.get) else Right(right)
  def toRight[X] (left : => X) : Either[X, A] = if(isEmpty) Left(left) else Right(this.get)




}

case class BigSome[A](a : A) extends BigOption[A] {
  override def get: A = a
  override def isEmpty: Boolean = false
}

case object BigNone extends BigOption[Nothing] {
  override def get = {
    throw new RuntimeException("")
  }
  override def isEmpty: Boolean = true
}
