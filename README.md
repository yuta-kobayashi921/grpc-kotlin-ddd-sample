# gRPC × Kotlin × DDD サンプル

このリポジトリは、Kotlin と gRPC、ドメイン駆動設計（DDD）を組み合わせたサンプルアプリケーションです。  
MySQLなどのDBを使用せず、In-Memoryリポジトリで構成されています。

## 主な構成
- 値オブジェクト（Value Object）：UserId, UserName
- エンティティ（Entity）：User
- リポジトリ（Repository）：UserRepository, InMemory実装
- アプリケーションサービス（Application Service）：UserApplicationService
- gRPCサービス：RegisterUser / GetUser

## 実行方法
bash
```
./gradlew build
./gradlew run
```

## Postmanでの確認方法
.proto を読み込んだ上で、下記のメッセージを送信してください：

json
```
{
  "id": "u001",
  "name": "Taro"
}
```

# gRPC × Kotlin × DDD Sample (English)

This is a sample project that combines Kotlin, gRPC, and Domain-Driven Design (DDD).
It uses an in-memory repository instead of a database such as MySQL.

## Features
- Value Objects: UserId, UserName
- Entity: User
- Repository: UserRepository with in-memory implementation
- Application Service: UserApplicationService
- gRPC APIs: RegisterUser / GetUser

## Run

bash
```
./gradlew build
./gradlew run
```


## Testing with Postman
Import the .proto file, and send the following message:

json
```
{
  "id": "u001",
  "name": "Taro"
}
```

