
public class MainDijkstra {

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

      System.out.println("------- Graphe -------\n" + gl);

      // Résolution du chemin le plus court en partant de A par l'algo de Dijkstra
      System.out.println("------- Chemin le plus court en partant de A (Dijkstra)-------");
      Dijkstra dijkstra = new Dijkstra();
      Valeur v = gl.resoudreGraphe(dijkstra, "A");
      System.out.println(v);
      for (String noeud : gl.listeNoeuds()) {
         System.out.println("Chemin pour aller à " + noeud + " : " + v.calculerChemin(noeud));
      }
   }

}
