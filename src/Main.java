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

      System.out.println("------- Graphe -------\n" + gl);

      // Résolution du chemin le plus court en partant de A par l'algo de BellmanFord
      System.out.println("------- Chemin le plus court en partant de A (Bellman-Ford)-------");
      // Algorithme de résolution
      Algorithme algorithme = new BellmanFord();
      // Résolution du graphe en utilisant l'algorithme défini
      Valeur v = gl.resoudreGraphe(algorithme, "A");
      System.out.println(v);
      for (String noeud : gl.listeNoeuds()) {
         System.out.println("Chemin pour aller à " + noeud + " : " + v.calculerChemin(noeud));
      }

      // Résolution du chemin le plus court en partant de 1 par l'algo de BellmanFord avec un fichier préconfiguré
      GrapheListe g2 = new GrapheListe("../graphes/Graphe301.txt");
      System.out.println("------- Chemin le plus court en partant de A (Bellman-Ford)-------");
      bf = new BellmanFord();
      v = bf.resoudre(g2, "1");
      System.out.println(v);
      System.out.println("Chemin pour aller à 202 : " + v.calculerChemin("202"));

   }

}
