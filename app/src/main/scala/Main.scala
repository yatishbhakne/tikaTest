import org.apache.tika.Tika

import java.io.File
import scala.util.{Failure, Success, Try}

object Main extends App {
  private val tikaInstance = new Tika()

  if(args.length == 1) {
    Try {
      tikaInstance.detect(new File(args.head))
    } match {
      case Success(contentType) => Console.println(s"Detected content: $contentType")
      case Failure(exception) => Console.println(s"Failed to parse file. StackTrace: ${exception.getStackTrace.mkString("Array(", "\n", ")")}")
    }
  } else Console.println(s"Failed: Please provide one file for parsing")
}
