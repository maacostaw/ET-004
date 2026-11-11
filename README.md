# Task Manager

API REST en Spring Boot para gestionar tareas (crear, listar, consultar, actualizar, cambiar estado y eliminar).

Al iniciar, se cargan 3 tareas de prueba.

## Ejecutar

```bash
mvn spring-boot:run
```

La API queda disponible en `http://localhost:8080/api/task`.

## Colección de Postman

Importar el archivo de la carpeta `postman/` y ejecutar en este orden:

1. **Crear** - `POST /api/task`
2. **Traer todas** - `GET /api/task`
3. **Traer una** - `GET /api/task/4`
4. **Actualizar** - `PUT /api/task/4`
5. **Actualizar status** - `PATCH /api/task/4/status`
6. **Eliminar** - `DELETE /api/task/4`
7. **Verificar eliminación** - `GET /api/task/4` (debe devolver 404)
 