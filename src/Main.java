public class Main {

   public static void main(String[] args) {

      // Calcul du chemin le plus court sur un graphe fourni, en utilisant les deux algorithmes
      long start = System.currentTimeMillis();
      calculer("./graphes/Graphe905.txt", "1", new BellmanFord());
      long end = System.currentTimeMillis();
      System.out.println("Temps d'exécution de Bellman-Ford : " + (end - start) + " ms");

      start = System.currentTimeMillis();
      calculer("./graphes/Graphe905.txt", "1", new Dijkstra());
      end = System.currentTimeMillis();
      System.out.println("Temps d'exécution de Dijkstra : " + (end - start) + " ms");

   }

   public static void calculer(String g, String depart, Algorithme algorithme) {
      // Création d'un graphe à partir d'un fichier préconfiguré
      GrapheListe graphe = new GrapheListe(g);
      // Résolution du graphe en utilisant l'algorithme défini
      System.out.println("------- Chemin le plus court en partant de " + depart + " (" + algorithme + ")-------");
      Valeur v = graphe.resoudreGraphe(algorithme, depart);
      //System.out.println(v);
      // Affichage du chemin le plus court pour chaque nœud
//      for (String noeud : graphe.listeNoeuds()) {
//         System.out.println("Chemin pour aller à " + noeud + " : " + v.calculerChemin(noeud));
//      }
   }

}
