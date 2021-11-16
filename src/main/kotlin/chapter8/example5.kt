package chapter8

import chapter13.User


//also
fun main(args : Array<String>){
    val user = User().also {
        it.printAge()
        it.printName()
    }

    println("User: $user")
}