package mycurd

import org.scalatest.BeforeAndAfter
import org.scalatest.FunSuite
import com.knoldus.intern.Intern
import com.knoldus.intern.InternRepositoryImpl
import com.knoldus.intern.InternRepositoryImpl
import com.knoldus.intern.InternRepositoryImpl
import com.knoldus.intern.DBConnection
import java.sql.Statement
import com.knoldus.intern.DBConnection
import com.knoldus.intern.Intern

class InternRepositoryImplTest extends FunSuite with BeforeAndAfter with DBConnection {

  val internRepImpl = new InternRepositoryImpl()

  before {
    val conn = getConnection()
    val stmt = conn.createStatement()
    
    val sql = "create table interns(id int NOT NULL, name varchar(5),college varchar(100), email varchar(50), address varchar(100), PRIMARY KEY(id));"
    
    stmt.execute(sql)
  }

  after {
    val conn = getConnection()
    val stmt = conn.createStatement()
    
    val sql = "DROP table interns"
    
    stmt.execute(sql)
  }

  test("Test case for insert method") {

    val data = Intern(1, "ram", "IIT", "ram@iit.com", "delhi")

    //    val result = insert(data)

    val result = internRepImpl.insert(data)
    assert(result == 1)
  }

  test("Test case for update method") {

    val data = Intern(1, "Ram Ji", "IIT KGP", "ram@iit.com", "Delhi NCR")

    val result = internRepImpl.update(data)

    assert(result==false)

  }
  
  test("Test case for internList()")
  {
    val result = internRepImpl.internList()
    
    val rs = result match {
      case _: List[Intern]=> true
      case _ => false
    } 
    assert(rs ==true)
  }
  
  test("Test case for delete method")
  {
    
    assert(internRepImpl.delete(1) == false)
    
    
  }

}