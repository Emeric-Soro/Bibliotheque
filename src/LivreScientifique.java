public class LivreScientifique extends Livre{
    private String Domaine;
    private String Niveau;
    private String Genre;

    public LivreScientifique(int id, String titre, String auteur, String edition,String categorie, int Qte, String domaine, String niveau,String genre) {
        super(id, titre, auteur, edition,categorie, Qte);
        this.Domaine = domaine;
        this.Niveau = niveau;
        this.Genre = genre;
    }

    public String getDomaine() {
        return Domaine;
    }

    public void setDomaine(String domaine) {
        Domaine = domaine;
    }

    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String niveau) {
        Niveau = niveau;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    @Override
    public void AfficherDetails(){
        System.out.println("Genre : "+getGenre());
        System.out.println("Domaine : "+getDomaine());
        System.out.println("Niveau : "+getNiveau());
        super.AfficherDetails();
    }
}
