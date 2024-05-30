import java.util.ArrayList;
import java.util.List;

public class Arcs {

   private List<Arc> arcs;

   public Arcs() {
      this.arcs = new ArrayList<Arc>();
   }

   public void ajouterArc(Arc arc) {
      arcs.add(arc);
   }

   public List<Arc> getArcs() {
      return arcs;
   }

}
