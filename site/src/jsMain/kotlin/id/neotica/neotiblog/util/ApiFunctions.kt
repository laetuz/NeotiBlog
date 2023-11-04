package id.neotica.neotiblog.util

import com.varabyte.kobweb.browser.api
import id.neotica.neotiblog.models.Guest
import id.neotica.neotiblog.models.User
import kotlinx.browser.window
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

suspend fun checkUserExistence(user: User): Guest? {
    return try {
        var result = window.api.tryPost(
            apiPath = "usercheck",
            body = Json.encodeToString(user).encodeToByteArray(),
        )
        result?.decodeToString()?.let { Json.decodeFromString<Guest>(it) }
    } catch (e: Exception) {
        println(e.message)
        null
    }
}