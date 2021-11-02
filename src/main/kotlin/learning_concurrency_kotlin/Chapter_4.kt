package learning_concurrency_kotlin

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main(args : Array<String>) : Unit = runBlocking{
    /*GlobalScope.launch(Dispatchers.Unconfined) {
        println("Starting in ${Thread.currentThread().name}")
        delay(1000L)
        println("Resuming in ${Thread.currentThread().name}")
    }.join()

    val dispatcher = newSingleThreadContext(name = "myThread")

    GlobalScope.launch(dispatcher){
        println("Starting in ${Thread.currentThread().name}")
        delay(500L)
        println("Resuming in ${Thread.currentThread().name}")
    }.join()


    val dispatcherPool = newFixedThreadPoolContext(4,"myPool")

    GlobalScope.launch(dispatcherPool) {
        println("Staring in ${Thread.currentThread().name}")
        delay(500L)
        println("Resuming in ${Thread.currentThread().name}")
    }.join()


    val handler = CoroutineExceptionHandler { context, throwable ->
        println("Error captured in $context")
        println("Message: ${throwable.message}")
    }

    GlobalScope.launch(handler) {
        TODO("Not implemented yet!")
    }

    delay(500L)*/

   /* val duration = measureTimeMillis {
        val job = launch {
            try{
                while(isActive){
                    delay(500L)
                    println("still running")
                }
            }finally {
                withContext(NonCancellable) {
                    println("cancelled, will end now")
                    delay(5000L)
                    println("delay completed, bye bye")
                }

            }
        }
        delay(1200L)
        job.cancelAndJoin()
    }

    println("Took $duration ms")*/

   /* val dispatcher = newSingleThreadContext("myThread")
    val handler = CoroutineExceptionHandler { context, throwable ->
        println("Error captured")
        println("Message: ${throwable.message}")
    }

    val context = dispatcher + handler
    val tmpCtx = context.minusKey(dispatcher.key)

    GlobalScope.launch(tmpCtx) {
        println("Running in ${Thread.currentThread().name}")
        TODO("Not implemented")
    }.join()*/

    val dispatcher = newSingleThreadContext("myThread")
    val name = GlobalScope.async(dispatcher) {
        "Susan Calvin"
    }.await()

    println("User $name")

    val name1= withContext(dispatcher){
        "Susan Calvin"
    }
    println("User1 $name1")
}

data class Profile(
    val id : Long,
    val name : String,
    val age : Int
)