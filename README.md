# CoinSec

基于Spring Boot 3构建的账户管理系统，用于个人财务管理、记账等用途。

## 项目简介

CoinSec是一个财务管理应用后端服务，提供账户管理、收支记录、转账等功能。系统采用现代化的技术栈，具有良好的可扩展性和安全性。

## 技术栈

- **后端框架**: Spring Boot 3.5.5
- **编程语言**: Java 21
- **数据库**: MariaDB
- **缓存**: Redis
- **持久层框架**: MyBatis Plus
- **安全框架**: Sa-Token
- **构建工具**: Maven

## 主要功能

- 用户账户管理
- 多种账户类型支持（银行卡、微信、支付宝、现金等）
- 收支记录管理
- 账户间转账功能
- 数据统计与分析

## 项目结构

```
src
├── main
│   ├── java
│   │   └── com.coinsec
│   │       ├── config      配置类
│   │       ├── controller  控制器
│   │       ├── dto         数据传输对象
│   │       ├── entity      实体类
│   │       ├── exception   异常处理
│   │       ├── mapper      MyBatis映射接口
│   │       ├── service     业务逻辑层
│   │       └── utils       工具类
│   └── resources
│       ├── application.yaml  配置文件
│       └── xml              MyBatis XML映射文件
└── test                     测试代码
```

## 数据库设计

项目包含以下核心数据表：

- `account` - 账户表
- `account_record` - 记账记录表
- `account_transaction` - 账户余额变动表
- `account_transfer` - 账户转账主表

数据库脚本位于 `SQL/account.sql` 文件中。

## 快速开始

### 环境要求

- Java 21
- Maven 3.x
- MariaDB
- Redis

### 构建和运行

1. 克隆项目到本地
2. 配置数据库连接信息（修改 `application.yaml`）
3. 创建数据库并执行 `SQL/account.sql` 脚本
4. 使用Maven构建项目：
   ```bash
   mvn clean package
   ```
5. 运行应用：
   ```bash
   mvn spring-boot:run
   ```
   或
   ```bash
   java -jar target/CoinSec-0.0.1-SNAPSHOT.jar
   ```

## 安全框架

项目使用Sa-Token作为安全框架，提供身份验证和授权功能。

## 开发工具

- 推荐使用IntelliJ IDEA进行开发
- 启用Lombok插件以支持注解
- 配置Spring Boot DevTools实现热部署

## 注意事项

1. 项目使用了较新的Spring Boot版本（3.5.5），请确保Java版本兼容
2. 项目中使用了Lombok，请在IDE中安装相应插件
3. 数据库连接信息需要根据实际环境进行配置

## 许可证

本项目仅供学习和参考使用。