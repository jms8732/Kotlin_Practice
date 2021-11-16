package chapter8

import chapter13.User

//with
fun main(args : Array<String>){
    val user = User()

    val result = with(user){
        printAge()
        printName()

        3+ 4
    }

    println("Result: $result")
}