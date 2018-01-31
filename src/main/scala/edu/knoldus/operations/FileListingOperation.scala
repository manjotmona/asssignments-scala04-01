package edu.knoldus.operations

import java.io.File

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by manjot on 30/1/18.
 */
class FileListingOperation {
  def getListOfFiles(dir: String): Future[List[String]] = Future {
    val d = new File(dir)
    def recursive(listOfDirectories: List[File],listOfFiles: List[String]): List[String] = {
      listOfDirectories match {
        case head :: tail if head.isFile =>
         // val path = Paths.get(dir,head.getName).toString
          recursive(tail, head.getAbsolutePath :: listOfFiles)

        case head :: tail if head.isDirectory =>
         val l =  head.listFiles.toList
          recursive(l ::: tail , listOfFiles)

        case Nil => listOfFiles
      }
    }
   // print(d.listFiles.toList)
    recursive(List(d), List())

  }
}
