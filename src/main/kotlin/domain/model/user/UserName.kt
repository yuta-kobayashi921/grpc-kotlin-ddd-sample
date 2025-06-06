package org.example.domain.model.user

import jakarta.persistence.Embeddable


@JvmInline
@Embeddable
value class UserName private constructor(val value: String) {
    // value classの最適化を保ちつつバリデーションを実現するため companion object を使用
    companion object {
        fun from(value: String): UserName {
            require(value.isNotBlank()) { "UserName must not be blank." }
            require(value.length <= 20) { "UserName must be 20 characters or less." }
            return UserName(value)
        }
    }

    override fun toString(): String = value
}
