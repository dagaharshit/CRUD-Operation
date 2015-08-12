package com.knoldus.intern

import java.sql.Connection
import com.typesafe.config.ConfigFactory
import java.sql.DriverManager
import java.io.IOException
import java.sql.SQLException
import java.io.IOException
import java.sql.SQLException

/**
 * @author knoldus
 */

trait DBConnection {

  val config = ConfigFactory.load()

  @throws(classOf[IOException])
  @throws(classOf[ClassNotFoundException])
  @throws(classOf[SQLException])
  def getConnection(): Connection = {

    Class.forName(config.getString("db.driver"))
    DriverManager.getConnection(config.getString("db.url"), config.getString("db.username"), config.getString("db.password"))
  }

}

