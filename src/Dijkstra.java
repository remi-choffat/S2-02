import java.util.ArrayList;

/**
 * Classe permettant de résoudre le chemin le plus court d'un graphe
 * en utilisant l'algorithme de Dijkstra
 */
public class Dijkstra implements Algorithme {

   /*
   Entrees :
   G un graphe orienté avec une pondération positive des arcs (coût ou poids)
   A un sommet (départ) de G

   Début
   Q <- {} // utilisation d’une liste de noeuds à traiter
   Pour chaque sommet v de G faire
      v.valeur <- Infini
      v.parent <- Indéfini
      Q <- Q U {v} // ajouter le sommet v à la liste Q
   Fin Pour
   A.valeur <- 0
   Tant que Q est un ensemble non vide faire
      u <- un sommet de Q telle que u.valeur est minimal
      // enlever le sommet u de la liste Q
      Q <- Q \ {u}
      Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
         d <- u.valeur + poids(u,v)
         Si d < v.valeur
            // le chemin est plus intéressant
            Alors v.valeur <- d
               v.parent <- u
         Fin Si
      Fin Pour
   Fin Tant que
   Fin
    */

   /**
    * Résolution du chemin le plus court en partant d'un nœud de départ
    *
    * @param g      le graphe
    * @param depart le nœud de départ
    * @return la valeur du plus court chemin
    */
   public Valeur resoudre(Graphe g, String depart) throws IllegalArgumentException {

      // Vérifie que le nœud de départ existe
      if (!g.listeNoeuds().contains(depart)) {
         throw new IllegalArgumentException("Le nœud de départ indiqué (" + depart + ") n'existe pas");
      }

      Valeur v = new Valeur();
      // Liste de nœuds à traiter
      ArrayList<String> Q = new ArrayList<>();

      // Initialisation des valeurs
      for (String n : g.listeNoeuds()) {
         v.setValeur(n, Double.MAX_VALUE);
         v.setParent(n, null);
         Q.add(n);
      }

      // Compter le nombre d'itérations pour comparer les algos
      // (pour voir ces infos, retirer les commentaires lignes 90 et 91)
      int compteur_etapes = 0;
      int compteur_calculs = 0;
      v.setValeur(depart, 0);
      while (!Q.isEmpty()) {
         String noeud = Q.get(0);
         // Trouver le nœud restant avec la plus petite valeur
         for (String s : Q) {
            if (v.getValeur(s) < v.getValeur(noeud)) {
               noeud = s;
            }
         }
         Q.remove(noeud);

         // Trouve l'index de l'enfant sélectionné
         for (Arc suivant : g.suivants(noeud)) {
            String nom_suivant = suivant.getDest();
            double cout_suivant = suivant.getCout();
            double dist = v.getValeur(noeud) + cout_suivant;
            if (dist < v.getValeur(nom_suivant)) {
               v.setValeur(nom_suivant, dist);
               v.setParent(nom_suivant, noeud);
            }
            compteur_calculs++;
         }
         compteur_etapes++;
      }
      // System.out.println("Nombre d'itérations avec la méthode de Dijkstra : " + compteur_etapes);
      // System.out.println("Nombre de calculs avec la méthode de Dijkstra : " + compteur_calculs);
      return v;
   }

   /**
    * Retourne le nom de l'algorithme
    *
    * @return le nom de l'algorithme
    */
   public String toString() {
      return "Dijkstra";
   }

}
