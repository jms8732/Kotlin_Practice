package chapter8


var name : String = "kim"
get() = "jang"


fun main(args: Array<String>) {
    val user = User()
    println("Name: ${user.name}, Age: ${user.age}")
}

class User {
    var name: String
        get() = name
        set(value) {
            name = value
        }
    val age get() = 10
}