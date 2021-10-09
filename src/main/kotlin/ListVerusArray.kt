import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.suspendCoroutine

val LAST = 100000000
val START = 0

fun main(): Unit = runBlocking {
    val array = ArrayList<Int>()
    val list = mutableListOf<Int>()

    var start = 0L
    var end = 0L

    launch {
        println("===================Array===================")
        start = System.currentTimeMillis()
        println("Start: $start")
        for (i in START until LAST)
            array.add(i)
        end = System.currentTimeMillis()
        println("End: $end")
        println("Result: ${(end - start)}ms")
    }


    launch {
        println("===================List===================")
        start = System.currentTimeMillis()
        println("Start: $start")
        for (i in START until LAST)
            list.add(i)
        end = System.currentTimeMillis()
        println("End: $end")
        println("Result: ${(end - start)}ms")
    }
}


