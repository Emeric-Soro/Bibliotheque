public class Poesie extends Livre {
    String Genre;

    public Poesie(int id, String titre, String auteur, String edition, String categorie, int Qte, String genre) {
        super(id, titre, auteur, edition,categorie, Qte);
        Genre = genre;
    }
    @Override
    public void AfficherDetails(){
        System.out.println("Genre : "+Genre);
        super.AfficherDetails();
    }
}
