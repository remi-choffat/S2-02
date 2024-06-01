import java.io.File;

public class Main {

   public final static Algorithme BELLMAN_FORD = new BellmanFord();
   public final static Algorithme DIJKSTRA = new Dijkstra();

   public static void main(String[] args) {

      // Calcul du chemin le plus court sur un graphe fourni, en utilisant les deux algorithmes
      mesurerTemps(5, "1", BELLMAN_FORD);
      mesurerTemps(5, "1", DIJKSTRA);
   }

   /**
    * Calcule le chemin le plus court en partant d'un nœud de départ
    *
    * @param g          graphe
    * @param depart     nœud de départ
    * @param algorithme algorithme à utiliser
    */
   public static void calculer(String g, String depart, Algorithme algorithme) {
      // Création d'un graphe à partir d'un fichier préconfiguré
      GrapheListe graphe = new GrapheListe(g);
      // Résolution du graphe en utilisant l'algorithme défini
      // System.out.println("------- Chemin le plus court en partant de " + depart + " (" + algorithme + ")-------");
      Valeur v = graphe.resoudreGraphe(algorithme, depart);
      // System.out.println(v);
      // Affichage du chemin le plus court pour chaque nœud
      // for (String noeud : graphe.listeNoeuds()) {
      //    System.out.println("Chemin pour aller à " + noeud + " : " + v.calculerChemin(noeud));
      // }
   }

   /**
    * Mesure le temps d'exécution d'un algorithme sur un graphe donné
    *
    * @param nbExec     nombre d'exécutions
    * @param depart     nœud de départ
    * @param algorithme algorithme à exécuter
    */
   public static void mesurerTemps(int nbExec, String depart, Algorithme algorithme) {
      int duration = 0;
      // Liste des graphes à traiter
      // Pour une exécution en dehors d'un IDE, il est nécessaire de spécifier le chemin
      // à partir de ce fichier Main.java (../graphes)
      File folder = new File("graphes");
      String[] listeGraphes = folder.list();
      assert listeGraphes != null;
      // Pour chaque graphe, on calcule le chemin le plus court
      for (String s : listeGraphes) {
         String g = "graphes/" + s;
         System.out.println(s);
         // On effectue plusieurs exécutions pour obtenir une moyenne
         for (int i = 0; i < nbExec; i++) {
            long start = System.currentTimeMillis();
            calculer(g, depart, algorithme);
            long end = System.currentTimeMillis();
            // Calcul de la durée moyenne d'exécution
            duration += (int) (end - start);
         }
      }
      // Affichage du temps moyen d'exécution pour toute la liste de graphes
      duration = duration / nbExec / listeGraphes.length;
      System.out.println("Temps moyen d'exécution de " + algorithme + " : " + duration + " ms\n");
   }

}
