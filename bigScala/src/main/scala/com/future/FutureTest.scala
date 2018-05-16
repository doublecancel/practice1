package com.future

import scala.concurrent._
import scala.util.{Failure, Success}

/**
  * Created by Administrator on 2017/12/20.
  */
object FutureTest {

  def main(args: Array[String]): Unit = {
    import scala.concurrent.ExecutionContext.Implicits.global
    val s = "Hello"
    val f : Future[String]= Future {
      Thread.sleep(1000)
      println (s"start-${threadName}")
      s"${s} - future"
    }
    f map (a => {
      println (s"map-${threadName}")
      a + "-map"
    }) flatMap {
      t => Future {
        println (s"flatMap-${t}-${threadName}")
        s"${t}-flatmap"
      }
    } onComplete  {
      case Success(msg) => println(s"success-${msg}")
      case Failure(msg) => println(s"failure-${msg}")
    }
    //    println(s)//不加这句, f onSuccess就不执行
    //    println (f.isCompleted)
    import scala.concurrent.duration._
    Await.result(f, 2 seconds)

    Future(100).zip(Future(200)).foreach(a => println (s"${a}"))


    val f1 = Future {
      Thread.sleep(2000)
      throw new RuntimeException("1111")
    } recover {
      case e : RuntimeException => println (e); 200
    }
    f1 onComplete {
      case Success(msg) => println(s"--success-${msg}")
      case Failure(msg) => println(s"--failure-${msg}")
    }

//    Await.result(f1, 1 seconds)


    val f2 = Future {
      Thread.sleep(100)
      90
    }
    f2 andThen {
      case r => println (s"andthen : ${r}")
    } andThen {
      case Success(a) => println (s"===success:${a}")
      case Failure(a) => println (s"===failure:${a}")
    } onComplete {
      case Success(a) => println (s"===++  success:${a}")
      case Failure(a) => println (s"===++  failure:${a}")
    }

    testPromise onComplete {
      case Success(a) => println (s"promise  success:${a}")
      case Failure(a) => println (s"promise  failure:${a}")
    }

  }

  def testPromise  : Future[String] = {
    import scala.concurrent.ExecutionContext.Implicits.global
    val promise = Promise[String]

    Future {
      println (s"promise : ${threadName}")
      promise success "success"
      promise failure  new IllegalStateException()
      println ("go on-------------------------")
    }
    promise.future

  }

  def threadName = Thread.currentThread().getName

}
