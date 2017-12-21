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
package indieairways.API;

import com.google.gson.Gson;
import indieairways.model.User;
import indieairways.util.Util;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author jdmoralo
 */
@Path("login")
public class LoginResource extends ServerAPIResource {

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }

    /**
     * Retrieves representation of an instance of API.LoginResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Override
    public Response getJson(String content) {
        return Response.status(405).build();
    }

    /**
     * PUT method for updating or creating an instance of LoginResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Override
    public Response putJson(String content) {
        return Response.status(405).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response postJson(String content) {

        User user = new Gson().fromJson(content, User.class);

        for (User u : Util.USER_LIST) {
            if (u.getUsername().equals(user.getUsername())) {
                if (u.getPassword().equals(user.getPassword())) {
                    return Response.ok(new Gson().toJson(u)).build();
                }
                return Response.status(401).build();
            }
        }

        return Response.status(404).build();
    }

    /**
     * DELETE method for removing an instance of LoginResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Override
    public Response deleteJson(String content) {
        return Response.status(405).build();
    }
}
