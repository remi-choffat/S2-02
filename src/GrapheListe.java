import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {

   /*
    * Liste des noeuds du graphe
    */
   private ArrayList<String> noeuds;

   /*
    * Liste des Arcs partant de chaque nœud du graphe
    */
   private ArrayList<Arcs> adjacence;

   @Override
   public List<String> listeNoeuds() {
      return List.of();
   }

   @Override
   public List<Arc> suivants(String n) {
      return List.of();
   }

   public int getIndice(String n) {
      return noeuds.indexOf(n);
   }

   public void ajouterArc(String depart, String destination, double cout) {

       if(!noeuds.contains(depart)){
	   noeuds.add(depart);
	   adjacence.add(new Arcs());
       }
       if(!noeuds.contains(destination)){
	   noeuds.add(destination);
	   adjacence.add(new Arcs());
       }

       adjacence.get(noeuds.indexOf(depart)).ajouterArc(new Arc(destination, cout));
   }

}
