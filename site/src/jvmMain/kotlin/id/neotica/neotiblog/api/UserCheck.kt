package id.neotica.neotiblog.api

import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.data.getValue
import com.varabyte.kobweb.api.http.setBodyText
import id.neotica.neotiblog.data.MongoDB
import id.neotica.neotiblog.models.Guest
import id.neotica.neotiblog.models.User
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

@Api(routeOverride = "usercheck")
suspend fun userCheck(context: ApiContext) {
    try {
        val userRequest = context.req.body?.decodeToString()?.let {
            Json.decodeFromString<User>(it)
        }
        val user = userRequest?.let {
            context.data.getValue<MongoDB>().checkUserExistence(
                User(userName = it.userName, password = hashPassword(it.password))
            )
        }
        if (user != null) {
            context.res.setBodyText(
                Json.encodeToString<Guest>(
                    Guest(
                        id = user.id ,
                        userName = user.userName
                    )
                )
            )
        } else {
            context.res.setBodyText(Json.encodeToString(Exception("User doesn't exist.")))
        }
    } catch (e: Exception) {
        context.res.setBodyText(Json.encodeToString(Exception(e.message.toString())))
    }
}

private fun hashPassword(password: String): String {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    val hasBytes = messageDigest.digest(password.toByteArray(StandardCharsets.UTF_8))
    val hexString = StringBuffer()

    for (byte in hasBytes) {
        hexString.append(String().format("%02x", byte))
    }

    return hexString.toString()
}