import java.util.List;

public interface Graphe {

   /*
    * Retourne la liste des nœuds du graphe
    */
   public List<String> listeNoeuds();

   /*
    * Retourne la liste des arcs partant du nœud n
    */
   public List<Arc> suivants(String n);

}
