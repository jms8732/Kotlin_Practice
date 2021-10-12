package `coroutine-pratice`

import kotlinx.coroutines.*


@OptIn(ObsoleteCoroutinesApi::class)
fun main(args : Array<String>)  : Unit= runBlocking{
    launch {
        println("main runblocking : I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) {
        println("Default : I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined){
        println("Unconfined : I'm working in thread ${Thread.currentThread().name}")
    }

    launch (newSingleThreadContext("MyOwnThread")){
        println("newSingleThreadContext : I'm working ${Thread.currentThread().name}")
    }

}