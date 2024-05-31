import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Classe de test
 */
public class TestGraphe {

   // Creation d'un graphe pour les tests
   static GrapheListe g = new GrapheListe();
   static BellmanFord bf = new BellmanFord();

   @BeforeAll
   public static void createGraph() {
      g.ajouterArc("A", "B", 1);
      g.ajouterArc("A", "C", 2);
      g.ajouterArc("B", "C", 3);
      g.ajouterArc("C", "A", 4);
      g.ajouterArc("C", "B", 5);
      g.ajouterArc("C", "D", 6);
      g.ajouterArc("D", "A", 7);
      g.ajouterArc("D", "B", 8);
      g.ajouterArc("D", "C", 9);
   }

   /**
    * Test de construction d'un Arc
    */
   @Test
   public void testArc() {
      Arc a = new Arc("A", 1);
      assertEquals("A", a.getDest(), "Destination");
      assertEquals(1.0, a.getCout(), "Cout");
      assertEquals("A(1.0)", a.toString(), "ToString");
   }

   /**
    * Test de la methode de construction d'une liste d'Arcs
    */
   @Test
   public void testListeArcs() {
      assertEquals("[B(1.0), C(2.0)]", g.getAdjacence().getFirst().getArcs().toString());
   }

   /**
    * Test des suivants d'un nœud
    */
   @Test
   public void testSuivants() {
      assertEquals(2, g.suivants("A").size());
      assertEquals("[C(3.0)]", g.suivants("B").toString());
   }

   /**
    * Test de la methode de construction d'une liste de nœuds
    */
   @Test
   public void testListeNoeuds() {
      assertEquals("[A, B, C, D]", g.listeNoeuds().toString(), "Liste des noeuds");
   }

   /**
    * Test de la methode la construction d'un graphe
    */
   @Test
   public void testGrapheListe() {
      assertEquals("[B(1.0), C(2.0)]", g.suivants("A").toString());
      assertEquals("[C(3.0)]", g.suivants("B").toString());
      assertEquals("[A(4.0), B(5.0), D(6.0)]", g.suivants("C").toString());
      assertEquals("[A(7.0), B(8.0), C(9.0)]", g.suivants("D").toString());
   }

   /**
    * Test de la methode de recherche de l'indice d'un nœud
    */
   @Test
   public void testIndice() {
      assertEquals(0, g.getIndice("A"));
      assertEquals(1, g.getIndice("B"));
      assertEquals(2, g.getIndice("C"));
      assertEquals(3, g.getIndice("D"));
   }

   /**
    * Test de la méthode toString de Valeur
    */
   @Test
   public void testToStringValeur() {
      Valeur v = new Valeur();
      v.setValeur("A", 1);
      v.setValeur("B", 2);
      v.setValeur("C", 3);
      v.setValeur("D", 4);
      v.setParent("A", "B");
      v.setParent("B", "C");
      v.setParent("C", "D");
      v.setParent("D", "A");
      assertEquals("A ->  V:1.0 p:B\nB ->  V:2.0 p:C\nC ->  V:3.0 p:D\nD ->  V:4.0 p:A\n", v.toString());
   }

   /**
    * Test de la méthode toString de GrapheListe
    */
   @Test
   public void testToStringGrapheListe() {
      assertEquals("A -> B(1.0) C(2.0) \n" +
            "B -> C(3.0) \n" +
            "C -> A(4.0) B(5.0) D(6.0) \n" +
            "D -> A(7.0) B(8.0) C(9.0) \n", g.toString());
   }

   /**
    * Test de la méthode calculerChemin de Valeur
    */
   @Test
   public void testCalculerChemin() {
      Valeur v = bf.resoudre(g, "A");
      assertEquals("[A, C, D]", v.calculerChemin("D").toString());
   }

   /**
    * Test du cout
    */
   @Test
   public void testCout() {
      assertEquals(1.0, g.getAdjacence().getFirst().getArcs().get(0).getCout());
      assertEquals(2.0, g.getAdjacence().getFirst().getArcs().get(1).getCout());
   }

   /**
    * Test de l'algorithme du point fixe
    */
   @Test
   public void testPointFixe() {
      Valeur v = bf.resoudre(g, "A");
      assertEquals(0.0, v.getValeur("A"), "A");
      assertEquals(1.0, v.getValeur("B"), "B");
      assertEquals(2.0, v.getValeur("C"), "C");
      assertEquals(8.0, v.getValeur("D"), "D");
   }

   /**
    * Test de l'algorithme du point fixe avec un sommet inexistant
    */
   @Test
   public void testPointFixeInexistant() {
      assertThrows(IllegalArgumentException.class, () -> bf.resoudre(g, "E"));
   }

   /**
    * Test de l'algorithme du point fixe : calcul des parents
    */
   @Test
   public void testPointFixeParents() {
      Valeur v = bf.resoudre(g, "A");
      assertEquals("A", v.getParent("B"), "B");
      assertEquals("A", v.getParent("C"), "C");
      assertEquals("C", v.getParent("D"), "D");
   }

}
