public class Main {

   public static void main(String[] args) {

      // Création et affichage du graphe de la figure 1
      GrapheListe gl = new GrapheListe();
      gl.ajouterArc("D", "C", 10);
      gl.ajouterArc("A", "B", 12);
      gl.ajouterArc("D", "B", 23);
      gl.ajouterArc("A", "D", 87);
      gl.ajouterArc("E", "D", 43);
      gl.ajouterArc("B", "E", 11);
      gl.ajouterArc("C", "A", 19);
      System.out.println(gl);

      // TODO - Appliquer l'algo du point fixe et afficher les valeurs de distance pour chaque nœud (Q10)

   }

}
