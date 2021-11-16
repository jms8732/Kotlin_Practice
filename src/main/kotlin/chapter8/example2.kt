package chapter8

import chapter13.User
import java.util.*

//apply
fun main(args : Array<String>){
    val list = mutableListOf(3,5,1,6,2).apply {
        add(8)
        sortDescending()
    }

    list.print()
}

fun <E> List<E>.print(){
    this.forEach {
        print("$it ")
    }
}
