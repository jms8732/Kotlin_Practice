package `learning-concurrency-kotlin`

import kotlinx.coroutines.*
import java.lang.UnsupportedOperationException

fun main(args : Array<String>) = runBlocking<Unit>{
    val dispatcher = newSingleThreadContext(name = "ServiceCall")
    val task = launch(dispatcher) {
        printCurrentThread()
    }

    task.join()
}

fun printCurrentThread(){
    println("Running is thread ${Thread.currentThread().name}")
}