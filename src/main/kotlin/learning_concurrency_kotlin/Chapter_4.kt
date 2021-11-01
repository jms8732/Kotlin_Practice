package learning_concurrency_kotlin

import kotlinx.coroutines.runBlocking

fun main(args : Array<String>) = runBlocking{
    val client : ProfileServiceRepository = ProfileServiceClient()
    val profile = client.fetchById(12)
    println(profile)
}

data class Profile(
    val id : Long,
    val name : String,
    val age : Int
)