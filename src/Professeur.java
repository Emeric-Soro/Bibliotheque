public class Professeur extends Utilisateur{
    String departement;

    public Professeur(String nom, String adresse, String numeroTelephone, String departement) {
        super(nom, adresse, numeroTelephone);
        this.departement = departement;
    }


    @Override
    public void AfficherDetails() {

    }
}
