package com.nagihome.doc

class CompWithMixins {



}

abstract class A {
  val message: String
}

class B extends A {
  val message = "I'm Instance Of Class B"
}

trait C extends A {
  def loudMessage = message.toUpperCase
}

class D extends B with C

