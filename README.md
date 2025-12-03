
# Java Socket Chat Applications

This repository contains multiple **Java socket applications** for learning and experimenting with network programming:

---

## **Project Files**

### 1. `EchoServer.java`
- A **simple single-client server**  
- Receives messages from the client and **returns them back to the same client** (echo)  
- Useful to understand **basic socket communication**

### 2. `EchoClient.java`
- Client for `MultClientContinuous.java` (group chat server)  
- Connects to the server, sends messages, and **reads incoming messages from others**  
- Supports **username** and a `>>` typing prompt

### 3. `MultClientContinuous.java`
- **Continuous multi-client chat server**  
- Handles **multiple clients using threads**  
- Broadcasts messages to **all clients except the sender**  
- Supports **usernames** and clean connection/disconnection handling

### 4. `MultiClientServer.java`
- **Multi-client echo server**  
- Similar to `EchoServer` but supports **multiple users**  
- Each client receives **their own echoed messages** only

---

## **How to Run**

### 1️⃣ Single-client echo

- Start `EchoServer`:
```bash
javac EchoServer.java
java EchoServer
````

* Start `EchoClient`:

```bash
javac EchoClient.java
java EchoClient
```

---

### 2️⃣ Multi-client group chat

* Start `MultClientContinuous` (server):

```bash
javac MultClientContinuous.java
java MultClientContinuous
```

* Start `EchoClient` (or any client) for each user:

```bash
javac EchoClient.java
java EchoClient
```

* Enter **username** and start chatting with multiple clients

---

### 3️⃣ Multi-client echo

* Start `MultiClientServer`:

```bash
javac MultiClientServer.java
java MultiClientServer
```

* Connect clients similarly using `EchoClient` or a custom client

---

## **Features**

* Multi-client support using **threads**
* Continuous messaging with **broadcast**
* Usernames for group chat
* `>>` prompt for typing messages
* Easy to extend for learning network programming

---

## **Notes**

* Use **localhost** for testing on the same machine
* For internet access, use **ngrok TCP tunnels** or deploy on a cloud server
* Type `exit` to leave the chat

---



