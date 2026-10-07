package model;

public class Registre {

    private int idRegistre;
    private int  idPersona;
    private String user;
    private String password;

    public Registre(int idRegistre, int idPersona, String user, String password) {
        this.idRegistre = idRegistre;
        this.idPersona = idPersona;
        this.user = user;
        this.password = password;
    }

    public Registre(int idPersona, String user, String password) {
        this.idPersona = idPersona;
        this.user = user;
        this.password = password;
    }

    public int getIdRegistre() {
        return idRegistre;
    }

    public void setIdRegistre(int idRegistre) {
        this.idRegistre = idRegistre;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Id Registre: " + idRegistre +
                "\n"+ " IdPersona: " + idPersona +
                "\n"+ "User: " + user;
    }
}
