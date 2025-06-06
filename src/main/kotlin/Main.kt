package org.example

import io.grpc.Server
import io.grpc.ServerBuilder
import org.example.application.UserApplicationService
import org.example.domain.repository.UserRepository
import org.example.infra.repository.InMemoryUserRepository
import org.example.interfaces.grpc.UserServiceImpl

fun main() {
    // ポート番号の取得（環境変数 or デフォルト）
    val port = System.getenv("GRPC_PORT")?.toIntOrNull() ?: 9090

    // アプリケーションサービスの作成（簡易DI）
    val userApplicationService = createUserApplicationService()

    // リポジトリとアプリケーションサービスのインスタンス化
//    val userRepository: UserRepository = InMemoryUserRepository()
//    val userApplicationService = UserApplicationService(userRepository)

    val server: Server = ServerBuilder
        .forPort(port)
        .addService(UserServiceImpl(userApplicationService))
        .build()

    server.start()
    println("✅ gRPC server started on port $port")

    // JVM終了時にサーバを安全にシャットダウン
    Runtime.getRuntime().addShutdownHook(Thread {
        println("🛑 Shutting down gRPC server...")
        server.shutdown()
        println("🧹 Server shut down.")
    })

    // サーバをブロックして待機
    server.awaitTermination()
}

// アプリケーションサービスの作成処理（責務分離）
fun createUserApplicationService(): UserApplicationService {
    val userRepository = InMemoryUserRepository()
    return UserApplicationService(userRepository)
}
