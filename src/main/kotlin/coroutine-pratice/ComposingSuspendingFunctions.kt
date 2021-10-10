package `coroutine-pratice`

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


fun main(args : Array<String>) = runBlocking<Unit>{
    val time = measureTimeMillis {
        try {
            //failedConcurrentSum()
            val one = somethingUsefulOneAsync()
           // val two = somethingUsefulTwoAsync()

            one.start()

            println("The answer is ${one.await()}")
        } catch (e: ArithmeticException) {
            println("Computation failed with ArithmeticException")
        }
    }

    println("Time : $time ms...")

    /*val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) {
            doSomethingUsefulOne()
        }
        val two = async(start = CoroutineStart.LAZY) {
            doSomethingUsefulTwo()
        }

        one.start()
        two.start()

        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")*/

    /*val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("The answer is ${one + two}")
    }

    println("Completed in $time ms ")*/
}
suspend fun failedConcurrentSum() : Int = coroutineScope {
    val one = async<Int> {
        try{
            delay(Long.MAX_VALUE)
            42
        }finally {
            println("First child was cancelled")
        }
    }

    val two = async<Int> {
        println("Second child throws an exception")
        throw ArithmeticException()
    }

    one.await() + two.await()
}

suspend fun somethingUsefulOneAsync() = GlobalScope.async {
    val one = async<Int> {
        try{
            delay(Long.MAX_VALUE)
            42
        }finally {
            println("First child was cancelled")
        }
    }

    val two = async<Int> {
        println("Second child throws an exception")
        throw ArithmeticException()
    }

    one.await() + two.await()
}

suspend fun somethingUsefulTwoAsync() = GlobalScope.async {
    doSomethingUsefulTwo()
}

suspend fun doSomethingUsefulOne() : Int{
    delay(Long.MAX_VALUE)
    return 49
}

suspend fun doSomethingUsefulTwo() : Int{
    throw ArithmeticException()
}