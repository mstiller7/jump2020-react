fun main() {
  println("Hello world!")
  printSum(3, 7)
}

fun sum(a: Int, b: Int): Int {
  return a + b
}

fun printSum(a: Int, b: Int) {
  println("sum of $a and $b is ${a + b}!")
}

// returns null if str has no Int
fun parseInt(str: String): Int? {
  return str.toInt()
}

fun printProduct(s1: String, s2: String) {
  val x = parseInt(s1)
  val y = parseInt(s2)
  
  if (x != null && y != null) {
    println(x * y)
  } else {
    println("'$s1' or '$s2' is not a number")
  }
  
}