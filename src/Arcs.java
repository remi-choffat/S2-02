import java.util.ArrayList;
import java.util.List;

public class Arcs {

   /**
    * Liste des arcs
    */
   private List<Arc> arcs;

   /**
    * Constructeur de Arcs
    */
   public Arcs() {
      this.arcs = new ArrayList<Arc>();
   }

   /**
    * Ajoute un arc à la liste des arcs
    *
    * @param arc : l'arc à ajouter
    */
   public void ajouterArc(Arc arc) {
      arcs.add(arc);
   }

   /**
    * Retourne la liste des arcs
    *
    * @return la liste des arcs
    */
   public List<Arc> getArcs() {
      return arcs;
   }

}
