package chapter13

//run
fun main (args : Array<String>){
    val result = User().run {
        printName()
        printAge()

        age = 30
        "Run Return Result"
    }

    println("Result: $result")
}

class User{
    var name : String = "jms8732"
    var age : Int = 10


    fun printName(){
        println("Name: $name")
    }

    fun printAge(){
        println("Age: $age")
    }
}