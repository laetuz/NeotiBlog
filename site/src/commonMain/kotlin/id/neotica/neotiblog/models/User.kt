package id.neotica.neotiblog.models

expect class User {
    val _id: String
    val username: String
    val password: String

}

expect class Guest {
    val _id: String
    val username: String
}