```scala
import scala.concurrent.{ExecutionContext, Future}

class MyClass(implicit ec: ExecutionContext) {
  def myMethod(i: Int): Future[Int] = Future {
    if (i == 0) throw new Exception("Error!")
    i * 2
  }.recover { 
    case e: Exception => 0 //Handle the exception, return a default value
  }

  def myMethodWithRecoverWith(i:Int): Future[Int] = Future{
    if(i == 0) throw new Exception("Error!")
    i*2
  }.recoverWith{ 
    case e:Exception => Future.successful(0) //Handle the exception, return a Future with a default value
  }
}
```