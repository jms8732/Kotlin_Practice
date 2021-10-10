package `coroutine-pratice`

import kotlinx.coroutines.*

var acquired = 0

class Resource {
    init {
        acquired++
    }

    fun close() {
        acquired--
    }
}


fun main() {
    runBlocking {
        repeat(100_000) {
            launch {
                val resource = withTimeout(60) {
                    Resource()
                }
                resource.close()
            }
        }
    }

    println(acquired)
    /* try {
         withTimeout(1300L) {
             repeat(1000) { i ->
                 println("I'm sleeping $i ...")
                 delay(500L)
             }
         }
     }catch (e: Exception){
         //do something
     }

     val result = withTimeoutOrNull(1300L){
         repeat(1000){ i->
             println("I'm sleeping $i ....")
             delay(500L)
         }
         "Done"
     }

     println("Result is $result")*/


/*    //Run non-cancellable block
    val job = launch {
        try{
            repeat(1000){i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }finally {
            withContext(NonCancellable){
                //this code will not be cancelled
                println("job: i'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because i'm non-cancellable")
            }
        }
    }*/


    /*   //closing resources with finally
       val job = launch {
           try{
               repeat(1000){ i ->
                   println("job: i'm sleeping $i....")
                   delay(500L)
               }
           }finally {
               println("job: I'm running finally")
           }
       }*/


/*    //making computation code cancellable
    val startTime= System.currentTimeMillis()
    val job = launch(Dispatchers.Default){
        var nextPrintTime = startTime
        var i = 0

        while (isActive){
            if(System.currentTimeMillis() >= nextPrintTime){
                println("job: I'm sleeping ${i++}...")
                nextPrintTime += 500L
            }
        }
    }*/

    /* //cancellation is cooperative
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime

        var i = 0


        while(i < 5){
            if(System.currentTimeMillis() >= nextPrintTime){
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }*/

    /*// cancelling coroutine execution
    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i....")
            delay(500L)
        }
    }
    */


    /*delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now i can quit.")*/
}

