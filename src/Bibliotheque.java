import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
public class Bibliotheque {
    ArrayList<Livre> inventaire = new ArrayList<>();
    ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
    ArrayList<Auteur> auteurs = new ArrayList<>();
    ArrayList<Utilisateur> UemprunterLivre = new ArrayList<>();//Array liste pour les utilisateur qui ont emprunter un livre
    public void AjouterLivre(Livre L){
        inventaire.add(L);
    }
    public void AjouterUtilisateur(Utilisateur u){
        for(Utilisateur Uexiste : utilisateurs){
            if(Uexiste.getNom().toLowerCase().matches(u.getNom().toLowerCase()) &&
            Uexiste.getPrenom().toLowerCase().matches(u.getPrenom()) &&
            Uexiste.getNumeroTelephone().matches(u.getNumeroTelephone())){
                System.out.println("CET UTILISATEUR EXISTE DEJA !");
                return;
            }
        }
        utilisateurs.add(u);
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
    public void EmprunterLivre(String NomUtilisateur, String PrenomUtilisateur, String titre) {
        Utilisateur u = null;
        for (Utilisateur U : utilisateurs) {
            if (U.getNom().equalsIgnoreCase(NomUtilisateur) && U.getPrenom().equalsIgnoreCase(PrenomUtilisateur)) {
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
                UemprunterLivre.add(u);
            } else {
                System.out.println("Livre en rupture de stock ou introuvable");
            }
        }
    }
    public void RendreLivre(String NomUtilisateur, String PrenomUtilisateur, String titre){
        Utilisateur u = null;
        for (Utilisateur U : UemprunterLivre) {
            if (U.getNom().equalsIgnoreCase(NomUtilisateur) && U.getPrenom().equalsIgnoreCase(PrenomUtilisateur)){
                u = U;
                break;
            }
        }
        if (u == null) {
            System.out.println("Cet utilisateur est inexistant ! ou il n'a pas encore emprunter un livre");
        } else {
            Livre LRendre = null;
            for (Livre l : u.getLivresEmprunter()){
                if(l.getTitre().toLowerCase().matches(titre.toLowerCase())){
                    LRendre = l;
                    break;
                }
            }
            if(LRendre != null){
                int QteMaj = LRendre.getQuantiteDisponible();
                LRendre.setQuantiteDisponible(QteMaj + 1);
                u.RendreLivre(LRendre);
                LocalDate DateRetour = LocalDate.now();
                LocalTime HeureRetour = LocalTime.now();
                System.out.println("vous avez rendu le livre "+LRendre.getTitre()+" le "+DateRetour+" a "+HeureRetour);
            }
            else {
                System.out.println("vous n'avez pas emprunter ce livre ! Ou livre introuvable");
            }
        }
    }
    public void AfficherEmprunteur(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~LISTE DES EMPRUNTEUR~~~~~~~~~~~~~~~~~~~~\n");
        for(Utilisateur u : utilisateurs){
            System.out.println("Nom de l'utilisateur : "+u.getNom());
            if(u.getLivresEmprunter().isEmpty()){
                System.out.println("cet utilisateur n'a emprunter aucun livre");
            }
            else {
                System.out.println("Livre emprunter par : "+u.getNom());
                for(Livre l : u.getLivresEmprunter()){
                    System.out.println("* "+l.getTitre());
                }
            }
            System.out.println();
        }

    }
    public void MajQte(int id, int NQte){
        Livre lMaj = null;
        int QteActuelle;
        int NouvelleQte;
        for (Livre l : inventaire){
            if(id == l.getId()){
                lMaj = l;
                break;
            }
        }
        if(lMaj != null){
            QteActuelle = lMaj.getQuantiteDisponible();
            NouvelleQte = QteActuelle + NQte;
            if(NouvelleQte < 0){
                NouvelleQte = 0;
            }
            else{
                lMaj.setQuantiteDisponible(NouvelleQte);
            }
            System.out.println("Les quantites du livre : "+lMaj.getTitre()+" ont ete mis a jour");
        }
        else {
            System.out.println("livre introuvable !");
        }

    }
    public void AjouterAuteur(Auteur a){
        auteurs.add(a);
    }
    public void SupprimerLivre(int Id){
        Livre Lsup = null;
        for (Livre l : inventaire){
            if(Id == l.getId()){
                Lsup = l;
                break;
            }
        }
        if(Lsup != null){
            inventaire.remove(Lsup);
        }else {
            System.out.println("Cet Id ne correspond a aucun livre !");
        }
    }
}
