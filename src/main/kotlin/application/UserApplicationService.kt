package org.example.application

import domain.model.user.User
import org.example.domain.model.user.UserId
import org.example.domain.model.user.UserName
import org.example.domain.repository.UserRepository
import io.grpc.Status

class UserApplicationService(private val userRepository: UserRepository) {

    fun registerUser(id: String, name: String) {
        val userId = UserId.from(id)
        val userName = UserName.from(name)

        // すでに存在している場合は例外
        if (userRepository.findById(userId) != null) {
            throw Status.ALREADY_EXISTS
                .withDescription("User with id $id already exists.")
                .asRuntimeException()
        }

        val user = User.create(userId, userName)
        userRepository.save(user)
    }

    fun getUser(id: String): User? {
        val userId = UserId.from(id)
        return userRepository.findById(userId)
    }
}
