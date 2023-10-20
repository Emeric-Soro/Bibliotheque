import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
public class Bibliotheque {
    ArrayList<Livre> inventaire = new ArrayList<>();
    ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
    public void AjouterLivre(Livre L){
        inventaire.add(L);
    }
    public void AjouterUtilisateur(Utilisateur U){
        utilisateurs.add(U);
    }
    public void VoirLivre(){
        System.out.println("~~~~~~~~les livres~~~~~~~~~");
        for(Livre l : inventaire){
            l.AfficherDetails();
            System.out.println();
        }
    }
    //je cree une fonction Rechercher qui va retourner une liste(liste des resultats que la boucle va trouver)
    public ArrayList<Livre> RechercheLivre(String Critere){
        //je cree un liste pour les resultats de la reccherche pour facilité l'affichage
        ArrayList<Livre> resultat = new ArrayList<>();
        for (Livre l : inventaire) {
            if (l.getTitre().toLowerCase().matches(Critere.toLowerCase()) ||
                    l.getAuteur().toLowerCase().matches(Critere.toLowerCase()) ||
                    l.getCategorie().toLowerCase().matches(Critere.toLowerCase())) {
                resultat.add(l);
            }
        }
        return resultat;
    }
    public void EmprunterLivre(String NomUtilisateur, String titre) {
        Utilisateur u = null;
        for (Utilisateur U : utilisateurs) {
            if (U.getNom().equalsIgnoreCase(NomUtilisateur)) {
                u = U;
                break;
            }
        }
        if (u == null) {
            System.out.println("Utilisateur inexistant ! Créez un utilisateur SVP !");
        } else {
            Livre LEmprunter = null;
            for (Livre l : inventaire) {
                if (l.getTitre().equalsIgnoreCase(titre) && l.getQuantiteDisponible() > 0) {
                    LEmprunter = l;
                    break;
                }
            }
            if (LEmprunter != null) {
                int QteMaj = LEmprunter.getQuantiteDisponible();
                LEmprunter.setQuantiteDisponible(QteMaj - 1);
                u.EmprunterLivre(LEmprunter);
                LocalTime HeureEmprunt = LocalTime.now();
                LocalTime HeureEcheance = HeureEmprunt.plus(1,ChronoUnit.HOURS);
                LocalDate DateEmprunt = LocalDate.now();
                LocalDate DateEcheance = DateEmprunt.plus(2,ChronoUnit.WEEKS);
                System.out.println("Vous avez emprunté le livre : " + LEmprunter.getTitre()+" le "+DateEmprunt+" a "+HeureEmprunt);
                System.out.println("la date d'echeance est fixé au : "+DateEcheance+" a "+HeureEcheance);
            } else {
                System.out.println("Livre en rupture de stock ou introuvable");
            }
        }
    }

}
