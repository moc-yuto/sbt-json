import java.io.File

import org.apache.commons.io.FileUtils
import org.json4s.DefaultFormats
import org.json4s.native.JsonMethods._

object ParseJson {
  case class User(id: Int, name: String)
  implicit val formats = DefaultFormats
  def open(filename: String) = {
    val file = new File(filename)
    val json = FileUtils.readFileToString(file)
    val parsedJson = parse(json).extract[User]
    println(toMessage(parsedJson))
  }

  def toMessage(user: User): String = {
    s"userId: ${user.id}, userName: ${user.name}"
  }
}
