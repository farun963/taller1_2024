¿Qué es @ApplicationScoped en Quarkus?

@ApplicationScoped es una anotación en Quarkus que define el alcance (scope) de un bean o servicio en el contexto de la aplicación. Un bean marcado con @ApplicationScoped se crea una vez y se comparte a lo largo de toda la aplicación mientras esta esté en ejecución. Es ideal para servicios que necesitan ser instanciados una sola vez y reutilizados en varias partes de la aplicación.

Ejemplo:
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyService {
    public String greet() {
        return "Hello from ApplicationScoped service!";
    }
}

En este ejemplo, MyService es un servicio que será creado una sola vez y estará disponible para toda la aplicación.



¿Cómo funciona la inyección de dependencias en Quarkus?

En Quarkus, la inyección de dependencias (DI) se maneja principalmente a través de CDI (Contexts and Dependency Injection). Esto permite que las dependencias (servicios, repositorios, etc.) sean inyectadas en clases sin necesidad de crearlas manualmente. Las dependencias se inyectan usando la anotación @Inject.

Ejemplo:

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/greet")
public class GreetingResource {

    @Inject
    MyService myService;

    @GET
    public String greet() {
        return myService.greet();
    }
}

En este ejemplo, MyService se inyecta en GreetingResource, y Quarkus se encarga de gestionar su ciclo de vida.

¿Cuál es la diferencia entre @ApplicationScoped, @RequestScoped, y @Singleton en Quarkus?

@ApplicationScoped: Un bean con este scope es único y compartido en toda la aplicación. Se instancia una vez durante el ciclo de vida de la aplicación.
@RequestScoped: Un bean con este scope es creado para cada solicitud HTTP. Es ideal para datos que sólo necesitan existir durante una única petición.
@Singleton: Similar a @ApplicationScoped, pero es manejado por el contenedor Java (por ejemplo, CDI) y no soporta los mismos contextos que @ApplicationScoped. Suele usarse para componentes que no necesitan integración con el ciclo de vida de CDI.
¿Cómo se define un servicio en Quarkus utilizando @ApplicationScoped?

Definir un servicio en Quarkus con @ApplicationScoped es simple. Solo es necesario anotar la clase con @ApplicationScoped.

Ejemplo:

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculationService {
    public int add(int a, int b) {
        return a + b;
    }
}


Este servicio se puede inyectar en cualquier parte de la aplicación y mantener su estado durante toda la ejecución.

¿Por qué es importante manejar correctamente los alcances (scopes) en Quarkus al crear servicios?

El manejo correcto de los scopes es crucial para evitar problemas como la creación innecesaria de instancias (lo que puede afectar el rendimiento) o el uso compartido indebido de estados (que podría generar errores en la aplicación). Al elegir el scope adecuado, se garantiza que los servicios funcionen de manera eficiente y segura.

Sección 2: Creación de un ApiResponse Genérico
¿Qué es un ApiResponse genérico y cuál es su propósito en un servicio REST?

Un ApiResponse genérico es una clase que encapsula la estructura estándar de una respuesta HTTP en un servicio REST. Su propósito es proporcionar una forma consistente de manejar y retornar respuestas, facilitando el manejo de datos, mensajes de éxito o error, y códigos de estado.

Ejemplo de ApiResponse genérico:

public class ApiResponse<T> {
    private T data;
    private String message;
    private int status;

    public ApiResponse(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    // Getters and setters
}

¿Cómo se implementa una clase ApiResponse genérica en Quarkus?

La implementación es directa, creando una clase parametrizada que permita retornar diferentes tipos de datos.

Ejemplo:
public class ApiResponse<T> {
    private T data;
    private String message;
    private int status;

    public ApiResponse(T data, String message, int status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    // Getters y setters
}

¿Cómo se modifica un recurso REST en Quarkus para que utilice un ApiResponse genérico?

Se ajusta el método del recurso REST para que retorne una instancia de ApiResponse en lugar del tipo de dato simple.

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/calculate")
public class CalculationResource {

    @Inject
    CalculationService calculationService;

    @GET
    @Path("/add")
    public Response add() {
        int result = calculationService.add(2, 3);
        ApiResponse<Integer> response = new ApiResponse<>(result, "Operation successful", 200);
        return Response.ok(response).build();
    }
}

¿Qué beneficios ofrece el uso de un ApiResponse genérico en términos de mantenimiento y consistencia de código?

El uso de ApiResponse genérico permite una estructura uniforme para todas las respuestas REST, simplificando el manejo de errores, mensajes y datos. Esto mejora la mantenibilidad del código al centralizar el formato de las respuestas y facilita la modificación del comportamiento de las respuestas en toda la aplicación.

¿Cómo manejarías diferentes tipos de respuestas (éxito, error, etc.) utilizando la clase ApiResponse?

Se pueden crear métodos estáticos o constructores para manejar los diferentes casos.

Ejemplo:

public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(data, "Operation successful", 200);
}

public static <T> ApiResponse<T> error(String message, int status) {
    return new ApiResponse<>(null, message, status);
}

public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(data, "Operation successful", 200);
}

public static <T> ApiResponse<T> error(String message, int status) {
    return new ApiResponse<>(null, message, status);
}


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        ApiResponse<String> response = ApiResponse.error("An error occurred: " + exception.getMessage(), 500);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
    }
}

Este ejemplo captura cualquier excepción no manejada y retorna un ApiResponse con un mensaje de error y un código 500.