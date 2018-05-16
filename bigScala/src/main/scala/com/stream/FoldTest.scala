package com.stream


/**
  * Created by Administrator on 2017/12/14.
  */

case class Foo (name : String, pwd : Long, gender : String)
object FoldTest {

  def main(args: Array[String]): Unit = {

    (1 to 100).foldLeft(0)(_ + _)

    val list = Foo("lxl1", 100L, "female") ::
              Foo("lxl2", 101L, "male") :: Nil

    val res = list.foldLeft(List[String]())((acc, item) => {
      val gender = item.gender match {
        case "female" => "Mrs"
        case "male" => "Mr"
        case _ => ""
      }
      acc :+ s"${item.name}-${item.pwd}-${gender}"
    })

    println(res)

    val res2 = (List[String]() /: list) ((acc, item) => {
      val gender = item.gender match {
        case "female" => "Mrs"
        case "male" => "Mr"
        case _ => ""
      }
      acc :+ s"${item.name}-${item.pwd}-${gender}"
    })

    println(res2)



    val map1 = Map("lxl01" -> 1, "lxl02" -> 2, "lxl03" -> 3, "lxl04" -> 5)
    val map2 = Map("lxl05" -> 5, "lxl06" -> 6, "lxl03" -> 3, "lxl02" -> 5)

    // "lxl01" -> 1, "lxl02" -> 7, "lxl03" -> 6, "lxl04" -> 5, "lxl05" -> 5, "lxl06" -> 6

    val res3 = (map1 /: map2){
      case (map, (k, v)) => map + (k -> (v + map.getOrElse(k, 0)))
    }

    val res4 = map1.foldLeft(map2){
      case (map, (k, v)) => map + (k -> (map.getOrElse(k, 0) + v))
    }

    val res5 = (map1 /: map2){
       (map, entry) => map + (entry._1 -> (entry._2 + map.getOrElse(entry._1, 0)))
    }


    println(res3)
    println(res4)
    println(res5)

    val list1 = List(1, 2, 3, 4, 5)
    val list2 = List(1, 2, 3, 4, 5)
    println
    list1.map(_ * 2).foreach(a => print(s"${a}-"))
    println
    println(list1.foldLeft(List[Int]())((acc, item) => {
      acc :+ item * 2
    }))

    println(list1.filter(_ > 2))
    println(list1.foldLeft(List[Int]()){
      (acc, item) => {
        if (item > 2) acc :+ item
        else acc
      }
    })



    println
  }

}

