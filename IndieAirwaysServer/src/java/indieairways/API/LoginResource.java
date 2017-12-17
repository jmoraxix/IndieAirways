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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author jdmoralo
 */
@Path("login")
public class LoginResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }

    /**
     * Retrieves representation of an instance of API.LoginResource
     * @return an instance of java.lang.String
     */
    @GET
    public Response getJson() {
        return Response.status(405).build();
    }

    /**
     * PUT method for updating or creating an instance of LoginResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(String content) {
        return Response.status(405).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(@QueryParam("e") String user, @QueryParam("p") String passwd) {

        // Generating MD5 password
        MessageDigest mdPasswd = null;
        try {
            mdPasswd = MessageDigest.getInstance("MD5");
            mdPasswd.update(passwd.getBytes());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserResources.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (User u : Util.USER_LIST) {
            if (u.getUsername().equals(user)) {
                if (u.getPassword().equals(mdPasswd.digest())) {
                    return Response.ok(new Gson().toJson(u)).build();
                }
                return Response.status(401).build();
            }
        }

        return Response.status(404).build();
    }
}
