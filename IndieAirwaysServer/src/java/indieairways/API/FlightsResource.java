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
import indieairways.model.Flight;
import indieairways.util.Util;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
 * @author emilioevans
 */
@Path("flights")
public class FlightsResource extends ServerAPIResource {
    
    /**
     * Creates a new instance of FlightsResource
     */
    public FlightsResource() {
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
        Flight flight = new Gson().fromJson(content, Flight.class);
        for (Flight f:Util.FLIGHT_LIST){
            if(f.getFlightCode().equals(flight.getFlightCode())){
                return Response.status(409).build();
            }
        }
        Util.FLIGHT_LIST.add(flight);
        return Response.status(201).build();
    }
    /**
     * Retrieves representation of an instance of indieairways.API.FlightsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getJson(@QueryParam("f") String flightCode) {
        for(Flight f:Util.FLIGHT_LIST){
            if(f.getFlightCode().equals(flightCode)){
                return Response.ok(new Gson().toJson(f)).build();
            }
        }
        return Response.status(404).build();
    }

    /**
     * PUT method for updating or creating an instance of FlightsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response putJson(String content) {
        Flight flight = new Gson().fromJson(content,Flight.class);
        for(Flight f: Util.FLIGHT_LIST){
            if(f.getFlightCode().equals(flight.getFlightCode())){
                return Response.ok().build();
            }
        }
        return Response.status(404).build();
    }
    /**
     * DELETE method for updating or creating an instance of ReservationsResource
     *
     * @param content representation for the resource
     */
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response deleteJson(String content) {   
        
        Flight flight = new Gson().fromJson(content, Flight.class);

        for (Flight f : Util.FLIGHT_LIST) {
            if (f.getFlightCode().equals(flight.getFlightCode())) {
                Util.RESERVATION_LIST.remove(f);
                return Response.ok().build();
            }
        }
        return Response.status(404).build();
    }
    
}
