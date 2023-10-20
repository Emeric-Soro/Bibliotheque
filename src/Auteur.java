public class Auteur {
    private String Nom;
    private String DateNaissance;
    private String Biographie;

    public Auteur(String nom, String dateNaissance, String biographie) {
        Nom = nom;
        DateNaissance = dateNaissance;
        Biographie = biographie;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        DateNaissance = dateNaissance;
    }

    public String getBiographie() {
        return Biographie;
    }

    public void setBiographie(String biographie) {
        Biographie = biographie;
    }
}
