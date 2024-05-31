public class Main {

   public static void main(String[] args) {

      // Calcul du chemin le plus court sur le graphe fourni 905
      // en partant du nœud 1 avec l'algorithme de Bellman-Ford
      calculer("./graphes/Graphe905.txt", "1", new BellmanFord());

   }

   public static void calculer(String g, String depart, Algorithme algorithme) {
      // Création d'un graphe à partir d'un fichier préconfiguré
      GrapheListe graphe = new GrapheListe(g);
      // Résolution du graphe en utilisant l'algorithme défini
      System.out.println("------- Chemin le plus court en partant de " + depart + " (" + algorithme + ")-------");
      Valeur v = graphe.resoudreGraphe(algorithme, depart);
      System.out.println(v);
      // Affichage du chemin le plus court pour chaque nœud
      for (String noeud : graphe.listeNoeuds()) {
         System.out.println("Chemin pour aller à " + noeud + " : " + v.calculerChemin(noeud));
      }
   }

}
