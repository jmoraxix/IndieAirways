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
package indieairways.model;

/**
 *
 * @author emilioevans
 */
public class User {

    private String username, password, email, name, lastname, birthday;

    public User() {
    }

    public User(String user, String password, String email, String name, String lastname, String birthday) {
        this.username = user;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", email=" + email + ", name=" + name + ", lastname=" + lastname + ", birthday=" + birthday + '}';
    }
}
