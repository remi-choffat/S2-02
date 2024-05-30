public class Arc {

   private String dest;
   private double cout;

   public Arc(String dest, double cout) {
      this.dest = dest;
      this.cout = cout;
   }

   public String getDest() {
      return dest;
   }

   public double getCout() {
      return cout;
   }

   public String toString() {
      return "(" + this.dest + ", " + this.cout + ")";
   }

}
