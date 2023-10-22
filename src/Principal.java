import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class Principal{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
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
        String Prenom;
        String Adresse;
        String NumeroTel;
        String Departement;
        String Classe;
        boolean validation = false;
        Bibliotheque biblio = new Bibliotheque();
        LivreScientifique Livre1 = new LivreScientifique(1,"ABC","Alpha","AB", "Scientifique",2,"Education","Primaire","educatif");
        Roman Livre2 = new Roman(2,"L'Etranger","Albert Camus","Folio","Roman", 50,"fiction Absurde");
        Professeur P1 = new Professeur("Satoru","Gojo","Abidjan","0123456789","Math");
        Etudiant E1 = new Etudiant("Kouame","Brunelle", "Rue de la BIA","0787547896","L2-Droit");
        biblio.AjouterUtilisateur(E1);
        biblio.AjouterUtilisateur(P1);
        biblio.AjouterLivre(Livre1);
        biblio.AjouterLivre(Livre2);
        biblio.EmprunterLivre("Kouame","Brunelle","L'Etranger");

        System.out.println("\n\t~~~~~~~~~~~~~~~~~~~~bienvenue dans ma bibliotheque~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("\t\tNB : avant de pouvoir emprunter un livre, vous devez \n\t\tvous creer un compte utilisateur\n");
        do { //choix de l'action
            System.out.println("\t1. Creer un nouvel utilisateur");
            System.out.println("\t2. Ajouter un nouveau livre");
            System.out.println("\t3. voir la liste des livres");
            System.out.println("\t4. rechercher un livre");
            System.out.println("\t5. Emprunter un livre");
            System.out.println("\t6. Rendre un livre");
            System.out.println("\t7. voir la liste des emprunteurs");
            System.out.println("\t8. Mettre a jour les Quantités");
            System.out.println("\t9. Ajouter un auteur");
            System.out.println("\t10. Supprimer un livre");
            System.out.println("\t11. Quitter");
            System.out.print("\tchoix : ");
            try{
                choix = Integer.parseInt(scan.next());
                if(choix < 1 || choix > 11){
                    System.out.println("\tChoississez parmis les numeros ci dessous\n");
                }
            } catch (NumberFormatException e){
                System.out.println("\tEntrer un numero parmis ceux ci-dessus s'il vous plaît");
            }
            System.out.println();
            switch (choix){
                case 1 ->{
                    System.out.println("\tEtes-vous \n1.un professeur ou \n2.un élève ? ");
                    System.out.print("\tchoix(1 ou 2) : ");
                    int choixU = scan.nextInt();
                    switch (choixU){
                        case 1 -> {
                            System.out.print("\tEntrer votre nom : ");
                            Nom = scan.nextLine();
                            scan.nextLine();

                            System.out.print("\tVotre Prenom(s) : ");
                            Prenom = scan.nextLine();

                            System.out.print("\tVotre adresse : ");
                            Adresse = scan.nextLine();

                            System.out.print("\tEntrer votre numero de telephone : ");
                            NumeroTel = scan.nextLine();

                            System.out.print("\tVotre departement : ");
                            Departement = scan.nextLine();

                            Professeur P = new Professeur(Nom,Prenom,Adresse,NumeroTel,Departement);
                            biblio.AjouterUtilisateur(P);
                            System.out.println("\tProfesseur Ajouter !\n");
                        }
                        case 2 -> {
                            System.out.print("\tEntrer votre nom : ");
                            Nom = scan.nextLine();
                            scan.nextLine();

                            System.out.print("\tVotre Prenom(s) : ");
                            Prenom = scan.nextLine();

                            System.out.print("\tVotre adresse : ");
                            Adresse = scan.nextLine();

                            System.out.print("\tEntrer votre numero de telephone : ");
                            NumeroTel = scan.nextLine();

                            System.out.print("\tVotre class : ");
                            Classe = scan.nextLine();

                            Etudiant E = new Etudiant(Nom,Prenom,Adresse,NumeroTel,Classe);
                            biblio.AjouterUtilisateur(E);
                            System.out.println("\tEtudiant ajouter !\n");
                        }
                        default -> System.out.println("\tchoisi 1 ou 2");
                    }
                }
                case 2 ->{ //pour ajouter un livre l'utilisateur va devoir choisir le type du livre a enregistrer
                System.out.println("\tquelle categorie de livre voulez-vous ajouter ?");
                System.out.println("\t1. Livre Scientifique ?");
                System.out.println("\t2. Roman ?");
                System.out.println("\t3. Poesie ?");
                System.out.println("\t4. Livre Theatrale ?");
                System.out.println("\t5. Bande Dessinee ?");
                System.out.print("\tchoix : ");
                int choixL = scan.nextInt();
                switch (choixL) {
                    case 1 -> {
                        //pour le cas ou c'est un livre scientifique
                        System.out.print("\tId du livre : ");
                        Id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("\tTitre du livre : ");
                        Titre = scan.nextLine();

                        System.out.print("\tAuteur : ");
                        Auteur = scan.nextLine();

                        System.out.print("\tEdition : ");
                        Edition = scan.nextLine();

                        System.out.println("\tCategorie : ");
                        Categorie = scan.nextLine();

                        System.out.print("\tQuantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine(); // Consommez le retour à la ligne en suspens

                        System.out.print("\tGenre : ");
                        Genre = scan.nextLine();

                        System.out.print("\tDomaine Scientifique : ");
                        Domaine = scan.nextLine();
                        System.out.print("\tNiveau d'etude : ");
                        Niveau = scan.nextLine();

                        //je cree une nouvelle instance de Livre scientifique
                        LivreScientifique NLS = new LivreScientifique(Id, Titre, Auteur, Edition, Categorie, Quantite,Genre, Domaine, Niveau);
                        biblio.AjouterLivre(NLS); //NLS pour nouveau livre scientifique. ici grace au polymorphisme
                        System.out.println("\tnouveau livre ajouter !\n\n");
                    }
                    // NLS sera ajouter a l'inventaire comme LivreScientifique derive de Livre l'objet
                    // va être directement specifier
                    case 2 -> {
                        System.out.print("\tId du livre : ");
                        Id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("\tTitre du livre : ");
                        Titre = scan.nextLine();

                        System.out.print("\tAuteur : ");
                        Auteur = scan.nextLine();

                        System.out.print("\tEdition : ");
                        Edition = scan.nextLine();

                        System.out.println("\tCategorie : ");
                        Categorie = scan.nextLine();

                        System.out.print("\tQuantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine(); // Consommez le retour à la ligne en suspens

                        System.out.print("\tGenre : ");
                        Genre = scan.nextLine();

                        Roman NLR = new Roman(Id, Titre, Auteur, Edition, Categorie, Quantite, Genre);
                        biblio.AjouterLivre(NLR);
                        System.out.println("\tnouveau livre ajouter !\n\n");
                    }
                    case 3 -> {
                        System.out.print("\tId du livre : ");
                        Id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("\tTitre du livre : ");
                        Titre = scan.nextLine();

                        System.out.print("\tAuteur : ");
                        Auteur = scan.nextLine();

                        System.out.print("\tEdition : ");
                        Edition = scan.nextLine();

                        System.out.print("\tCategorie : ");
                        Categorie = scan.nextLine();

                        System.out.print("\tQuantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine(); // Consommez le retour à la ligne en suspens

                        System.out.print("\tGenre : ");
                        Genre = scan.nextLine();

                        Poesie NLP = new Poesie(Id, Titre, Auteur, Edition, Categorie, Quantite, Genre);
                        biblio.AjouterLivre(NLP);
                        System.out.println("\tnouveau livre ajouter !\n\n");
                    }
                    case 4 -> {
                        System.out.print("\tId du livre : ");
                        Id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("\tTitre du livre : ");
                        Titre = scan.nextLine();

                        System.out.print("\tAuteur : ");
                        Auteur = scan.nextLine();

                        System.out.print("\tEdition : ");
                        Edition = scan.nextLine();

                        System.out.print("\tCategorie : ");
                        Categorie = scan.nextLine();

                        System.out.print("\tQuantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine(); // Consommez le retour à la ligne en suspens

                        System.out.print("\tGenre : ");
                        Genre = scan.nextLine();

                        LivreTheatrale NLT = new LivreTheatrale(Id, Titre, Auteur, Edition, Categorie, Quantite, Genre);
                        biblio.AjouterLivre(NLT);
                        System.out.println("\tnouveau livre ajouter !\n\n");
                    }
                    case 5 -> {
                        System.out.print("\tId du livre : ");
                        Id = scan.nextInt();
                        scan.nextLine();

                        System.out.print("\tTitre du livre : ");
                        Titre = scan.nextLine();

                        System.out.print("\tAuteur : ");
                        Auteur = scan.nextLine();

                        System.out.print("\tEdition : ");
                        Edition = scan.nextLine();

                        System.out.print("\tCategorie : ");
                        Categorie = scan.nextLine();

                        System.out.print("\tQuantite : ");
                        Quantite = scan.nextInt();
                        scan.nextLine(); // Consommez le retour à la ligne en suspens

                        System.out.print("\tGenre : ");
                        Genre = scan.nextLine();

                        BandeDessinee NLBD = new BandeDessinee(Id, Titre, Auteur, Edition,Categorie, Quantite, Genre);
                        biblio.AjouterLivre(NLBD);
                        System.out.println("\tnouveau livre ajouter !\n\n");
                    }
                }

            }
                case 3 -> biblio.VoirLivre();
                case 4 ->{
                System.out.print("\tentrer le titre, l'auteur ou la categorie du livre rechercher : ");
                scan.nextLine();
                CritereRecherche = scan.nextLine();


                ArrayList<Livre> resultat = biblio.RechercheLivre(CritereRecherche);
                if(!resultat.isEmpty()) {
                    System.out.println("\tresultats de la recherche : ");
                    for (Livre livre : resultat) {
                        livre.AfficherDetails();
                    }
                }else {
                    System.out.println("\tce livre n'est pas dans la bibliotheque !");
                    System.out.print("\tvoulez vous l'ajouter ? \n choix(oui ou non) : ");
                    String choix2 = scan.nextLine();


                    if (choix2.equals("oui")){
                        System.out.println("\tquelle categorie de livre voulez-vous ajouter ?");
                        System.out.println("\t1. Livre Scientifique ?");
                        System.out.println("\t2. Roman ?");
                        System.out.println("\t3. Poesie ?");
                        System.out.println("\t4. Livre Theatrale ?");
                        System.out.println("\t5. Bande Dessinee ?");
                        System.out.print("\tchoix : ");
                        int choixL = scan.nextInt();
                        switch (choixL) {
                            case 1 -> {
                                //pour le cas ou c'est un livre scientifique
                                System.out.print("\tId du livre : ");
                                Id = scan.nextInt();
                                scan.nextLine();

                                System.out.print("\tTitre du livre : ");
                                Titre = scan.nextLine();

                                System.out.print("\tAuteur : ");
                                Auteur = scan.nextLine();

                                System.out.print("\tEdition : ");
                                Edition = scan.nextLine();

                                System.out.println("\tCategorie : ");
                                Categorie = scan.nextLine();

                                System.out.print("\tQuantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine(); // Consommez le retour à la ligne en suspens

                                System.out.print("\tGenre : ");
                                Genre = scan.nextLine();

                                System.out.print("\tDomaine Scientifique : ");
                                Domaine = scan.nextLine();

                                System.out.print("\tNiveau d'etude : ");
                                Niveau = scan.nextLine();

                                //je cree une nouvelle instance de Livre scientifique
                                LivreScientifique NLS = new LivreScientifique(Id, Titre, Auteur, Edition, Categorie, Quantite,Genre, Domaine, Niveau);
                                biblio.AjouterLivre(NLS); //NLS pour nouveau livre scientifique. ici grace au polymorphisme

                                System.out.println("\tnouveau livre ajouter !\n\n");
                            }
                            // NLS sera ajouter a l'inventaire comme LivreScientifique derive de Livre l'objet
                            // va être directement specifier
                            case 2 -> {
                                System.out.print("\tId du livre : ");
                                Id = scan.nextInt();
                                scan.nextLine();

                                System.out.print("\tTitre du livre : ");
                                Titre = scan.nextLine();

                                System.out.print("\tAuteur : ");
                                Auteur = scan.nextLine();

                                System.out.print("\tEdition : ");
                                Edition = scan.nextLine();

                                System.out.println("\tCategorie : ");
                                Categorie = scan.nextLine();

                                System.out.print("\tQuantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine(); // Consommez le retour à la ligne en suspens

                                System.out.print("\tGenre : ");
                                Genre = scan.nextLine();

                                Roman NLR = new Roman(Id, Titre, Auteur, Edition, Categorie, Quantite, Genre);
                                biblio.AjouterLivre(NLR);

                                System.out.println("\tnouveau livre ajouter !\n\n");
                            }
                            case 3 -> {
                                System.out.print("\tId du livre : ");
                                Id = scan.nextInt();
                                scan.nextLine();

                                System.out.print("\tTitre du livre : ");
                                Titre = scan.nextLine();

                                System.out.print("\tAuteur : ");
                                Auteur = scan.nextLine();

                                System.out.print("\tEdition : ");
                                Edition = scan.nextLine();

                                System.out.println("\tCategorie : ");
                                Categorie = scan.nextLine();

                                System.out.print("\tQuantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine(); // Consommez le retour à la ligne en suspens

                                System.out.print("\tGenre : ");
                                Genre = scan.nextLine();

                                Poesie NLP = new Poesie(Id, Titre, Auteur, Edition, Categorie, Quantite, Genre);
                                biblio.AjouterLivre(NLP);

                                System.out.println("\tnouveau livre ajouter !\n\n");
                            }
                            case 4 -> {
                                System.out.print("\tId du livre : ");
                                Id = scan.nextInt();
                                scan.nextLine();

                                System.out.print("\tTitre du livre : ");
                                Titre = scan.nextLine();

                                System.out.print("\tAuteur : ");
                                Auteur = scan.nextLine();

                                System.out.print("\tEdition : ");
                                Edition = scan.nextLine();

                                System.out.println("\tCategorie : ");
                                Categorie = scan.nextLine();

                                System.out.print("\tQuantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine(); // Consommez le retour à la ligne en suspens

                                System.out.print("\tGenre : ");
                                Genre = scan.nextLine();

                                LivreTheatrale NLT = new LivreTheatrale(Id, Titre, Auteur, Edition, Categorie, Quantite, Genre);
                                biblio.AjouterLivre(NLT);

                                System.out.println("\tnouveau livre ajouter !\n\n");
                            }
                            case 5 -> {
                                System.out.print("\tId du livre : ");
                                Id = scan.nextInt();
                                scan.nextLine();

                                System.out.print("\tTitre du livre : ");
                                Titre = scan.nextLine();
                                System.out.print("\tAuteur : ");
                                Auteur = scan.nextLine();
                                System.out.print("\tEdition : ");
                                Edition = scan.nextLine();
                                System.out.println("\tCategorie : ");
                                Categorie = scan.nextLine();
                                System.out.print("\tQuantite : ");
                                Quantite = scan.nextInt();
                                scan.nextLine(); // Consommez le retour à la ligne en suspens

                                System.out.print("\tGenre : ");
                                Genre = scan.nextLine();
                                BandeDessinee NLBD = new BandeDessinee(Id, Titre, Auteur, Edition,Categorie, Quantite, Genre);
                                biblio.AjouterLivre(NLBD);
                                System.out.println("\tnouveau livre ajouter !\n\n");
                            }
                        }

                    }
                    else if(choix2.equals("non")){
                        System.out.println("\tpas de sousci");
                    }else{
                        System.out.println("\tpas compris !");
                    }
                }
            }
                case 5 ->{
                System.out.print("\tentrer le titre du livre que vous souhaitez emprunter : ");
                Titre = scan.next();

                System.out.print("\tEntrer votre nom : ");
                Nom = scan.next();

                System.out.print("\tVotre Prenom(s) : ");
                Prenom = scan.next();

                biblio.EmprunterLivre(Nom,Prenom,Titre);
                }
                case 6 ->{
                System.out.print("\tEntrer votre nom : ");
                Nom = scan.next();

                System.out.print("\tVotre Prenom(s) : ");
                Prenom = scan.next();

                System.out.print("\tEntrer le titre du livre a rendre : ");
                Titre = scan.next();

                biblio.RendreLivre(Nom,Prenom,Titre);
                }
                case 7 -> biblio.AfficherEmprunteur();
                case 8 ->{
                do {
                    boolean rep = true;
                    boolean rep2 = true;
                    System.out.print("\tentrer l'Id du livre dont vous voulez mettre a jour les quantités : ");
                    try {
                        choixId = Integer.parseInt(scan.next());
                    } catch (NumberFormatException e) {
                        System.out.println("\tEntrer un nombre S'il vous plaît !");
                        rep = false;
                    }
                    System.out.print("\tEntrer la quantité à ajouter : ");
                    try {
                        Quantite = Integer.parseInt(scan.next());
                    } catch (NumberFormatException e) {
                        System.out.println("\tun nombre s'il vous plaît !");
                        rep2 = false;
                    }
                    if(rep && rep2){
                        validation = true;
                        biblio.MajQte(choixId,Quantite);
                    }
                }while (!validation);

                }
                case 9 ->{
                System.out.print("\tEntrer votre nom : ");
                Nom = scan.nextLine();
                scan.nextLine();

                System.out.print("\tla date de naissance de l'auteur : ");
                String DateNaissance = scan.nextLine();

                System.out.print("\tEcrivez la biographie de l'auteur : ");
                String Bio = scan.nextLine();

                Auteur A = new Auteur(Nom,DateNaissance,Bio);
                biblio.AjouterAuteur(A);

                System.out.println(("Auteur ajouter !"));
                }
                case 10 ->{
                    System.out.print("Entrer l' id du livre que vous voulez supprimer : ");
                    Id = scan.nextInt();
                    biblio.SupprimerLivre(Id);
                }
            }
        }while (choix != 11 );
    }
}