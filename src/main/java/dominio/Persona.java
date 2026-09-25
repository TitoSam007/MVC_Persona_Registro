package dominio;

public class Persona {

    private int idPersona;
    private String nom;
    private String cognom;
    private String email;
    private int edat;

    public Persona(String nom, String cognom, String email, int edat){
        this.nom = nom;
        this.cognom = cognom;
        this.email = email;
        this.edat = edat;
    }

    public Persona(int idPersona){
        this.idPersona = idPersona;
    }

    public Persona(){}

    public void setIdPersona(int idPersona){
        this.idPersona = idPersona;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setCognom(String cognom){
        this.cognom = cognom;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setEdat(int edat){
        this.edat = edat;
    }

    public int getIdPersona() {
        return idPersona;
    }
    public String getNom() {
        return nom;
    }
    public String getCognom() {
        return cognom;
    }
    public String getEmail() {
        return email;
    }
    public int getEdat() {
        return edat;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
