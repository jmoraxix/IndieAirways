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

/**
 *
 * @author jmora
 */
public class ClientAPI {
//
//    public boolean Login(final String user, final String password) {
//        InputStreamReader resource = null;
//        try {
//            String url = URLDefinition.LOGIN.getUrl();
//            resource = new InputStreamReader(new URL(url).openStream());
//
//            // Generating MD5 password	
//            MessageDigest md = null;
//            try {
//                md = MessageDigest.getInstance("MD5");
//                md.update(password.getBytes());
//            } catch (NoSuchAlgorithmException ex) {
//                Logger.getLogger(ClientAPI.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            User message = new Gson().fromJson(resource, User.class);
//
//            System.out.println(message.getName());
//
//        } catch (MalformedURLException ex) {
//            return false;
//        } catch (IOException ex) {
//            return false;
//        } finally {
//            try {
//                resource.close();
//            } catch (IOException ex) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean createUser(final String username, final String passwd, final String email, final String name, final String birthday) {
//
//        User user = new User(username, passwd, email, name, birthday);
//        String url = URLDefinition.USERS.getUrl();
//        try {
//            URL targetUrl = new URL(url);
//
//            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
//            httpConnection.setDoOutput(true);
//            httpConnection.setRequestMethod("POST");
//            httpConnection.setRequestProperty("Content-Type", "application/json");
//
//            String input = new Gson().toJson(user);
//
//            OutputStream outputStream = httpConnection.getOutputStream();
//            outputStream.write(input.getBytes());
//            outputStream.flush();
//            if (httpConnection.getResponseCode() != 200 && httpConnection.getResponseCode() != 201) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + httpConnection.getResponseCode());
//            }
//            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));
//            String output;
//
//            while ((output = responseBuffer.readLine()) != null) {
//                System.out.println(output);
//            }
//
//            httpConnection.disconnect();
//
//        } catch (MalformedURLException e) {
//
//            return false;
//
//        } catch (IOException e) {
//
//            return false;
//        }
//
//        return true;
//    }

}
