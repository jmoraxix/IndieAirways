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

import indieairways.model.User;
import javax.ws.rs.client.Client;

/**
 *
 * @author jmora
 */
public class ClientAPI {

    public User login(String user, String password) {
        try {

            Client client = Client.create();

            WebResource webResource = client
                    .resource("http://localhost:8080/RESTfulExample/rest/json/metallica/get");

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("Output from Server .... \n");
            System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
