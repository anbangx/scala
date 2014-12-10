package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    
    println()
    println("Parentheses Balancing")
    println(balance("(if (zero? x) max (/ 1 x))".toList))
    println(balance("())(".toList))
    
    println()
    println("Counting Change")
    println(countChange(4, List(1, 2)))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if(c <= r && r >= 0)
      if(c == 0 || c == r) 
        1
      else 
    	pascal(c - 1, r - 1) + pascal(c, r - 1)
    else 
      throw new IllegalArgumentException()
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def isParen(x : Char) : Boolean = {
	  x == '(' || x == ')'
	}
    
    def balanceHelper(chars: List[Char], expRight: Int): Boolean = {
      if(chars.isEmpty)
        expRight == 0
      else
        if(chars.head == '(')
          balanceHelper(chars.tail, expRight + 1)
        else
          if(expRight == 0)
            false
          else
            balanceHelper(chars.tail, expRight - 1)
    }
    
    balanceHelper(chars.filter(isParen(_)), 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
      def countChangeHelper(money_rest: Int, coins_rest: List[Int]): Int = {
        if(money_rest == 0)
          1
        else
          if(coins_rest.isEmpty || money_rest < coins_rest.head)
            0
          else
        	  countChangeHelper(money_rest - coins_rest.head, coins_rest) + countChangeHelper(money_rest, coins_rest.tail);
      }
      
      if(money <= 0 || coins.isEmpty)
        0
      else
        countChangeHelper(money, coins.sorted)
  }
}
