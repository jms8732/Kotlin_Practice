package `coroutine-pratice`

import kotlinx.coroutines.*



fun main() = runBlocking{
    repeat(100_000){
        launch {
            delay(5000L)
            print(".")
        }
    }
}


