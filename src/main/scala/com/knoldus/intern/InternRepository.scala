package com.knoldus.intern


trait InternRepository {

  def insert(intern: Intern): Int
  def update(intern: Intern): Boolean
  def delete(id: Int): Boolean
  def internList(): List[Intern]
}