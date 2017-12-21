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
package indieairways.client.API;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author jmora
 */
public abstract class ApiResource {

    protected WebTarget webTarget;
    protected nClient client;
    protected static final String BASE_URI = "http://localhost:8080/IndieAirways/webresources";

    public ApiResource(String path) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public abstract Response putJson(Object requestEntity) throws ClientErrorException;

    public abstract Response postJson(Object requestEntity) throws ClientErrorException;

    public abstract Response deleteJson() throws ClientErrorException;

    public abstract <T> T getJson(Class<T> responseType, String param) throws ClientErrorException;

    public void close() {
        client.close();
    }

}
