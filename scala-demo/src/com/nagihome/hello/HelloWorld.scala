package com.nagihome.hello

import scala.math._

object HelloWorld {

  var hello: String = "foo"

  val factor = 3
  val multiplier = (i: Int) => i * factor

  def main(args: Array[String]): Unit = {
    println("Hello Scala " + multiplier(3));

    var hello = new Hello

    hello.labelToValue += ("FirstName" -> "Nagi")

    println(hello.labelToValue.size)

    println("Math Sqrt: " + sqrt(2.0));
    println("Math Pow: " + pow(2, 8));

    val num: Int = 87;
    println("If Positive(1) Else Negitive(-1): " + (if (num >= 0)
      1
    else
      -1))

    println((if(num > 1) "Poistive" else -1).toString)




  }

}