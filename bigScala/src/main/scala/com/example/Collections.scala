package com.example

/**
  * Created by Administrator on 2017/12/11.
  */
class Collections {


}
object Collections{
  def main(args: Array[String]): Unit = {

    test2
  }

  def test1 = {

    val list = List("a", "b", "c", "d")

    //在list集合的头部和尾部添加新的元素
    println (":+     " + (list.:+ ("f")))
    println (":+     " + (list :+ "f"))
    println ("+:     " + (list.+: ("f")))
    println ("+:     " + ("f" +: list))


    println ("::     " + ("f" :: list))
    println ("::     " + (list.::("f")))
    //:: 创建新的list集合
    val list2 = (1 :: 2 :: 3 :: 4 :: Nil)
    println (list2)

    println ("++:    " + (list ++ List("f", "g")))
    println ("++:    " + (List("a", "b") ::: List("f", "g")))

    println ("head : " + list.head)
    println ("tail: " + list.tail)
    println ("last: " + list.last)

    println ("apply : " + list.apply(2))


    println ("drop : " + list.drop(1))
    println ("dropRight : " + list.dropRight(1))
    println ("take : " + list.take(1))
    println ("takeRight : " + list.takeRight(1))

  }

  def test2 = {

    val list = List("a", "b", "c", "d", "e")
    println ("head : " + list.head)
    println ("tail : " + list.tail)

    println ("drop:" + list.drop(1))
    println ("dropRight:" + list.dropRight(1))

    println ("take: " + list.take(1))
    println ("takeRight: " + list.takeRight(1))

    println ("dropWhile : " + list.dropWhile(a => a.startsWith("a")))
    println ("takeWhile : " + list.takeWhile(a => a.startsWith("a")))

    println ("apply : " + list.apply(1))

    println ("count : " + list.count(a => a.startsWith("b")))
    println ("size : " + list.size)

    println ("update" + list.updated(1, "l"))

    val list2 = List(List("a", "b"), List("aa", "bb"))
    println ("flatten : " + list2.flatten)

    println ("group : " + list.groupBy(a => a.startsWith("a")))

    val list3 = List("t", "y")
    println ("fold : " +  list.fold("123")((a, b) => a + b))

    println ("filter : " + list.filter(a => a.startsWith("b")))

    println ( "map : " + list.map(a => a + "4"))

    println ("span : " + list.span(a => a.startsWith("a")))

    println ("reduce : " + list.reduce((a, b) => a + b))

    println ("forall : " + list.forall( a => a.startsWith("a")))

    println ("find : " + list.find(a => a.startsWith("a")))

    println ("mkstring : " + list.mkString("+"))

    println (list.addString(new StringBuilder("a"), "p"))

  }


}


