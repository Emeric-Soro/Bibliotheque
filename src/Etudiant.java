public class Etudiant extends Utilisateur {
    String classe;

    public Etudiant(String nom,String prenom, String adresse, String numeroTelephone, String classe) {
        super(nom,prenom, adresse, numeroTelephone);
        this.classe = classe;
    }

    @Override
    public void AfficherDetails() {
        System.out.println("NOM : "+getNom());
        System.out.println("Adresse : "+getAdresse());
        System.out.println("Numero de telephone : "+getNumeroTelephone());
        System.out.println("Departement : "+classe);

    }
}
