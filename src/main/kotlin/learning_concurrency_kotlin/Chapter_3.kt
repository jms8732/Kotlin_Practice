package learning_concurrency_kotlin

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main(args: Array<String>): Unit = runBlocking {
    val task = measureTimeMillis {
        val job = GlobalScope.launch{
            delay(2000L)
        }

        job.join()

        //restart
        job.start()
        job.join()
    }

    println("Time: $task ms")
}

