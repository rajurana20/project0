package com.revature.bankapp.cli

import com.revature.bankapp.model.User
import scala.util.matching.Regex
import java.io.FileNotFoundException
import com.revature.bankapp.fileio.UserFileUtil
import scala.io.StdIn

class UserCli {
  val commandArgPattern: Regex = "(\\w+)\\s*(.*)".r
  def printWelcome(): Unit = {
    println("Welcome to Revature Banking App!")
  }

  /** Prints the commands available to the user
    */
  def printOptions(): Unit = {
    println("Commands available:")
    println(
      "add user : allows to add user"
    )
    println("update user : allows user update")
    println("delete user : allows user deletion")
    println("view users : View all users")
  }
    def getUserInfo(): Unit = {}
    def menu(): Unit = {
      printWelcome()
      var continueMenuLoop = true
      while (continueMenuLoop) {
        printOptions()
        // take user input using StdIn.readLine
        // readLine is *blocking* which means that it pauses program execution while it waits for input
        // this is fine for us, but we do want to take note.
        val input = StdIn.readLine()
        // Here's an example using our regex above, feel free to just follow along with similar commands and args
        input match {
          case commandArgPattern(cmd, arg)
              if cmd.equalsIgnoreCase("wordcount") => {
           // wordcount(arg)
          }
          case commandArgPattern(cmd, arg) if cmd.equalsIgnoreCase("echo") => {
            println(arg)
          }
          case commandArgPattern(cmd, arg) if cmd.equalsIgnoreCase("exit") => {
            continueMenuLoop = false
          }
          case commandArgPattern(cmd, arg)
              if cmd.equalsIgnoreCase("addfive") => {
            //addFive(arg)
          }
          case commandArgPattern(cmd, arg)
              if cmd.equalsIgnoreCase("view")&& arg.equalsIgnoreCase("users") => {
            printTextContent("user.txt")
          }
          case commandArgPattern(cmd, arg) => {
            println(
              s"""Failed to parse command: "$cmd" with arguments: "$arg""""
            )
          }
          case _ => {
            println("Failed to parse any input")
          }
        }
      }
      println("Thank you for using Word Count CLI, goodbye!")
    }
    def printTextContent(arg: String) = {
      try {
        println(UserFileUtil.getTextContent(arg))
      } catch {
        case fnfe: FileNotFoundException => {
          println(s"Failed to find file: ${fnfe.getMessage}")
        }
      }
    }
}
