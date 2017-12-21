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

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service base for other APIs
 *
 * @author jmora
 */
public abstract class ServerAPIResource {

    @Context
    protected UriInfo context;

    public ServerAPIResource() {
    }

    public abstract Response getJson(String param);

    public abstract Response putJson(String param);

    public abstract Response postJson(String param);

    public abstract Response deleteJson(String param);
}
