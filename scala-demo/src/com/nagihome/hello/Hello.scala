package com.nagihome.hello

import scala.collection.mutable
import scala.collection.mutable.HashMap

class Hello {
  
  private var labelToValueMap = mutable.HashMap.empty[String, String]
  
  def labelToValue : HashMap[String, String] = labelToValueMap
  
}