import scala.beans.BeanProperty
import scala.collection.mutable.Map

object Chapter5 extends App{

  println("Problem 1")
  class Counter {

    private var value = 0 // You must initialize the field

    def increment() { if (value<Int.MaxValue) value += 1 } // Methods are public by default

    def current = value

  }

  var counter = new Counter
  counter.increment()
  println("Current value: " + counter.current)
  for (i <- 1 until Int.MaxValue) counter.increment()
  println("Current value: " + counter.current)
  counter.increment()
  println("Current value: " + counter.current)

  println("Problem 2")
  class BankAccount {
    private var balance:BigInt = 0
    def withdraw(amount:Int) {
      if (amount>0 && balance-amount>=0) balance -= amount
    }
    def deposit(amount:Int) {
      if (amount>0) balance += amount
    }
    def current = balance
  }
  var account = new BankAccount
  account.deposit(10000)
  account.withdraw(250)
  account.deposit(20)
  account.deposit(-20)
  account.withdraw(20000)
  println("Current balance: " + account.current)

  println("Problem 3 & 4")
  class Time (private var hours:Int, private var minutes:Int) {
    private var currentTime = 0
    currentTime = hours * 24 + minutes
    def currentHour = hours
    def currentMinute = minutes
    def before(time:Time)= {
      currentTime < time.currentTime
    }
  }
  val t1 = new Time(10, 20)
  val t2 = new Time(23,2)
  println("t1: " + t1.currentHour + ":" + t1.currentMinute)
  println("t2: " + t2.currentHour + ":" + t2.currentMinute)
  var result = t1.before(t2)
  println(s"t1 before t2: $result")
  result = t2.before(t1)
  println(s"t2 before t1: $result")

  println("Problem 5")
  class Student(@BeanProperty var name:String, @BeanProperty var id:Long) {
  }
  val s1 = new Student("weibin", 100)
  println("id: " + s1.getId)
  println("name: " + s1.getName)

  println("Problem 6 & 7")
  class Person(var age: Int, val name: String) {
    if (age < 0) age = 0
    val firstName = name.split(" ")(0)
    val lastName = name.split(" ")(1)
  }
  val p1 = new Person(-2, "Fred Smiths")
  println("Age: " + p1.age)
  println("First Name: " + p1.firstName)
  println("Last Name: " + p1.lastName)

  println("Prolbem 8")
  class Car(val manufacturer:String, val model:String, val year:Int)
  {
    var plate:String = ""
    def this(manufacturer:String, model:String)
    {
      this(manufacturer, model, -1)
    }
    def this(manufacturer: String, model:String, year:Int, plate:String) {
      this(manufacturer, model, year)
      this.plate = plate
    }

    def this(manufacturer:String, model:String, plate:String)
    {
      this(manufacturer, model, -1)
      this.plate = plate
    }
  }
  val c1 = new Car("Ford", "F1")
  var c2 = new Car ("Chevy", "Volt", 2010)
  var c3 = new Car("Cadillac", "Esclade", 1998, "CA980")
  var c4 = new Car("BMW", "Series3", "AL1028")
  println(c1.manufacturer + ":" + c1.plate + ":" + c1.model + ":" + c1.year)
  println(c2.manufacturer + ":" + c2.plate + ":" + c2.model + ":" + c2.year)
  println(c3.manufacturer + ":" + c3.plate + ":" + c3.model + ":" + c3.year)
  println(c4.manufacturer + ":" + c4.plate + ":" + c4.model + ":" + c4.year)
}

