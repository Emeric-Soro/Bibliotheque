import java.util.ArrayList;

public abstract class Utilisateur implements MethodeCommune{
    private ArrayList<Livre> LivresEmprunter;
    private String Nom;
    private String Adresse;
    private String NumeroTelephone;
    public Utilisateur(String nom, String adresse, String numeroTelephone){
        this.Nom = nom;
        this.Adresse = adresse;
        this.NumeroTelephone = numeroTelephone;
        this.LivresEmprunter = new ArrayList<>();
    }
    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getNumeroTelephone() {
        return NumeroTelephone;
    }
    public void setNumeroTelephone(String numeroTelephone) {

        NumeroTelephone = numeroTelephone;
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
