package com.knoldus.intern

import java.sql.Connection
import java.sql.{ Statement, ResultSet }
import scala.collection.mutable.ListBuffer
import org.slf4j.LoggerFactory
import java.io.IOException
import java.sql.SQLException

/**
 * @author knoldus
 */
class InternRepositoryImpl extends InternRepository with DBConnection {

  var connection: Connection =_

  var insertCounter = 0
  val log = LoggerFactory.getLogger(this.getClass)
  def main(args: Array[String]) {

    try {

      //      //insert(Intern(2, "Harshit Daga", "Manipal University Jaipur", "dagaharshit@yahoo.com", "Bikaner"))
      connection = getConnection()
      internList.foreach { x => log.info(s"record is $x") }

    } catch {
      case e: Throwable => e.printStackTrace
    }finally{
      connection.close()
    }
    val list = internList()

  }

  def insert(intern: Intern): Int = {
    connection = getConnection()
    var stmt: Statement = connection.createStatement()

    insertCounter += 1
    val sql = "Insert into interns values(" + intern.getId() + ",'" + intern.getName() + "','" +
      intern.getCollege() + "','" + intern.getEmail() + "','" + intern.getAdderss() + "'); "
    //val sql = "INSERT into interns values(2, 'Harshit Daga', 'Manipal University Jaipur', 'dagaharshit@yahoo.com', 'Bikaner');"
    stmt.executeUpdate(sql)

  }

  def delete(id: Int): Boolean = {
    connection = getConnection()
    var stmt: Statement = connection.createStatement()

    val sql = "DELETE from interns where id = " + id

    stmt.execute(sql)

  }

  def internList(): List[Intern] = {
    connection = getConnection()
    
    val listIntern: ListBuffer[Intern] = ListBuffer()

    var stmt: Statement = connection.createStatement()
    val rs: ResultSet = stmt.executeQuery("SELECT * from interns");

    while (rs.next()) {
      listIntern.append(Intern(rs.getInt("id"), rs.getString("name"),
        rs.getString("college"), rs.getString("email"),
        rs.getString("address")))

    }

    listIntern.toList

  }

  def update(intern: Intern): Boolean =
    {
      connection = getConnection()
      val stmt: Statement = connection.createStatement()
      val sql = "Update interns set name = '" + intern.getName() +
        "', college = '" + intern.getCollege() + "', email = '" + intern.getEmail() + "', address = '" +
        intern.getCollege() + "' where id = '" + intern.getId() + "';"

      if(stmt.executeUpdate(sql)>0) true else false

    }
}