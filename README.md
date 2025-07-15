# Kafka Order-Inventory App

A full-stack microservices application built using
**Spring Boot**,
**Apache Kafka**, 
**MySQL (AWS RDS)**.
 This app simulates a real-time order and inventory processing system with event-driven architecture.

---

## 🔧 Tech Stack

### 🖥 Backend
- Java 17 + Spring Boot
- Apache Kafka (Event Streaming)
- MySQL (Amazon RDS)
- Spring Data JPA, Hibernate
- REST APIs

### 🐳 Infrastructure
- Docker & Docker Compose (for Kafka/Zookeeper)
- GitHub for version control

---

## 📦 Features

- ✅ Place an order
- ✅ Orders are sent to Kafka topic `orders`
- ✅ Inventory service listens and processes order events
- ✅ Validates inventory in **real-time**
- ✅ Automatically decreases inventory count
- ✅ API to view all inventory items
- ✅ Clean modular code (DTOs, Services, Repositories, Listeners)

---

## 🚀 How to Run

1. Clone the Repo

git clone https://github.com/aayushi12jain/kafka-order-inventory-app.git
cd kafka-order-inventory-app
# kafka-order-inventory-app
kafka-order-inventory-app

2. Start Kafka + Zookeeper

cd docker
docker-compose up -d

3. Start Backend Services

cd order-pipeline
mvn clean install
java -jar target/order-pipeline-0.0.1-SNAPSHOT.jar
cd ../inventory-service
mvn clean install
java -jar target/inventory-service-0.0.1-SNAPSHOT.jar

Make sure your MySQL RDS DB is configured and reachable.

🛠 Future Enhancements
✅ Add Kafka UI to monitor topics
⏳ Add Authentication (JWT)
📊 Inventory dashboard
📬 Order email notifications
🌐 Deploy to AWS (Elastic Beanstalk + RDS + S3)

👩‍💻 Author
Aayushi Jain
🔗 LinkedIn[https://www.linkedin.com/in/aayushi12jain/]
📧 aayushi12jain@gmail.com

⭐️ If you liked this project
Give it a star 🌟 on GitHub and share your feedback!
