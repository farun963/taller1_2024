package py.edu.ucom.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/recursos")
public class RecursosBasicos {

    // Método para retornar la suma de 5 + 5
    @GET
    @Path("/suma")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSuma() {
        int resultado = 5 + 5;
        return "La suma de 5 + 5 es: " + resultado;
    }

    // Método para retornar la resta de 100 - 5
    @GET
    @Path("/resta")
    @Produces(MediaType.TEXT_PLAIN)
    public String getResta() {
        int resultado = 100 - 5;
        return "La resta de 100 - 5 es: " + resultado;
    }
}
