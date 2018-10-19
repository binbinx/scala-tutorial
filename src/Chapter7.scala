import java.io.PrintWriter

import scala.io.Source

object Chapter7 extends App{

  println("Problem 1")
  val lines = Source.fromFile("resources/Chapter7/q1").getLines().toBuffer
  val out = new PrintWriter("resources/Chapter7/q1.out")
  for (index <- lines.length-1 to 0 by -1 )
    {
      println(lines(index))
      //out.println(lines(index))
    }
  out.close()

  println("Problem 2")

  println("Problem 3")

  println("Problem 4")

}
