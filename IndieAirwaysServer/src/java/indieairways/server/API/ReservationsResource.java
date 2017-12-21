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
import indieairways.model.Reservation;
import indieairways.util.Util;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author emilioevans
 */
@Path("reservations")
public class ReservationsResource extends ServerAPIResource {

    /**
     * Creates a new instance of ReservationsResource
     */
    public ReservationsResource() {
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

        Reservation reservation = new Gson().fromJson(content, Reservation.class);

        for (Reservation r : Util.RESERVATION_LIST) {
            if (r.getReservationCode().equals(reservation.getReservationCode())) {
                return Response.status(409).build();
            }
        }
        Util.RESERVATION_LIST.add(reservation);
        return Response.status(201).build();
    }

    /**
     * Retrieves representation of an instance of
     * indieairways.API.ReservationsResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Override
    public Response getJson(@QueryParam("r") String reservationCode) {

        for (Reservation r : Util.RESERVATION_LIST) {
            if (r.getReservationCode().equals(reservationCode)) {
                return Response.ok(new Gson().toJson(r)).build();
            }
        }

        return Response.status(404).build();
    }

    /**
     * PUT method for updating or creating an instance of ReservationsResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response putJson(String content) {

        Reservation reservation = new Gson().fromJson(content, Reservation.class);

        for (Reservation r : Util.RESERVATION_LIST) {
            if (r.getReservationCode().equals(reservation.getReservationCode())) {
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

        Reservation reservation = new Gson().fromJson(content, Reservation.class);

        for (Reservation r : Util.RESERVATION_LIST) {
            if (r.getReservationCode().equals(reservation.getReservationCode())) {
                Util.RESERVATION_LIST.remove(r);
                return Response.ok().build();
            }
        }
        return Response.status(404).build();
    }
}
