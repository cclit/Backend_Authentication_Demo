# Backend_Authentication_Demo (Spring Boot project)
本 project 為實作登入與活動 (event) 之 CRUD 之簡易後端系統，旨在前後端分離中，與前端系統對接之技術參考 :
1. 以 JWT token 實現身分驗證
2. 以 Spring framwork 之 Interceptor 功能攔截特定功能請求並進行會員驗證 (Authentication)
3. 實作 WebMvcConfigurer 進行 CORS 管控

## 系統環境
- Java 17
- Spring Boot v3.2.7 (framework)
- Jpa/Hibernate (ORM)
- DataBase : MySQL v8.0.22

## 建置作業
1. 首先先將程式碼下載到本機指定的資料夾中，執行以下指令或是直接按右上方的下載按鈕

```
git clone https://github.com/cclit/Backend_Authentication_Demo.git
```
2. 以 Java IDE 將其以 Maven 專案匯入，並更新此專案，使其下載相關的套件 (dependency)
3. 確認電腦中有 MySQL database，沒有的話須另行下載並進行設定
4. 設定 src/main/resources/application.properties 檔裡適當的連線資訊 (下方文字xxx處)

```
## datasource
spring.datasource.url=jdbc:mysql://localhost:3306/xxx?serverTimezone=Asia/Taipei&characterEncoding=utf-8
spring.datasource.username=xxx
spring.datasource.password=xxx
```
5. 設定 src/main/resources/application.properties 檔裡適當的連線 port 號 (預設是 8080)

```
server.port=8080
```

7. 設定 src/main/resources/application.properties 檔裡與前段約定好的 key 值和 token 有效時間 (單位為小時)

```
### JWT　Properties 
authdemo.jwt.key=SuperSecretForThisAuthenticationDemoApp
authdemo.jwt.expire-time.hour=1
```

8. 於 src/main/java/com/cclit/authdemo/config/Corsfig.java 中設定 CORS 相關資訊
9. 在 IDE 中進行編譯 (build project)，並啟動專案


## API List
- Authentication

| API Name   | Route     | Method    | Description      |
|------------|:---------:|:---------:|:-----------------|
|sign up user| /signup   | POST      | New user register|
|user login  | /signup   | POST      | User Log in      |

- Event

| API Name   | Route        | Method | Description      |
|-------------|:-----------:|:------:|:-----------------|
|Get all event| /events     | GET    | list all events  |
|Event detail | /events/:id | GET    | get single event |
|add event    | /events/:id | POST   | add an new event |
|Edit event   | /events/:id | PATCH  | edit single event detail |
|Delete event | /events/:id | DELETE | delete single event |

## TODO
* add Swagger to generate API document

