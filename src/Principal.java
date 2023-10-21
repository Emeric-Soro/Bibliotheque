import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class Principal{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Bibliotheque biblio = new Bibliotheque();
        LivreScientifique Livre1 = new LivreScientifique(1,"ABC","Alpha","AB","Scientifique",2,"Education","Primaire","educatif");
        Roman Livre2 = new Roman(2,"L'Etranger","Albert Camus","Folio","Roman",50,"fiction Absurde");
        Professeur P1 = new Professeur("Satoru","Abidjan","0123456789","Math");
        Etudiant E1 = new Etudiant("Kouame Brunelle", "Rue de la BIA","0787547896","L2-Droit");
        biblio.AjouterUtilisateur(E1);
        biblio.AjouterUtilisateur(P1);
        biblio.AjouterLivre(Livre1);
        biblio.AjouterLivre(Livre2);
        int choix = 0;
        int choixId = 0;
        String Titre;
        String Auteur;
        String Edition;
        String Categorie;
        int Quantite = 0;
        int Id;
        String Domaine;
        String Niveau;
        String Genre;
        String CritereRecherche;
        String Nom;
        String Adresse;
        String NumeroTel;
        String Departement;
        String Classe;
        boolean validation = false;
        System.out.println("\n~~~~~~~~~~~~~~~~~~bienvenue dans ma bibliotheque~~~~~~~~~~~~~~~~~~\n");
        System.out.println("NB : avant de pouvoir emprunter un livre, vous devez \nvous creer un compte utilisateur\n");
        do { //choix de l'action
            System.out.println("1. Creer un nouvel utilisateur");
            System.out.println("2. Ajouter un nouveau livre");
            System.out.println("3. voir la liste des livres");
            System.out.println("4. rechercher un livre");
            System.out.println("5. Emprunter un livre");
            System.out.println("6. Rendre un livre");
            System.out.println("7. voir la liste des emprunteurs");
            System.out.println("8. Mettre a jour les Quantités");
            System.out.println("9. Quitter");
            System.out.print("choix : ");
            try{
                choix = Integer.parseInt(scan.next());
                if(choix < 1 || choix > 9){
                    System.out.println("Choississez parmis les numeros ci dessous\n");
                }
            } catch (NumberFormatException e){
                System.out.println("Entrer un numero parmis ceux ci-dessus s'il vous plaît");
            }
            System.out.println();
            if(choix == 1){
                System.out.println("Etes-vous \n1.un professeur ou \n2.un élève ? ");
                System.out.print("choix(1 ou 2) : ");
                int choixU = scan.nextInt();
                switch (choixU){
                    case 1 -> {
                        System.out.print("Entrer votre nom : ");
                        Nom = scan.nextLine();
                        scan.nextLine();

                        System.out.print("Votre adresse : ");
                        Adresse = scan.nextLine();

                        System.out.print("Entrer votre numero de telephone : ");
                        NumeroTel = scan.nextLine();

                        System.out.print("Votre departement : ");
                        Departement = scan.nextLine();

                        Professeur P = new Professeur(Nom,Adresse,NumeroTel,Departement);
                        biblio.AjouterUtilisateur(P);
                        System.out.println("Professeur Ajouter !\n");
                    }
                    case 2 -> {
                        System.out.print("Entrer votre nom : ");
                        Nom = scan.nextLine();
                        scan.nextLine();

                        System.out.print("Votre adresse : ");
                        Adresse = scan.nextLine();

                        System.out.print("Entrer votre numero de telephone : ");
                        NumeroTel = scan.nextLine();

                        System.out.print("Votre class : ");
                        Classe = scan.nextLine();

                        Etudiant E = new Etudiant(Nom,Adresse,NumeroTel,Classe);
                        biblio.AjouterUtilisateur(E);
                        System.out.println("Etudiant ajouter !\n");
                    }
                }
            }
            else if(choix == 2) { //pour ajouter un livre l'utilisateur va devoir choisir le type du livre a enregistrer
                System.out.println("quelle categorie de livre voulez-vous ajouter ?");
                System.out.println("1. Livre Scientifique ?");
                System.out.println("2. Roman ?");
                System.out.println("3. Poesie ?");
                System.out.println("4. Livre Theatrale ?");
                System.out.println("5. Bande Dessinee ?");
                System.out.print("choix : ");
                int choixL = scan.nextInt();
                switch (choixL) {
                    case 1 -> {
                        //pour le cas ou c'est un livre scientifique
                        System.out.print("Id du livre : ");
                        Id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("Titre du livre : ");
                        Titre = scan.nextLine();
                        System.out.print("Auteur : ");
                        Auteur = scan.nextLine();
                        System.out.print("Edition : ");
                        Edition = scan.nextLine();
                        System.out.println("Categorie : ");
                        Categorie = scan.nextLine();
                        System.out.print("Quantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine(); // Consommez le retour à la ligne en suspens

                        System.out.print("Genre : ");
                        Genre = scan.nextLine();
                        System.out.print("Domaine Scientifique : ");
                        Domaine = scan.nextLine();
                        System.out.print("Niveau d'etude : ");
                        Niveau = scan.nextLine();
                        //je cree une nouvelle instance de Livre scientifique
                        LivreScientifique NLS = new LivreScientifique(Id, Titre, Auteur, Edition, Categorie, Quantite,Genre, Domaine, Niveau);
                        biblio.AjouterLivre(NLS); //NLS pour nouveau livre scientifique. ici grace au polymorphisme
                        System.out.println("nouveau livre ajouter !\n\n");
                    }
                    // NLS sera ajouter a l'inventaire comme LivreScientifique derive de Livre l'objet
                    // va être directement specifier
                    case 2 -> {
                        System.out.print("Id du livre : ");
                        Id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("Titre du livre : ");
                        Titre = scan.nextLine();
                        System.out.print("Auteur : ");
                        Auteur = scan.nextLine();
                        System.out.print("Edition : ");
                        Edition = scan.nextLine();
                        System.out.println("Categorie : ");
                        Categorie = scan.nextLine();
                        System.out.print("Quantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine(); // Consommez le retour à la ligne en suspens

                        System.out.print("Genre : ");
                        Genre = scan.nextLine();
                        Roman NLR = new Roman(Id, Titre, Auteur, Edition, Categorie, Quantite, Genre);
                        biblio.AjouterLivre(NLR);
                        System.out.println("nouveau livre ajouter !\n\n");
                    }
                    case 3 -> {
                        System.out.print("Id du livre : ");
                        Id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("Titre du livre : ");
                        Titre = scan.nextLine();
                        System.out.print("Auteur : ");
                        Auteur = scan.nextLine();
                        System.out.print("Edition : ");
                        Edition = scan.nextLine();
                        System.out.println("Categorie : ");
                        Categorie = scan.nextLine();
                        System.out.print("Quantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine(); // Consommez le retour à la ligne en suspens

                        System.out.print("Genre : ");
                        Genre = scan.nextLine();
                        Poesie NLP = new Poesie(Id, Titre, Auteur, Edition, Categorie, Quantite, Genre);
                        biblio.AjouterLivre(NLP);
                        System.out.println("nouveau livre ajouter !\n\n");
                    }
                    case 4 -> {
                        System.out.print("Id du livre : ");
                        Id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("Titre du livre : ");
                        Titre = scan.nextLine();
                        System.out.print("Auteur : ");
                        Auteur = scan.nextLine();
                        System.out.print("Edition : ");
                        Edition = scan.nextLine();
                        System.out.println("Categorie : ");
                        Categorie = scan.nextLine();
                        System.out.print("Quantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine(); // Consommez le retour à la ligne en suspens

                        System.out.print("Genre : ");
                        Genre = scan.nextLine();
                        LivreTheatrale NLT = new LivreTheatrale(Id, Titre, Auteur, Edition, Categorie, Quantite, Genre);
                        biblio.AjouterLivre(NLT);
                        System.out.println("nouveau livre ajouter !\n\n");
                    }
                    case 5 -> {
                        System.out.print("Id du livre : ");
                        Id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("Titre du livre : ");
                        Titre = scan.nextLine();
                        System.out.print("Auteur : ");
                        Auteur = scan.nextLine();
                        System.out.print("Edition : ");
                        Edition = scan.nextLine();
                        System.out.println("Categorie : ");
                        Categorie = scan.nextLine();
                        System.out.print("Quantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine(); // Consommez le retour à la ligne en suspens

                        System.out.print("Genre : ");
                        Genre = scan.nextLine();
                        BandeDessinee NLBD = new BandeDessinee(Id, Titre, Auteur, Edition,Categorie, Quantite, Genre);
                        biblio.AjouterLivre(NLBD);
                        System.out.println("nouveau livre ajouter !\n\n");
                    }
                }

            }
            else if(choix == 3){
                biblio.VoirLivre();
            }
            else if(choix == 4){
                System.out.print("entrer le titre, l'auteur ou la categorie du livre rechercher : ");
                scan.nextLine();
                CritereRecherche = scan.nextLine();


                ArrayList<Livre> resultat = biblio.RechercheLivre(CritereRecherche);
                if(!resultat.isEmpty()) {
                    System.out.println("resultats de la recherche : ");
                    for (Livre livre : resultat) {
                        livre.AfficherDetails();
                    }
                }else {
                    System.out.println("ce livre n'est pas dans la bibliotheque !");
                    System.out.print("voulez vous l'ajouter ? \n choix(oui ou non) : ");
                    String choix2 = scan.nextLine();


                    if (choix2.equals("oui")){
                        System.out.println("quelle categorie de livre voulez-vous ajouter ?");
                        System.out.println("1. Livre Scientifique ?");
                        System.out.println("2. Roman ?");
                        System.out.println("3. Poesie ?");
                        System.out.println("4. Livre Theatrale ?");
                        System.out.println("5. Bande Dessinee ?");
                        System.out.print("choix : ");
                        int choixL = scan.nextInt();
                        switch (choixL) {
                            case 1 -> {
                                //pour le cas ou c'est un livre scientifique
                                System.out.print("Id du livre : ");
                                Id = scan.nextInt();
                                scan.nextLine();

                                System.out.print("Titre du livre : ");
                                Titre = scan.nextLine();
                                System.out.print("Auteur : ");
                                Auteur = scan.nextLine();
                                System.out.print("Edition : ");
                                Edition = scan.nextLine();
                                System.out.println("Categorie : ");
                                Categorie = scan.nextLine();
                                System.out.print("Quantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine(); // Consommez le retour à la ligne en suspens

                                System.out.print("Genre : ");
                                Genre = scan.nextLine();
                                System.out.print("Domaine Scientifique : ");
                                Domaine = scan.nextLine();
                                System.out.print("Niveau d'etude : ");
                                Niveau = scan.nextLine();
                                //je cree une nouvelle instance de Livre scientifique
                                LivreScientifique NLS = new LivreScientifique(Id, Titre, Auteur, Edition, Categorie, Quantite,Genre, Domaine, Niveau);
                                biblio.AjouterLivre(NLS); //NLS pour nouveau livre scientifique. ici grace au polymorphisme
                                System.out.println("nouveau livre ajouter !\n\n");
                            }
                            // NLS sera ajouter a l'inventaire comme LivreScientifique derive de Livre l'objet
                            // va être directement specifier
                            case 2 -> {
                                System.out.print("Id du livre : ");
                                Id = scan.nextInt();
                                scan.nextLine();

                                System.out.print("Titre du livre : ");
                                Titre = scan.nextLine();
                                System.out.print("Auteur : ");
                                Auteur = scan.nextLine();
                                System.out.print("Edition : ");
                                Edition = scan.nextLine();
                                System.out.println("Categorie : ");
                                Categorie = scan.nextLine();
                                System.out.print("Quantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine(); // Consommez le retour à la ligne en suspens

                                System.out.print("Genre : ");
                                Genre = scan.nextLine();
                                Roman NLR = new Roman(Id, Titre, Auteur, Edition, Categorie, Quantite, Genre);
                                biblio.AjouterLivre(NLR);
                                System.out.println("nouveau livre ajouter !\n\n");
                            }
                            case 3 -> {
                                System.out.print("Id du livre : ");
                                Id = scan.nextInt();
                                scan.nextLine();

                                System.out.print("Titre du livre : ");
                                Titre = scan.nextLine();
                                System.out.print("Auteur : ");
                                Auteur = scan.nextLine();
                                System.out.print("Edition : ");
                                Edition = scan.nextLine();
                                System.out.println("Categorie : ");
                                Categorie = scan.nextLine();
                                System.out.print("Quantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine(); // Consommez le retour à la ligne en suspens

                                System.out.print("Genre : ");
                                Genre = scan.nextLine();
                                Poesie NLP = new Poesie(Id, Titre, Auteur, Edition, Categorie, Quantite, Genre);
                                biblio.AjouterLivre(NLP);
                                System.out.println("nouveau livre ajouter !\n\n");
                            }
                            case 4 -> {
                                System.out.print("Id du livre : ");
                                Id = scan.nextInt();
                                scan.nextLine();

                                System.out.print("Titre du livre : ");
                                Titre = scan.nextLine();
                                System.out.print("Auteur : ");
                                Auteur = scan.nextLine();
                                System.out.print("Edition : ");
                                Edition = scan.nextLine();
                                System.out.println("Categorie : ");
                                Categorie = scan.nextLine();
                                System.out.print("Quantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine(); // Consommez le retour à la ligne en suspens

                                System.out.print("Genre : ");
                                Genre = scan.nextLine();
                                LivreTheatrale NLT = new LivreTheatrale(Id, Titre, Auteur, Edition, Categorie, Quantite, Genre);
                                biblio.AjouterLivre(NLT);
                                System.out.println("nouveau livre ajouter !\n\n");
                            }
                            case 5 -> {
                                System.out.print("Id du livre : ");
                                Id = scan.nextInt();
                                scan.nextLine();

                                System.out.print("Titre du livre : ");
                                Titre = scan.nextLine();
                                System.out.print("Auteur : ");
                                Auteur = scan.nextLine();
                                System.out.print("Edition : ");
                                Edition = scan.nextLine();
                                System.out.println("Categorie : ");
                                Categorie = scan.nextLine();
                                System.out.print("Quantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine(); // Consommez le retour à la ligne en suspens

                                System.out.print("Genre : ");
                                Genre = scan.nextLine();
                                BandeDessinee NLBD = new BandeDessinee(Id, Titre, Auteur, Edition,Categorie, Quantite, Genre);
                                biblio.AjouterLivre(NLBD);
                                System.out.println("nouveau livre ajouter !\n\n");
                            }
                        }

                    }
                    else if(choix2.equals("non")){
                        System.out.println("pas de sousci");
                    }else{
                        System.out.println("pas compris !");
                    }
                }
            }
            else if(choix == 5){
                System.out.print("entrer le titre du livre que vous souhaitez emprunter : ");
                Titre = scan.next();

                System.out.print("Entrer votre nom d'utilisateur : ");
                Nom = scan.next();

                biblio.EmprunterLivre(Nom,Titre);
            }
            else if(choix == 6){
                System.out.print("Entrer votre nom : ");
                Nom = scan.next();

                System.out.print("Entrer le titre du livre a rendre : ");
                Titre = scan.next();

                biblio.RendreLivre(Nom,Titre);
            }
            else if(choix == 7){
                biblio.AfficherEmprunteur();
            }
            else if(choix == 8){
                do {
                    boolean rep = true;
                    boolean rep2 = true;
                    System.out.print("entrer l'Id du livre dont vous voulez mettre a jour les quantités : ");
                    try {
                        choixId = Integer.parseInt(scan.next());
                    } catch (NumberFormatException e) {
                        System.out.println("Entrer un nombre S'il vous plaît !");
                        rep = false;
                    }
                    System.out.print("Entrer la quantité à ajouter : ");
                    try {
                        Quantite = Integer.parseInt(scan.next());
                    } catch (NumberFormatException e) {
                        System.out.println("un nombre s'il vous plaît !");
                        rep2 = false;
                    }
                    if(rep && rep2){
                        validation = true;
                        biblio.MajQte(choixId,Quantite);
                    }
                }while (!validation);

            }
        }while (choix != 9 );

    }
}