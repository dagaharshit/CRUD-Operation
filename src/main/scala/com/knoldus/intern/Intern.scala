

package com.knoldus.intern/**
 * @author knoldus
 */
 case class Intern(id: Int, name: String, college: String, email: String, adderss: String) {
  
  def getId(): Int = id
  def getName(): String = name
  def getCollege(): String = college
  def getEmail(): String = email
  def getAdderss(): String = adderss
  
  
}