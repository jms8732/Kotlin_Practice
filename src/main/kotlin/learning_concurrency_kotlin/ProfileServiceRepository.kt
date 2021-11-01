package learning_concurrency_kotlin

import kotlinx.coroutines.Deferred

interface ProfileServiceRepository {
    suspend fun fetchByName(name : String) : Profile
    suspend fun fetchById(id : Long): Profile
}