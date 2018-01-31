package com.nagihome.sfi.ch02

object CtrlStructuresAndFunctions {

  def main(args: Array[String]): Unit = {

    var n = 4
    while (n >= 0) {
      printf("In While Loop with It Num: %s \n", n);
      n -= 1
    }

    for (i <- 1 to 4)
      printf("In For Loop: %s \n", i);

    var s: String = "Hello"
    var sum = 0
    for (i <- 0 to s.length - 1)
      sum += i
    printf("Sum of the String is: %s \n", sum)

    sum = 0
    for (ch <- "Hello")
      sum += ch
    printf("Short: Sum of the String is: %s \n", sum)

    for (i <- 1 to 3; j <- 2 to 4) {
      print(f"${10 * i + j}%3d")
    }

    print("\n")

    for (i <- 2 to 4; j <- 3 to 5; if (i == j)) {
      print(f"${10 * i + j}%3d ")
    }

    print("\n")

    for (i <- 1 to 3; j = 7 - i; k <- j to 4) {
      print(f"${10 * i + k}%3d")
    }

    for (i <- 1 to 10) yield i % 3

    def fac(n: Int): Int = {

      var r = 1

      for (i <- 1 to n) r = r * i

      r
    }


    print("\n")

    printf("factorial: %s \n", fac(3))

    printf("factorial Recursive: %s \n", factorialRecursive(4))

    printf("decorate: %s\n", decorate("Hello", "<<<", ">>>"))

    printf("decorate with default: %s\n", decorate("Hello"))

    printf("varsArgsSum: %s\n", varsArgsSum(1, 2, 3))



  }

  def factorialRecursive(n: Int): Int = {
    if (n <= 0) 1 else n * factorialRecursive(n - 1)
  }

  def decorate(str: String, left: String = "[ ", right: String = " ]"): String = {
    left + str + right
  }

  def varsArgsSum(args: Int*): Int = {
    var result = 0
    for (arg <- args) result += arg
    result
  }

}
