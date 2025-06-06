package org.example.infra.repository


import domain.model.user.User
import org.example.domain.model.user.UserId
import org.example.domain.repository.UserRepository

/**
 * 学習目的の簡易実装。
 * 本来は永続化層（例：RDB）で実装すべきリポジトリを、今回はDDD学習のためにインメモリで代用。
 * 実運用ではDBアクセスを担うインフラ層の実装に差し替えることを想定している。
 */
class InMemoryUserRepository : UserRepository {
    private val users = mutableMapOf<UserId, User>()

    override fun findById(id: UserId): User? {
        return users[id]
    }

    override fun save(user: User) {
        users[user.id] = user
    }
}
