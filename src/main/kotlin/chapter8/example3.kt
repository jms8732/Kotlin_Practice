package chapter8

import chapter13.User

//let
fun main(args: Array<String>) {
    val result = User().apply {
        age = 25
        name = "james"
    }.let {
        letPrintlnTest(it)
        letPrintlnTest1(it)
        3 +4
    }

    println("Result: $result")
}

fun letPrintlnTest(user: User) {
    println("User info: ${user.name}, ${user.age}")
}

fun letPrintlnTest1(user : User){
    println("User info1: ${user.name}, ${user.age}")
}
