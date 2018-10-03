import java.awt.datatransfer._

import scala.collection.mutable._
import scala.util._
//import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConverters._

object Chapter4 extends App{

  println("Problem 1")
  val priceMap:Map[String, Int] = Map("shoe"->3, "chair"->5, "wallet"->1)
  val discountedPriceMap = for((k,v)<-priceMap) yield(k,v*0.9)
  println(discountedPriceMap)

  println("Problem 2")
  val in = new java.util.Scanner(new java.io.File("/Users/weibinxu/ge_project/scala-tutorial/src/Chapter4.scala"))
  var wordCount = scala.collection.mutable.Map[String, Int]().withDefaultValue(0)
  while (in.hasNext())
    {
      //if (in.next()!=null) wordCount(in.next()) = wordCount(in.next)+1
      val word = in.next()
      wordCount(word) = wordCount(word)+1
    }
  println(wordCount)
}
