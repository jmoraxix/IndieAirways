
import indieairways.client.API.ApiResource;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jmora
 */
public class ClientRestAPI {

    static class AirplanesResourceClient extends ApiResource {

        public AirplanesResourceClient() {
            super("airplanes");
        }

        @Override
        public Response putJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request().put(null, Response.class);
        }

        @Override
        public Response postJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request().post(null, Response.class);
        }

        @Override
        public Response deleteJson(String code) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (code != null) {
                resource = resource.queryParam("c", code);
            }
            return resource.request(code).delete(Response.class);
        }

        @Override
        public <T> T getJson(Class<T> responseType, String airplaneCode) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (airplaneCode != null) {
                resource = resource.queryParam("a", airplaneCode);
            }
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }
    }

    static class AirportsResourceClient extends ApiResource {

        public AirportsResourceClient() {
            super("airports");
        }

        @Override
        public Response putJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        }

        @Override
        public Response postJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        }

        @Override
        public Response deleteJson(String code) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (code != null) {
                resource = resource.queryParam("c", code);
            }
            return resource.request(code).delete(Response.class);
        }

        @Override
        public <T> T getJson(Class<T> responseType, String code) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (code != null) {
                resource = resource.queryParam("a", code);
            }
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }
    }

    static class FlightsResourceClient extends ApiResource {

        public FlightsResourceClient() {
            super("flights");
        }

        public Response putJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        }

        public Response postJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        }

        public Response deleteJson(String code) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (code != null) {
                resource = resource.queryParam("c", code);
            }
            return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).delete(Response.class);
        }

        public <T> T getJson(Class<T> responseType, String f) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (f != null) {
                resource = resource.queryParam("f", f);
            }
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }
    }

    static class LoginResourceClient extends ApiResource {

        public LoginResourceClient() {
            super("login");
        }

        public Response putJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request().put(null, Response.class);
        }

        public Response postJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        }

        public Response deleteJson(String code) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (code != null) {
                resource = resource.queryParam("c", code);
            }
            return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).delete(Response.class);
        }

        public <T> T getJson(Class<T> responseType, String code) throws ClientErrorException {
            WebTarget resource = webTarget;
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }
    }

    static class ReservationsResourceClient extends ApiResource {

        public ReservationsResourceClient() {
            super("reservations");
        }

        public Response putJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        }

        public Response postJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        }

        public Response deleteJson(String code) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (code != null) {
                resource = resource.queryParam("c", code);
            }
            return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).delete(Response.class);
        }

        public <T> T getJson(Class<T> responseType, String r) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (r != null) {
                resource = resource.queryParam("r", r);
            }
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }
    }

    static class SectorsResourceClient extends ApiResource {

        public SectorsResourceClient() {
            super("sectors");
        }

        public Response putJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request().put(null, Response.class);
        }

        public Response postJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request().post(null, Response.class);
        }

        public Response deleteJson(String code) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (code != null) {
                resource = resource.queryParam("c", code);
            }
            return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).delete(Response.class);
        }

        public <T> T getJson(Class<T> responseType, String code) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (code != null) {
                resource = resource.queryParam("c", code);
            }
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }
    }

    static class UsersResourceClient extends ApiResource {

        public UsersResourceClient() {
            super("users");
        }

        public Response putJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        }

        public Response postJson(Object requestEntity) throws ClientErrorException {
            return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
        }

        public Response deleteJson(String code) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (code != null) {
                resource = resource.queryParam("c", code);
            }
            return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).delete(Response.class);
        }

        public <T> T getJson(Class<T> responseType, String u) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (u != null) {
                resource = resource.queryParam("u", u);
            }
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }
    }

}
