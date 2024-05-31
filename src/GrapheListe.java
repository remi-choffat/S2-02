import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation d'un graphe sous forme de liste d'adjacence
 */
public class GrapheListe implements Graphe {

   /**
    * Liste des noeuds du graphe
    */
   private ArrayList<String> noeuds;

   /**
    * Liste des Arcs partant de chaque nœud du graphe
    */
   private ArrayList<Arcs> adjacence;

   /**
    * Constructeur de GrapheListe
    */
   public GrapheListe() {
      noeuds = new ArrayList<String>();
      adjacence = new ArrayList<Arcs>();
   }

   /**
    * Retourne la liste des nœuds du graphe
    *
    * @return la liste des nœuds du graphe
    */
   @Override
   public List<String> listeNoeuds() {
      return this.noeuds;
   }

   /**
    * Retourne la liste d'adjacence du graphe
    * (utile pour les tests)
    *
    * @return la liste d'adjacence du graphe
    */
   public ArrayList<Arcs> getAdjacence() {
      return adjacence;
   }

   /**
    * Retourne la liste des arcs partant du nœud n
    *
    * @param n : le nœud
    * @return la liste des arcs partant du nœud n
    */
   @Override
   public List<Arc> suivants(String n) {
      return adjacence.get(getIndice(n)).getArcs();
   }

   /**
    * Retourne l'indice du nœud n dans la liste des nœuds
    */
   public int getIndice(String n) {
      return noeuds.indexOf(n);
   }

   /**
    * Ajoute un arc au graphe
    * Si les nœuds de départ et de destination n'existent pas, ils sont créés
    *
    * @param depart      : le nœud de départ
    * @param destination : le nœud de destination
    * @param cout        : le coût de l'arc
    */
   public void ajouterArc(String depart, String destination, double cout) {

      if (!noeuds.contains(depart)) {
         noeuds.add(depart);
         adjacence.add(new Arcs());
      }
      if (!noeuds.contains(destination)) {
         noeuds.add(destination);
         adjacence.add(new Arcs());
      }

      adjacence.get(noeuds.indexOf(depart)).ajouterArc(new Arc(destination, cout));
   }

   /**
    * Retourne une représentation du graphe
    *
    * @return une chaîne de caractères représentant le graphe
    */
   @Override
   public String toString() {
      StringBuilder res = new StringBuilder();
      for (String n : this.noeuds) {
         res.append(n).append(" -> ");
         for (Arc a : adjacence.get(getIndice(n)).getArcs()) {
            res.append(a.toString()).append(" ");
         }
         res.append("\n");
      }
      return res.toString();
   }
}
