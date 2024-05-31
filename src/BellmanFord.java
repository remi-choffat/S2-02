import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de résoudre le chemin le plus court d'un graphe
 * en utilisant l'algorithme de Bellman-Ford
 */
public class BellmanFord implements Algorithme {

   /*
   fonction pointFixe(Graphe g, Noeud depart) retourne v:
   début
      listeNoeuds <- g.listeNoeuds()
      Pour chaque noeud de listeNoeuds
         Si noeud = depart
            v.setValeur(depart, 0)
         Sinon
            v.setValeur(noeud, Infini)
         Fin si
      Fin Pour

      list_vals <- {depart}
      list_tmp_vals <- {}

      Tant que non list_vals = list_tmp_vals Faire
         list_tmp_vals <- list_vals
         list_vals <- {}

         Pour noeud dans listeNoeuds faire
            suivants <- g.suivants(noeud)
            Pour successeur dans suivants Faire
               val <- successeur.getCout() + v.getValeur(noeud)
               Si v.getValeur(successeur.getDest()) > val Alors
                  v.setValeur(successeur.getDest(), val)
                  v.setParent(successeur.getDest(), noeud)
               Fin Si
               list_vals <- list_vals U {val}
            Fin Pour
         Fin Pour
      Fin tant que
   fin
    */

   /**
    * Résolution du chemin le plus court en partant d'un nœud de départ
    *
    * @param g      graphe
    * @param depart nœud de départ
    * @return la valeur du chemin le plus court
    */
   public Valeur resoudre(Graphe g, String depart) throws IllegalArgumentException {
      Valeur v = new Valeur();

      // Liste des noeuds du graphe
      List<String> listeNoeuds = g.listeNoeuds();

      // Vérifie si le nœud de départ existe
      if (!listeNoeuds.contains(depart)) {
         throw new IllegalArgumentException("Le nœud de départ indiqué (" + depart + ") n'existe pas");
      }

      // Initialise le nœud de départ à 0 et le reste à +∞
      for (String noeud : listeNoeuds) {
         if (noeud.equals(depart)) {
            v.setValeur(depart, 0);
         } else {
            v.setValeur(noeud, Double.MAX_VALUE);
         }
      }

      // Listes servant à comparer les différentes itérations
      ArrayList<Double> list_vals = new ArrayList<>();
      ArrayList<Double> list_tmp_vals;

      // Application de la méthode de point fixe
      do {

         // La liste temporaire prend les valeurs de l'itération précédente
         list_tmp_vals = list_vals;
         // On fait une nouvelle liste pour ajouter de nouvelles valeurs
         list_vals = new ArrayList<>();

         for (String noeud : listeNoeuds) {
            // Le nœud actuellement parcouru
            // Création d'une liste contenant les nœuds suivants au nœud actuel
            List<Arc> suivants = g.suivants(noeud);
            for (Arc successeur : suivants) {
               // Un successeur au nœud actuel
               // La distance du nœud suivant + la valeur du nœud actuel
               double val = successeur.getCout() + v.getValeur(noeud);
               // Vérifie si le calcul fait est inférieur à la valeur déjà présente sur le successeur
               if (v.getValeur(successeur.getDest()) > val) {
                  // Applique la valeur au successeur
                  v.setValeur(successeur.getDest(), val);
                  // Applique le nœud actuel en tant que parent au successeur
                  v.setParent(successeur.getDest(), noeud);
               }
               // Ajoute le résultat à la liste de comparaison
               list_vals.add(val);
            }
         }

         // Si le résultat est le même que le précédent, arrêter la boucle
      } while (!list_vals.equals(list_tmp_vals));

      return v;
   }
}
