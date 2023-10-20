public class Livre {
    private int Id;
    private String Titre;
    private String Auteur;
    private String Edition;
    private String Categorie;
    private int QuantiteDisponible;
    public Livre(String titre, String auteur){
        this.Titre = titre;
        this.Auteur = auteur;
    }
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

    public void AfficherDetails(){
        System.out.println("ID : "+getId());
        System.out.println("Titre : "+getTitre());
        System.out.println("Auteur : "+getAuteur());
        System.out.println("Edition : "+getEdition());
        System.out.println("QuantiteDisponible : "+getQuantiteDisponible());
        System.out.println();
    }
}
