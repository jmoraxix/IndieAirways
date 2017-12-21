/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author ulacit
 */
public enum URLDefinition {

    LOGIN("login"), USERS("users"), SECTORS("sectors"), FLIGTS("flights"), AIRPORTS("airports"), AIRPLANES("airplanes"), RESERVATIONS("reservations");

    private String url;
    private String baseURL = "http://localhost:8080/IndieAirways/webresources/";

    private URLDefinition(final String url) {
        this.url = url;
    }

    public String getUrl() {
        return baseURL + url;
    }

}
