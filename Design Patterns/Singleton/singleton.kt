class User(val id: Int, val name: String)

object UserManager {

    private val users = mutableListOf<User>()

    fun addUser(name: String) {
        val newUser = User(id = users.size + 1, name = name)
        users.add(newUser)
    }

    fun listUsers() {
        if(users.isEmpty()) {
            println("Não há usuários cadastrados.")
        } else {
            for (user in users) {
                println("${user.id} - ${user.name}")
            }
        }
    }
}

fun main() {
    val quantity = readLine()?.toIntOrNull() ?: 0

    for (i in 1..quantity) {
        val name = readLine() ?: ""
        UserManager.addUser(name)
    }

    UserManager.listUsers()
}