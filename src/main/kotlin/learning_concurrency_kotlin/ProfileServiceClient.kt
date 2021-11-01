package learning_concurrency_kotlin

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class ProfileServiceClient : ProfileServiceRepository {
    override suspend fun fetchByName(name: String): Profile{
        return Profile(1,name,28)
    }

    override suspend fun fetchById(id: Long): Profile{
        return Profile(id,"Susan",28)
    }
}