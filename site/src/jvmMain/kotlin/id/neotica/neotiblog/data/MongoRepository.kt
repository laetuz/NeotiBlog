package id.neotica.neotiblog.data

import id.neotica.neotiblog.models.User

interface MongoRepository {
    suspend fun checkUserExistence(user: User): User?
    suspend fun checkUserId(id: String): Boolean
}