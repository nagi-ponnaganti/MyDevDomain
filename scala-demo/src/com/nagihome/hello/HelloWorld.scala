package com.nagihome.hello


object HelloWorld {
 
  var hello : String ="foo" 
  
  val factor = 3
  val multiplier = (i:Int) => i*factor
  
  def main(args: Array[String]): Unit = {
    println("Hello Scala " + multiplier(3));
    
    var hello = new Hello
    
    hello.labelToValue += ("FirstName" -> "Nagi")
    
    println(hello.labelToValue.size)
    
  }
  
}