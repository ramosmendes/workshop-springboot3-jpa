# 🚀 WorkShop Spring Boot 3 & JPA

Um projeto workshop para explorar o poderoso universo Java com Spring Boot 3 e JPA. Aprenda enquanto codifica e divirta-se!

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1-green.svg)](https://spring.io/projects/spring-boot)

## 📌 Visão Geral

Este projeto é um workshop prático que demonstra:
- ✅ Operações CRUD completas
- ✅ Relacionamentos entre entidades JPA
- ✅ Arquitetura em camadas (Controller-Service-Repository)
- ✅ Tratamento elegante de exceções
- ✅ API RESTful bem estruturada

## 🛠️ Tecnologias Utilizadas

**Backend:**
- Java 17
- Spring Boot 3.1
- Spring Data JPA
- H2 Database (embutido)
- Lombok

**Ferramentas:**
- Maven
- Postman (para testar a API)

## 📦 Dependências Principais

<details>
<summary>🔽 Ver/Ocultar dependências</summary>

```xml
<dependencies>
    <!-- Spring Boot Starters -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    
    <!-- Conexão BD -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Utilitários -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    
    <!-- Testes -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```
</details>

## 🚀 Como Executar

### Pré-requisitos
- JDK 17 ou superior instalado
- Maven 3.6+
- (Opcional) Postman ou similar para testar a API

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/ramosmendes/workshop-springboot3-jpa.git
   cd workshop-springboot3-jpa
   ```
2. **Execute com Maven:**
```bash
mvn spring-boot:run
```
3. **Acesse a aplicação:**
- **API REST:** `http://localhost:8080`
- **Console do H2 Database:** `http://localhost:8080/h2-console`
  - Credenciais:
    - **JDBC URL:** `jdbc:h2:mem:testdb`
    - **User:** `sa`
    - **Password:** (deixe em branco)
