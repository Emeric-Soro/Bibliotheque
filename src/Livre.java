import java.util.ArrayList;

public class Livre implements MethodeCommune{
    private int Id;
    private String Titre;
    private String Auteur;
    private String Edition;
    private String Categorie; //la categorie c'est LivreScientifique ou Roman ou Poesie...
    private int QuantiteDisponible;
    public Livre(int id,String titre,String auteur,String edition,String categorie, int Qte){
        this.Id = id;
        this.Titre = titre;
        this.Auteur = auteur;
        this.Edition = edition;
        this.QuantiteDisponible = Qte;
        this.Categorie = categorie;
    }
    public int getId() {
        return Id;
    }

    public String getTitre() {
        return Titre;
    }

    public String getAuteur() {
        return Auteur;
    }

    public String getEdition() {
        return Edition;
    }

    public int getQuantiteDisponible() {
        return QuantiteDisponible;
    }

    public void setQuantiteDisponible(int quantiteDisponible) {
        QuantiteDisponible = quantiteDisponible;
    }

    public String getCategorie() {
        return Categorie;
    }

    @Override
    public void AfficherDetails(){ //methode pour affischer les details des livres
        System.out.println("ID : "+getId());
        System.out.println("Titre : "+getTitre());
        System.out.println("Auteur : "+getAuteur());
        System.out.println("Edition : "+getEdition());
        System.out.println("QuantiteDisponible : "+getQuantiteDisponible());
        System.out.println();
    }
}
