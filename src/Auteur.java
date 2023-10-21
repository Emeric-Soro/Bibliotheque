public class Auteur implements MethodeCommune{
    private final String Nom;
    private final String DateNaissance;
    private final String Biographie;

    public Auteur(String nom, String dateNaissance, String biographie) {
        Nom = nom;
        DateNaissance = dateNaissance;
        Biographie = biographie;
    }

    public String getNom() {
        return Nom;
    }
    public String getDateNaissance() {
        return DateNaissance;
    }
    public String getBiographie() {
        return Biographie;
    }
    @Override
    public void AfficherDetails(){
        System.out.println("NOM : "+getNom());
        System.out.println("Date de naissance : "+getDateNaissance());
        System.out.println("Bio : "+getBiographie());
    }
}
