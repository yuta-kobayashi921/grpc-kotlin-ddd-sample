package domain.model.user

import org.example.domain.model.user.UserId
import org.example.domain.model.user.UserName

class User private constructor(
    val id: UserId,
    val name: UserName
) {
    companion object {
        fun create(id: UserId, name: UserName): User {
            return User(id, name)
        }
    }

    fun rename(newName: UserName): User {
        return User(id, newName)
    }
}