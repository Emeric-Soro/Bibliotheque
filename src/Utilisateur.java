import java.util.ArrayList;

public abstract class Utilisateur implements MethodeCommune{
    private ArrayList<Livre> LivresEmprunter;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private String NumeroTelephone;
    public Utilisateur(String nom,String prenom, String adresse, String numeroTelephone){
        this.Nom = nom;
        this.Prenom = prenom;
        this.Adresse = adresse;
        this.NumeroTelephone = numeroTelephone;
        this.LivresEmprunter = new ArrayList<>();
    }
    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getNumeroTelephone() {
        return NumeroTelephone;
    }

    public void EmprunterLivre(Livre l){
        LivresEmprunter.add(l);
    }
    public void RendreLivre(Livre l){
        LivresEmprunter.remove(l);
    }

    public ArrayList<Livre> getLivresEmprunter() {

        return LivresEmprunter;
    }

    @Override
    public abstract void AfficherDetails();
}
