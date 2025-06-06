package org.example.interfaces.grpc

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.example.application.UserApplicationService
import user.UserRequest
import user.UserResponse
import user.UserServiceGrpcKt
import io.grpc.Status

class UserServiceImpl(
    private val userApplicationService: UserApplicationService
) : UserServiceGrpcKt.UserServiceCoroutineImplBase() {

    override suspend fun registerUser(request: UserRequest): UserResponse = withContext(Dispatchers.IO) {
        userApplicationService.registerUser(request.id, request.name)
        UserResponse.newBuilder()
            .setId(request.id)
            .setName(request.name)
            .build()
    }

    override suspend fun getUser(request: UserRequest): UserResponse = withContext(Dispatchers.IO) {
        val user = userApplicationService.getUser(request.id)
            ?: throw Status.NOT_FOUND
                .withDescription("User not found")
                .asRuntimeException()

        UserResponse.newBuilder()
            .setId(user.id.value)
            .setName(user.name.value)
            .build()
    }
}