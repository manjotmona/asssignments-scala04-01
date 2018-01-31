package edu.knoldus

import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global


import edu.knoldus.operations.FileListingOperation

/**
 * Created by pallavi on 30/1/18.
 */
object Application extends App{
  val fileListingOperation = new FileListingOperation()
  val list =  fileListingOperation.getListOfFiles("/home/pallavi/git-ass/kip-2018/git-assignment/.git/logs")

  list onComplete {
    case Success(list)=> println("Success\n "+ list)
    case Failure(list)=> println("Failure: Could not load file!!")
  }

Thread.sleep(1000)
}
