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
    * Test de la methode la construction d'un graphe
    */
   @Test
   public void testGrapheListe() {
      assertEquals("[A, B, C, D]", g.listeNoeuds().toString(), "Liste des noeuds");
      assertEquals("[B(1.0), C(2.0)]", g.suivants("A").toString());
      assertEquals("[C(3.0)]", g.suivants("B").toString());
      assertEquals("[A(4.0), B(5.0), D(6.0)]", g.suivants("C").toString());
      assertEquals("[A(7.0), B(8.0), C(9.0)]", g.suivants("D").toString());
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

}
