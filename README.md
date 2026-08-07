# SpectraVision

Backend de gestión para una óptica/clínica visual, desarrollado como proyecto académico de ingeniería de software (Universidad Israel). Digitaliza el flujo completo del negocio: clientes, historias clínicas, exámenes visuales, certificados, citas, entregas de lentes y seguimientos postventa, además de autenticación y administración de usuarios/roles.

## Stack técnico

- Java 17
- Spring Boot (Web, Data JPA, Mail, Security Crypto)
- PostgreSQL
- Maven
- MapStruct + Lombok
- Twilio SDK (notificaciones por WhatsApp)
- Apache PDFBox (generación de certificados en PDF)

## Arquitectura

El proyecto sigue **Clean Architecture / arquitectura hexagonal**, con dependencia estrictamente unidireccional entre capas:

```
presentacion  →  aplicacion  →  dominio
infraestructura  →  dominio        (implementa los puertos que dominio define)
```

```
src/main/java/com/uisrael/spectraVisionPisip
├── dominio/
│   ├── entidades/        POJOs de negocio puros (sin JPA, sin Lombok)
│   ├── repositorio/      Interfaces de repositorio orientadas al negocio (puertos de salida)
│   ├── servicios/        Puertos de servicios externos (ej. INotificacionService)
│   └── excepciones/      Excepciones de dominio tipadas
│
├── aplicacion/
│   └── casosuso/
│       ├── entrada/       Interfaces de caso de uso (puertos de entrada)
│       └── impl/          Implementaciones — única capa con reglas de negocio
│
├── infraestructura/
│   ├── configuraciones/   Clase @Configuration que cablea manualmente todos los beans
│   ├── repositorio/       Interfaces Spring Data JPA
│   ├── notificaciones/    Adaptador de Twilio (WhatsApp)
│   └── persistencia/
│       ├── jpa/            Entidades @Entity
│       ├── adaptadores/    Implementan los puertos de repositorio del dominio
│       └── mapeadores/     MapStruct Entity ↔ Dominio
│
└── presentacion/
    ├── controllers/    Endpoints REST
    ├── dto/             request / response
    └── mapeadores/      MapStruct Dto ↔ Dominio
```

El dominio nunca ve un DTO ni una entidad JPA. Cada capa se conecta solo a través de interfaces, y el cableado de beans es manual (sin `@Service`/`@Repository` esparcidos) en `infraestructura/configuraciones`.

## Módulos

| Módulo | Relación | Notas |
|---|---|---|
| Cliente | — | cédula única, borrado lógico en cascada (historia, citas, entregas) |
| HistoriaClinica | 1:1 con Cliente | un cliente solo puede tener una historia clínica |
| ExamenVisual | 1:N con HistoriaClinica | requiere historia clínica activa |
| Certificado | 1:1 con ExamenVisual | incluye generación de PDF |
| Cita | N:1 con Cliente | valida disponibilidad de horario; dispara confirmación por WhatsApp |
| Entrega | N:1 con Cliente | dispara aviso de "lentes listos" por WhatsApp |
| Seguimiento | N:1 con Entrega | seguimiento postventa |
| Usuario | — | login, contraseña hasheada (BCrypt), recuperación por correo |
| Rol | — | catálogo de roles |
| UsuarioRol | N:N (Usuario ↔ Rol) | tabla de asociación |

Reglas de negocio destacadas: la cédula de Cliente y el nombre de Usuario/Rol deben ser únicos; los campos de fecha "de sistema" (`fechaRegistro`, `fechaApertura`, `fechaGeneracion`, etc.) y los estados iniciales (`estado`, `"Pendiente"`) los fija el backend automáticamente — no son responsabilidad del cliente HTTP.

## Endpoints principales

Todos bajo el prefijo `/api/spectra/`. Cada entidad expone CRUD estándar (`POST`, `GET`, `GET /{id}`, `PUT /{id}`, `DELETE /{id}`) más consultas propias del negocio:

- `cliente` — `/cedula/{cedula}`, `/nombre/{nombres}`
- `hClinica` — `/cliente/{idCliente}`
- `examenVisual` — `/historia/{idHistoriaClinica}`
- `certificado` — `/examen/{idExamen}`, `/{id}/pdf` (descarga el certificado en PDF)
- `cita` — `/cliente/{idCliente}`, `/fecha/{fecha}`, `PUT /{id}/cancelar`
- `entrega` — `/cliente/{idCliente}`
- `seguimiento` — `/entrega/{idEntrega}`, `/alertas` (seguimientos próximos a vencer)
- `usuario`, `rol`, `usuarioRol` — CRUD estándar
- `auth` — `POST /login`, `POST /olvide-contrasena`, `POST /restablecer-contrasena`
- `whatsapp/webhook` — recibe las respuestas de confirmación/cancelación de citas desde Twilio

Los errores se devuelven de forma consistente como `{"message": "..."}`, con el status HTTP correspondiente (400 validación, 404 no encontrado, 409 conflicto/regla de negocio, 401 credenciales inválidas, 500 inesperado).

## Configuración

`src/main/resources/application.properties` necesita:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/spectraVision
spring.datasource.username=postgres
spring.datasource.password=<tu password local de Postgres>

twilio.account-sid=<account sid de Twilio>
twilio.auth-token=${TWILIO_AUTH_TOKEN}
twilio.whatsapp-from=whatsapp:+14155238886

spring.mail.username=${MAIL_USERNAME:}
spring.mail.password=${MAIL_PASSWORD:}
```

Variables de entorno requeridas (no se guardan en texto plano en el repo):
- `TWILIO_AUTH_TOKEN`
- `MAIL_USERNAME` / `MAIL_PASSWORD` (para el envío de recuperación de contraseña)

## Cómo correrlo

Requiere JDK 17+ y PostgreSQL corriendo localmente con una base de datos `spectraVision` creada.

```bash
./mvnw spring-boot:run
```

El servidor levanta en `http://localhost:8080` por defecto. `spring.jpa.hibernate.ddl-auto=update` crea/actualiza el esquema automáticamente.
