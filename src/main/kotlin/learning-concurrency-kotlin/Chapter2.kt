package `learning-concurrency-kotlin`

import kotlinx.coroutines.*
import kotlin.UnsupportedOperationException

fun main(args : Array<String>) = runBlocking<Unit>{
    val dispatcher = newSingleThreadContext(name = "ServiceCall")
    val task = GlobalScope.launch {
        doSomething()
    }

    task.join()
    println("Complete")
}

fun doSomething(){
    throw UnsupportedOperationException("Can't do")
}