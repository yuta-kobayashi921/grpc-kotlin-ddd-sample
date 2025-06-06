package org.example.domain.repository

import domain.model.user.User
import org.example.domain.model.user.UserId

interface UserRepository {
    fun findById(id: UserId): User?
    fun save(user: User)
}
