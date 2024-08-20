package py.edu.ucom.Api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1")
public class ApiResponseResource {

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser() {
        // Simulación de obtener un usuario
        User user = new User("Juan", "juan@example.com");

        ApiResponse<User> response = new ApiResponse<>("Operación exitosa", 200, user);
        return Response.ok(response).build();
    }

    @GET
    @Path("/error")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getErrorExample() {
        ApiResponse<String> response = new ApiResponse<>("Recurso no encontrado", 404, null);
        return Response.status(Response.Status.NOT_FOUND).entity(response).build();
    }
}
