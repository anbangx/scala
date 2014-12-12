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
	
  // Constructor
  val calc = new Calculator("HP")                 //> calc  : practice.Calculator = practice.Calculator@43a05220
  calc.color                                      //> res1: String = black
  
  // Expression
  val c = new C                                   //> c  : practice.C = practice.C@1324f232
  c.minc
  c.finc                                          //> res2: () => Unit = <function0>
  
  // Inheritance
  val circle = new Circle(2)                      //> circle  : practice.Circle = practice.Circle@1478e67f
}