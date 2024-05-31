public interface Algorithme {

   /**
    * Résout le graphe en partant du nœud de départ
    *
    * @param g      graphe
    * @param depart nœud de départ
    * @return la valeur du chemin le plus court
    */
   public Valeur resoudre(Graphe g, String depart);

}
