package com.example

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by Administrator on 2017/10/17.
  */
class Helloworld extends Actor{

  override def receive = {
    case "hello" => print("world")
    case _ => println("_")
  }

}

object  Helloworld {

  val system = ActorSystem("test")

  var helloActor = system.actorOf(Props[Helloworld], name = "hello")

  def main(args: Array[String]): Unit = {
    helloActor ! "hello"
  }


}
