/**
 * Classe représentant un arc d'un graphe
 */
public class Arc {

   /**
    * Destination de l'arc
    */
   private String dest;

   /**
    * Coût de l'arc
    */
   private double cout;

   /**
    * Constructeur de la classe Arc
    *
    * @param dest : la destination de l'arc
    * @param cout : le coût de l'arc
    */
   public Arc(String dest, double cout) {
      this.dest = dest;
      this.cout = cout;
   }

   /**
    * Retourne la destination de l'arc
    *
    * @return la destination de l'arc
    */
   public String getDest() {
      return dest;
   }

   /**
    * Retourne le coût de l'arc
    *
    * @return le coût de l'arc
    */
   public double getCout() {
      return cout;
   }

   /**
    * Retourne une représentation de l'arc
    *
    * @return une représentation de l'arc sous forme de chaîne de caractères
    */
   public String toString() {
      return this.dest + "(" + this.cout + ")";
   }

}
