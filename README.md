# Client-Server


Colección de ejercicios prácticos sobre arquitectura cliente-servidor implementados en Java. Este repositorio contiene ejemplos de servidores web, comunicación con datagramas UDP, y un sistema de chat usando RMI (Remote Method Invocation).

## 📋 Tabla de Contenidos

- [Descripción](#-descripción)
- [Ejercicios](#-ejercicios)
  - [Ejercicio 1: Información de URL](#ejercicio-1-información-de-url)
  - [Ejercicio 4.3.1: Echo Server Básico](#ejercicio-431-echo-server-básico)
  - [Ejercicio 4.3.2: Echo Server con Funciones Matemáticas](#ejercicio-432-echo-server-con-funciones-matemáticas)
  - [Ejercicio 4.4: Servidor Web Simple](#ejercicio-44-servidor-web-simple)
  - [Ejercicio 5.2.1: Cliente de Tiempo con Datagramas](#ejercicio-521-cliente-de-tiempo-con-datagramas)
  - [Ejercicio 6.4.1: Chat con RMI](#ejercicio-641-chat-con-rmi)
- [Requisitos](#-requisitos)
- [Instalación](#-instalación)
- [Uso](#-uso)
- [Tecnologías](#-tecnologías)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Contribuciones](#-contribuciones)
- [Autor](#-autor)

## 🎯 Descripción

Este repositorio es una colección educativa de ejercicios que exploran diferentes aspectos de la programación de red en Java, incluyendo:

- **Sockets TCP**: Implementación de servidores echo y servidores web
- **Datagramas UDP**: Comunicación sin conexión
- **RMI (Remote Method Invocation)**: Llamadas a métodos remotos para sistemas distribuidos
- **Manejo de E/S**: Uso de BufferedReader, PrintWriter, y streams

Todos los ejercicios han sido optimizados utilizando buenas prácticas como `try-with-resources` para manejo automático de recursos y manejo apropiado de excepciones.

## 🚀 Ejercicios

### Ejercicio 1: Información de URL

**Descripción**: Ejercicio introductorio que demuestra cómo extraer información de una URL utilizando la clase `java.net.URL`.

**Archivo**: [`src/main/java/arsw/exerciseOne/URLInformation.java`](src/main/java/arsw/exerciseOne/URLInformation.java)

**Funcionalidades**:
- Extracción de protocolo, autoridad, host, puerto, path, query, file y ref de una URL

**Demostración**:

![Captura de pantalla del Ejercicio 1](#)

---

### Ejercicio 4.3.1: Echo Server Básico

**Descripción**: Implementación de un servidor echo clásico que recibe mensajes del cliente y los devuelve exactamente como fueron enviados.

**Archivos**:
- Servidor: [`src/main/java/arsw/exersiceFourthThreeOne/EchoServer.java`](src/main/java/arsw/exersiceFourthThreeOne/EchoServer.java)
- Cliente: [`src/main/java/arsw/exersiceFourthThreeOne/EchoClient.java`](src/main/java/arsw/exersiceFourthThreeOne/EchoClient.java)

**Características**:
- Servidor escuchando en puerto `35000`
- Comunicación bidireccional con sockets TCP
- Uso de `try-with-resources` para gestión automática de recursos
- Manejo mejorado de excepciones

**Demostración**:

![Captura de pantalla del Ejercicio 4.3.1](#)

---

### Ejercicio 4.3.2: Echo Server con Funciones Matemáticas

**Descripción**: Versión mejorada del servidor echo que procesa funciones trigonométricas (sin, cos, tan) sobre números enviados por el cliente.

**Archivos**:
- Servidor: [`src/main/java/arsw/exerciseFourthThreeTwo/EchoServerFun.java`](src/main/java/arsw/exerciseFourthThreeTwo/EchoServerFun.java)
- Cliente: [`src/main/java/arsw/exerciseFourthThreeTwo/EchoClientFun.java`](src/main/java/arsw/exerciseFourthThreeTwo/EchoClientFun.java)

**Características**:
- Servidor escuchando en puerto `35001`
- Procesamiento de funciones trigonométricas: `fun:sin`, `fun:cos`, `fun:tan`
- Cambio dinámico de función mediante comandos del cliente
- Validación de entrada y manejo de errores

**Comandos disponibles**:
```
fun:sin  - Cambia la función a seno
fun:cos  - Cambia la función a coseno
fun:tan  - Cambia la función a tangente
bye      - Termina la conexión
```

**Demostración**:

![Captura de pantalla del Ejercicio 4.3.2](#)

---

### Ejercicio 4.4: Servidor Web Simple

**Descripción**: Implementación de un servidor web básico que sirve una página HTML estática.

**Archivo**: [`src/main/java/arsw/exerciseFourthFourth/WebServer.java`](src/main/java/arsw/exerciseFourthFourth/WebServer.java)

**Características**:
- Servidor HTTP en puerto `35000`
- Respuestas HTTP/1.1 con headers apropiados
- Servicio de contenido HTML
- Compatible con navegadores modernos (headers HTTP completos)

**Mejoras implementadas**:
- Headers HTTP completos requeridos por navegadores modernos
- `Content-Type` y `Content-Length` apropiados
- Línea vacía separando headers del cuerpo HTML

**Acceso**: `http://localhost:35000`

**Demostración**:

![Captura de pantalla del Ejercicio 4.4](#)

---

### Ejercicio 5.2.1: Cliente de Tiempo con Datagramas

**Descripción**: Cliente que utiliza datagramas UDP para solicitar la hora actual del servidor cada 5 segundos.

**Archivo**: [`src/main/java/arsw/exerciseFiveTwoOne/DatagramTimeClient.java`](src/main/java/arsw/exerciseFiveTwoOne/DatagramTimeClient.java)

**Características**:
- Comunicación mediante protocolo UDP
- Timeout de 5 segundos para recepción de paquetes
- Solicitudes periódicas cada 5 segundos
- Manejo robusto de timeouts y excepciones
- Uso de `try-with-resources`

**Mejoras**:
- Consolidación de manejo de excepciones similares
- Código más limpio y legible

**Demostración**:

![Captura de pantalla del Ejercicio 5.2.1](#)

---

### Ejercicio 6.4.1: Chat con RMI

**Descripción**: Sistema de chat distribuido implementado con RMI (Remote Method Invocation), permitiendo comunicación entre múltiples clientes.

**Archivos**:
- Servidor: [`src/main/java/arsw/exerciseSixFourthOne/server/ChatServerImpl.java`](src/main/java/arsw/exerciseSixFourthOne/server/ChatServerImpl.java)
- Cliente: [`src/main/java/arsw/exerciseSixFourthOne/client/ChatClientImpl.java`](src/main/java/arsw/exerciseSixFourthOne/client/ChatClientImpl.java)
- Interfaz Servidor: [`src/main/java/arsw/exerciseSixFourthOne/server/ChatServer.java`](src/main/java/arsw/exerciseSixFourthOne/server/ChatServer.java)
- Interfaz Cliente: [`src/main/java/arsw/exerciseSixFourthOne/client/ChatClient.java`](src/main/java/arsw/exerciseSixFourthOne/client/ChatClient.java)

**Características**:
- Arquitectura cliente-servidor distribuida con RMI
- Múltiples clientes conectados simultáneamente
- Broadcast de mensajes a todos los clientes conectados
- Registro y gestión dinámica de clientes
- Configuración de host remoto mediante `java.rmi.server.hostname`

**Funcionalidades**:
- **Servidor**: 
  - Gestión de clientes conectados usando `Set<ChatClient>`
  - Distribución de mensajes a todos los clientes excepto el emisor
  - Puerto RMI registry configurable
- **Cliente**: 
  - Registro automático con el servidor
  - Envío de mensajes al servidor
  - Recepción de mensajes de otros clientes

**Mejoras**:
- Eliminación de `SecurityManager` (deprecado y no necesario en entorno local)
- Uso de interfaces remotas para comunicación

**Demostración**:

![Captura de pantalla del Ejercicio 6.4.1](#)

---

## 📦 Requisitos

- **Java JDK**: 11 o superior
- **Maven**: 3.6 o superior
- **Sistema Operativo**: Windows, Linux o macOS

## 🔧 Instalación

1. **Clonar el repositorio**:
```bash
git clone https://github.com/miguelvanegas-c/Client-Server.git
cd Client-Server
```

2. **Compilar el proyecto con Maven**:
```bash
mvn clean compile
```

3. **Empaquetar el proyecto** (opcional):
```bash
mvn package
```

## 💻 Uso

### Ejecutar un ejercicio específico

Cada ejercicio puede ejecutarse de forma independiente. A continuación algunos ejemplos:

**Ejercicio 1 - URL Information**:
```bash
mvn exec:java -Dexec.mainClass="arsw.exerciseOne.URLInformation"
```

**Ejercicio 4.3.1 - Echo Server**:
```bash
# Terminal 1 - Servidor
mvn exec:java -Dexec.mainClass="arsw.exersiceFourthThreeOne.EchoServer"

# Terminal 2 - Cliente
mvn exec:java -Dexec.mainClass="arsw.exersiceFourthThreeOne.EchoClient"
```

**Ejercicio 4.3.2 - Echo Server con Funciones**:
```bash
# Terminal 1 - Servidor
mvn exec:java -Dexec.mainClass="arsw.exerciseFourthThreeTwo.EchoServerFun"

# Terminal 2 - Cliente
mvn exec:java -Dexec.mainClass="arsw.exerciseFourthThreeTwo.EchoClientFun"
```

**Ejercicio 4.4 - Web Server**:
```bash
mvn exec:java -Dexec.mainClass="arsw.exerciseFourthFourth.WebServer"
# Luego abrir en navegador: http://localhost:35000
```

**Ejercicio 5.2.1 - Datagram Time Client**:
```bash
mvn exec:java -Dexec.mainClass="arsw.exerciseFiveTwoOne.DatagramTimeClient"
```

**Ejercicio 6.4.1 - Chat RMI**:
```bash
# Terminal 1 - Servidor
mvn exec:java -Dexec.mainClass="arsw.exerciseSixFourthOne.server.ChatServerImpl"

# Terminal 2, 3, ... - Clientes
mvn exec:java -Dexec.mainClass="arsw.exerciseSixFourthOne.client.ChatClientImpl"
```

## 🛠️ Tecnologías

- **Lenguaje**: Java
- **Build Tool**: Maven
- **Librerías**:
  - `java.net.*` - Networking
  - `java.io.*` - Input/Output
  - `java.rmi.*` - Remote Method Invocation
  - `java.util.*` - Utilidades

## 📂 Estructura del Proyecto

```
Client-Server/
├── src/
│   └── main/
│       └── java/
│           └── arsw/
│               ├── exerciseOne/           # Ejercicio 1: URL Information
│               ├── exersiceFourthThreeOne/ # Ejercicio 4.3.1: Echo Server
│               ├── exerciseFourthThreeTwo/ # Ejercicio 4.3.2: Echo Server Fun
│               ├── exerciseFourthFourth/   # Ejercicio 4.4: Web Server
│               ├── exerciseFiveTwoOne/     # Ejercicio 5.2.1: Datagram Client
│               └── exerciseSixFourthOne/   # Ejercicio 6.4.1: Chat RMI
│                   ├── server/
│                   └── client/
├── www/                                    # Recursos web (HTML estático)
├── pom.xml                                 # Configuración Maven
├── .gitignore
└── README.md
```

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar este proyecto:

1. Fork el repositorio
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 👨‍💻 Autor

**Miguel Vanegas**
- GitHub: [@miguelvanegas-c](https://github.com/miguelvanegas-c)

---

⭐ Si este proyecto te fue útil, considera darle una estrella en GitHub

📝 **Nota**: Este es un proyecto educativo para aprender conceptos de programación de red en Java.
