object Chapter6 extends App {

  println("Problem 1")
  object Conversions {
    def inchesToCentimeters(input:Double) : Double = {
      input * 2.54
    }

    def gallonsToLiters(input:Double) : Double = {
      input * 3.78541178
    }

    def milesToKilometers(input:Double) : Double = {
      input * 1.60934
    }
  }
  var input = 259.234
  println(s"${input} inches = ${Conversions.inchesToCentimeters(input)} cm")

  input = 1.7932
  println(s"${input} gallons = ${Conversions.gallonsToLiters(input)} liters")

  input = 457924.299082
  println(s"${input} miles = ${Conversions.milesToKilometers(input)} km")

  println("Problem 2")
  abstract class UnitConversion {
    def convert(Input:Double) : Any
  }
  object InchesToCentimeters extends UnitConversion {
    override def convert(Input:Double) : Double = {
      input * 2.54
    }
  }
  object GallonsToLiters extends UnitConversion {
    override def convert(input:Double) : Double = {
      input * 3.78541178
    }
  }
  object MilesToKilometers extends UnitConversion {
    override def convert(input:Double) : Double = {
      input * 1.60934
    }
  }

  input = 723.9234
  println(s"${input} inches = ${InchesToCentimeters.convert(input)} cm")

  input = 231.2349
  println(s"${input} gallons = ${GallonsToLiters.convert(input)} liters")

  input = 6349.082
  println(s"${input} miles = ${MilesToKilometers.convert(input)} km")

  println("Problem 3")
  object Origin extends java.awt.Point {

  }

  println("Problem 4")
  class Point (var x:Double, var y:Double) {

  }
  object Point {
    def apply(x:Double, y:Double) = {
      new Point(x, y)
    }
  }
  val p1 = new Point(1, 2)
  val p2 = Point(5.1, 9.2)
  println(s"P1: (${p1.x}, ${p1.y}), P2: (${p2.x}, ${p2.y})")

  println("Problem 5")
  if(args.length>0) {
    val argsReverse = args.reverse
    for (arg <- argsReverse) {
      printf(s"$arg ")
    }
    printf("\n")
  }

  println("Problem 6")
  object CardSuit extends Enumeration {
    val SPADES = Value("\u2660")
    val HEARTS = Value("\u2665")
    val CLUBS = Value("\u2663")
    val DIAMONDS = Value("\u2666")
  }
  println(s"${CardSuit.CLUBS.toString} : ${CardSuit.DIAMONDS.toString} : ${CardSuit.HEARTS.toString} : ${CardSuit.SPADES.toString}")

  println("Prolblem 7")
  def isRedCardSuit(input:CardSuit.Value) = {
    if (input == CardSuit.HEARTS || input == CardSuit.DIAMONDS) true
    else false
  }
  println("Spades is " + isRedCardSuit(CardSuit.SPADES))
  println("Clubs is " + isRedCardSuit(CardSuit.CLUBS))
  println("Diamonds is " + isRedCardSuit(CardSuit.DIAMONDS))
  println("Hearts is " + isRedCardSuit(CardSuit.HEARTS))

  println("Problem 8")
  object RGBCubeCorner extends Enumeration {
    val BLACK = Value(0)
    val BLUE = Value(0x0000FF)
    val RED = Value(0xFF0000)
    val MAGENTA = Value(0xFF00FF)
    val GREEN = Value(0x008000)
    val CYAN = Value(0x00FFFF)
    val YELLOW = Value(0xFFFF00)
    val WHITE = Value(0xFFFFFF)
  }
  for(color <- RGBCubeCorner.values) {
    println(s"${color} : ${color.id.toHexString}")
  }
}
