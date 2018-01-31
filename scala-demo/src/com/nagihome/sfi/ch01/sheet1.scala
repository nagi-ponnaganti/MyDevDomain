package com.nagihome.sfi.ch01

import scala.math._
import scala.io.StdIn

object sheet1 {

  def main(args: Array[String]): Unit = {
    println("Welcome to scala worksheet")
    val answer = 8 * 5 + 2
    answer * 0.5
    println(("Hello, " + answer).toUpperCase)
    println(BigInt.probablePrime(8, scala.util.Random))
    val s: String = "Hello"
    val i: Int = 4
    printf("%dth Char Of %s: %s\n", i, s, s(4))
    println("BiersTube".containsSlice('r'.to('u')))

    val x = 2
    val x0 = 1
    val y = 4
    val y0 = 3

    val dx = x - x0;
    val dy = y - y0;
    println("Calculated Value: " + Math.sqrt(dx * dx + dy * dy));

    var z = 1
    val noValue: Unit = {
      z += 1
    }
    println("No Value: " + noValue);

    var name: String = "Nagi"
    var age: Int = 30

    print(f"Hello $name! In 6 months you will be ${age + 0.5}%7.2f years old!! %n")

    val inputName = StdIn.readLine("Enter your Name: ")
    print("Enter Your Age: ")
    val inputAge : Int = StdIn.readInt()

    print(f"Hello $inputName!!, your age is $inputAge%2.2f %n")

  }

}
