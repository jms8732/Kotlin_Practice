package `learning-concurrency-kotlin`

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
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

