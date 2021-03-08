package eci.ieti.lab6.entity;

public class User {
    private String id;
    private String contraseña;
    private String email;
    public User(){

    }
    public User(String id, String contraseña,String email){
        this.id=id;
        this.email=email;
        this.contraseña=contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
