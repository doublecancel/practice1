package com.partialf

/**
  * Created by Administrator on 2017/12/20.
  */
class TypeTest {


  type S = String




}

trait A {
  type T
  def test (t : T) = {
    println(t)
  }
}

class B extends A {type T = Int}

object TypeTest {

  type S = String

  type PepMap = Map[String, People]

  type TaxPredicate = Tax => Boolean

  def main(args: Array[String]): Unit = {

    println (getString)
    println (getMap)
    val b = new B()
    b.test(111)


    val aPredicate : TaxPredicate = tax => tax.age < 20


  }

  def getString : S = {
    "abc"
  }

  def getMap : PepMap = {
    Map("1" -> People("a", "a"), "2" -> People("b", "b"))
  }

}
case class People (name : String, pwd : String)
case class Tax (name : String, age : Int)

class T {
  def a : this.type = this
  def b : this.type  = this
  def c : this.type  = this
}
class U extends T {
  def d : U = this

  override def a = this
}
trait L {
  def b : this.type
}
class P extends U {
  override def b = this
}
object U {
  def main(args: Array[String]): Unit = {
    val t = new T
    t.a.b.c

    val u = new U()
    u.d.a.b.c

    val p = new P()
//    p.a.b.c.e
  }
}
