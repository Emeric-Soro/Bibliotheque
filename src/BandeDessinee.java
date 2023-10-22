public class BandeDessinee extends Livre {
    String Genre;
    public BandeDessinee(int id, String titre, String auteur, String edition, String categorie, int Qte, String genre) {
        super(id, titre, auteur, edition, categorie, Qte);
        this.Genre = genre;
    }
    @Override
    public void AfficherDetails(){
        System.out.println("Genre : "+Genre);
        super.AfficherDetails();
    }

}
