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
import indieairways.model.Airport;
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
 * @author emilioevans
 */
@Path("airports")
public class AirportsResource extends ServerAPIResource {

    /**
     * Creates a new instance of AirportsResource
     */
    public AirportsResource() {
    }

    /**
     * Retrieves representation of an instance of
     * indieairways.API.ReservationsResource
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response postJson(String content) {
        Airport airport = new Gson().fromJson(content, Airport.class);
        for (Airport a : Util.AIRPORT_LIST) {
            if (a.getAirportCode().equals(airport.getAirportCode())) {
                return Response.status(409).build();
            }
        }
        Util.AIRPORT_LIST.add(airport);
        return Response.status(201).build();
    }

    /**
     * Retrieves representation of an instance of
     * indieairways.API.AirportsResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getJson(@QueryParam("a") String airportCode) {
        for (Airport a : Util.AIRPORT_LIST) {
            if (a.getAirportCode().equals(airportCode)) {
                return Response.ok(new Gson().toJson(a)).build();
            }
        }
        return Response.status(404).build();
    }

    /**
     * PUT method for updating or creating an instance of AirportsResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response putJson(String content) {
        Airport airport = new Gson().fromJson(content, Airport.class);
        for (Airport a : Util.AIRPORT_LIST) {
            if (a.getAirportCode().equals(airport.getAirportCode())) {
                return Response.ok().build();
            }
        }
        return Response.status(404).build();
    }

    /**
     * DELETE method for updating or creating an instance of
     * ReservationsResource
     *
     * @param content representation for the resource
     */
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response deleteJson(String content) {

        Airport airport = new Gson().fromJson(content, Airport.class);

        for (Airport a : Util.AIRPORT_LIST) {
            if (a.getAirportCode().equals(a.getAirportCode())) {
                Util.RESERVATION_LIST.remove(a);
                return Response.ok().build();
            }
        }
        return Response.status(404).build();
    }
}
