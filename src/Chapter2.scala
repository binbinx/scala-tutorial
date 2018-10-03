import java.time.LocalDate

object Chapter2 extends App {
  println("Problem 1:")

  def signum(input: BigInt) = if (input > 0) 1 else if (input < 0) -1 else 0

  println(signum(3000) + ":" + signum(BigInt("-2423423424234242424345686788")) + ":" + signum(0))

  println("Problem 2:")
  val problem2 = {}
  println(problem2 + ":" + problem2.getClass)

  println("Problem 3:")
  var y = 0
  val x = y = 1
  println("x= " + x)

  println("Problem 4:")
  for (i <- 10 to 0 by -1) print(i + " ")
  println()

  println("Problem 5:")

  def countDown(n: Int) = {
    for (i <- n to 0 by -1) print(i + " ")
    println()
  };
  countDown(100)

  println("Problem 6:")
  println({var result=1:BigInt; for (c<-"Hello") result *= c.toInt; result} )

  println("Problem 7:")
  def stringToUnicodeProductV2(s: String) = s.foldLeft(1: BigInt)(_ * _.toInt)
  println(stringToUnicodeProductV2("Hello"))

  println("Problem 8:")
  def stringToUnicodeProduct(s: String) = {
    var result: BigInt = 1;
    for (c <- s) {
      result *= c.toInt
    }
    result
  }
  println(stringToUnicodeProduct("Hello"))

  println("Problem 9:")
  def stringToUnicodeProductV3(s: String) : BigInt = {
    var result:BigInt = 1;
    if (s.length==1) result = s.toInt
    else result *= stringToUnicodeProductV3(s.drop(1))
    result
  }
  println(stringToUnicodeProduct("Hello"))

  println("Problem 10:")
  def powerOfX(x:Int, n:Int):BigDecimal =
  {
    if (n<0) 1/powerOfX(x,-n)
    else if (n==0) 1
    else if (n%2==0) powerOfX(x, n/2) * powerOfX(x, n/2)
    else if (n%2==1) powerOfX(x,n-1) * x
    else 0
  }
  println(powerOfX(2,15) + ":" + powerOfX(25,12) + ":" + powerOfX(10,-14))

  println("Problem 11:")
  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {

    def date(args: Any*): LocalDate = {
      if (args.length!=3) throw new IllegalArgumentException("Three parameters (year, month, day) need to be defined")
      for(s<-sc.parts if s!="")
          if(s!="-") throw new IllegalAccessException(s"Parameter should be separated by hyphen instead of $s")

      try
        {
          val year = args(0).toString().toInt
          val month = args(1).toString().toInt
          val day = args(2).toString().toInt
          LocalDate.of(year, month, day)
        }
      catch
        {
          case ex:NumberFormatException => throw ex
        }

    }
  }
  val year=1980
  val month=10
  val day=7
  println(date"$year-$month-$day")
  try
    {  println(date"1980-10-7")
    }
  catch
    {
      case ex:Any => ex.printStackTrace()
    }
  try
    {
      println(date"$year:$month:$day")
    }
  catch
    {
      case ex:Any => ex.printStackTrace()
    }
}








