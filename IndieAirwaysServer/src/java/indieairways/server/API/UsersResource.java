/*
 * Programacion Concurrente Cliente Servidor
 * 
 * Emilio Evans Rodriguez
 * Jose David Mora Loria
 * Carlos Oreamuno Alfaro
 * 
 * Tercer cuatrimestre, 2017
 * Ulacit
 */
package indieairways.server.API;

import com.google.gson.Gson;
import indieairways.model.User;
import indieairways.util.Util;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author jmora
 */
@Path("users")
public class UsersResource extends ServerAPIResource {

    /**
     * Creates a new instance of UserResource
     */
    public UsersResource() {
    }

    /**
     * Retrieves representation of an instance of API.UsersResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getJson(@QueryParam("u") String username) {

        for (User i : Util.USER_LIST) {
            if (i.getEmail().equals(username)) {
                return Response.ok(new Gson().toJson(i)).build();
            }
        }

        return Response.status(401).build();
    }

    /**
     * PUT method for updating users
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response putJson(String content) {

        User usuario = new Gson().fromJson(content, User.class);

        for (User u : Util.USER_LIST) {
            if (u.getUsername().equals(usuario.getUsername())) {
                u = usuario;
                return Response.ok().build();
            }
        }

        return Response.status(404).build();
    }

    /**
     * POST method for creating users
     *
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response postJson(String content) {

        User usuario = new Gson().fromJson(content, User.class);

        if (usuario.getUsername().isEmpty()) {
            return Response.status(400).build();
        }

        if (usuario.getEmail().isEmpty()) {
            return Response.status(400).build();
        }

        if (usuario.getPassword().isEmpty()) {
            return Response.status(400).build();
        }

        if (usuario.getName().isEmpty()) {
            return Response.status(400).build();
        }

        Util.USER_LIST.add(usuario);

        return Response.ok().build();
    }

    /**
     * DELETE method for deleting users
     *
     */
    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Override
    public Response deleteJson(@QueryParam("u") String username) {

        // @TODO Add delete method to UsersResource
        return Response.ok().build();
    }
}
