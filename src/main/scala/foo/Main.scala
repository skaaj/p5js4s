package foo

//import scala.scalajs.concurrent.{Future, Promise}
import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration._
import scalajs.js

case class Person(name: String)
case class Cat(name: String)
case class Dog(name: String)

def delay(milliseconds: Int): Future[Unit] = {
  val p = js.Promise[Unit]((accept, reject) => {
    js.timers.setTimeout(milliseconds) {
      accept(())
    }
  })
  p.toFuture
}

def delay2(milliseconds: Int): Future[Unit] = {
  val p = scala.concurrent.Promise[Unit]()
  js.timers.setTimeout(milliseconds) {
    p.success(())
  }
  p.future
}

def call(named: Person | Cat): String = {
  val name = named match {
      case Person(n) => n
      case Cat(n) => n
  }
  s"Hello, ${name}"
}

@main def bar = {
  println(call(Person("Ben")))
  println(call(Cat("Yumi")))
  // Thread.sleep(10000)
  // Await.result(delay(10000), 5.minutes)
  // import scala.concurrent.ExecutionContext.Implicits.global
  import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
  val f = delay2(1_000).map(_ => "The future completed successfully")
  //val r = Await.result(f, 5.minutes)
  f.andThen(println(_))
  (1 to 100_000_000).foreach(_ => ())
  
}

/*
* - Idée de workflow serverless
* - Idée d'OSINT Insta
* - Scala 3 / Scalajs
*/