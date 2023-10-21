public class Professeur extends Utilisateur{
    String departement;

    public Professeur(String nom, String adresse, String numeroTelephone, String departement) {
        super(nom, adresse, numeroTelephone);
        this.departement = departement;
    }


    @Override
    public void AfficherDetails() {
        System.out.println("NOM : "+getNom());
        System.out.println("Adresse : "+getAdresse());
        System.out.println("Numero de telephone : "+getNumeroTelephone());
        System.out.println("Departement : "+departement);
    }
}
