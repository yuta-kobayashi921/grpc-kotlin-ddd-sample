package org.example.domain.model.user

import jakarta.persistence.Embeddable
import java.util.*

@JvmInline
@Embeddable
value class UserId private constructor(val value: String) {
    // value classの最適化を保ちつつバリデーションを実現するため companion object を使用
    companion object {
        fun from(value: String): UserId {
            require(value.isNotBlank()) { "UserId must not be blank." }
            return UserId(value)
        }
    }

    override fun toString(): String = value
}
