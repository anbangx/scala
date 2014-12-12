package practice

class Calculator(brand: String) {
  /**
   * A constructor.
   */
  val color: String = if (brand == "TI") {
    "blue"
  } else if (brand == "HP") {
    "black"
  } else {
    "white"
  }

  // An instance method.
  def add(m: Int, n: Int): Int = m + n
}

class C {
	var acc = 0
	def minc = { acc += 1 }
	val finc = { () => acc += 1 }
}

class ScientificCalculator(brand: String) extends Calculator(brand) {
  def log(m: Double, base: Double) = math.log(m) / math.log(base)
}

class EvenMoreScientificCalculator(brand: String) extends ScientificCalculator(brand) {
  def log(m: Int): Double = log(m, math.exp(1))
}

abstract class Shape {
	def getArea():Int    // subclass should define this
}

class Circle(r: Int) extends Shape {
	def getArea():Int = { r * r * 3 }
}

trait Car {
  val brand: String
}

trait Shiny {
  val shineRefraction: Int
}

// extend several traits
class BMW extends Car with Shiny {
  val brand = "BMW"
  val shineRefraction = 12
}

trait Cache[K, V] {
  def get(key: K): V
  def put(key: K, value: V)
  def delete(key: K)
}

object basics {
	// Expressions
	1 + 1                                     //> res0: Int(2) = 2
	
	// Values
	val two = 1 + 1                           //> two  : Int = 2
	
	// Variables
	var name = "steve"                        //> name  : String = steve
	name = "marius"
	
	// Functions
	def addOne(m: Int): Int = m + 1           //> addOne: (m: Int)Int
	val threef = addOne(2)                    //> threef  : Int = 3
	
	def three() = 1 + 2                       //> three: ()Int
	three()                                   //> res1: Int = 3
	three                                     //> res2: Int = 3
	
	// Anonymous Functions
	val addFour = (x: Int) => x + 4           //> addFour  : Int => Int = <function1>
	addFour(1)                                //> res3: Int = 5
	
	def timesTwo2(i: Int): Int = {
	  println("hello world")
	  i * 2
	}                                         //> timesTwo2: (i: Int)Int
	timesTwo2(10)                             //> hello world
                                                  //| res4: Int = 20
	// Partial application
	def adder(m: Int, n: Int) = m + n         //> adder: (m: Int, n: Int)Int
	val add2 = adder(2, _:Int)                //> add2  : Int => Int = <function1>
	add2(3)                                   //> res5: Int = 5
	
	// Curried functions
	def multiply(m: Int)(n: Int): Int = m * n //> multiply: (m: Int)(n: Int)Int
	multiply(2)(3)                            //> res6: Int = 6
	val timesTwo = multiply(2) _              //> timesTwo  : Int => Int = <function1>
	timesTwo(3)                               //> res7: Int = 6
	
  // Constructor
  val calc = new Calculator("HP")                 //> calc  : practice.Calculator = practice.Calculator@379c6fd2
  calc.color                                      //> res8: String = black
  
  // Expression
  val c = new C                                   //> c  : practice.C = practice.C@65bff1b4
  c.minc
  c.finc                                          //> res9: () => Unit = <function0>
  
  // Inheritance
  val circle = new Circle(2)                      //> circle  : practice.Circle = practice.Circle@62478c68
}