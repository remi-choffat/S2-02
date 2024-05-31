import java.util.ArrayList;

/**
 * Classe permettant de résoudre le chemin le plus court d'un graphe
 * en utilisant l'algorithme de Dijkstra
 */
public class Dijkstra implements Algorithme {

   /*
   Entrees :
   G un graphe orienté avec une pondération positive des arcs (coût ou poids)
   A un sommet (départ) de G

   Début
   Q <- {} // utilisation d’une liste de noeuds à traiter
   Pour chaque sommet v de G faire
      v.valeur <- Infini
      v.parent <- Indéfini
      Q <- Q U {v} // ajouter le sommet v à la liste Q
   Fin Pour
   A.valeur <- 0
   Tant que Q est un ensemble non vide faire
      u <- un sommet de Q telle que u.valeur est minimal
      // enlever le sommet u de la liste Q
      Q <- Q \ {u}
      Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
         d <- u.valeur + poids(u,v)
         Si d < v.valeur
            // le chemin est plus intéressant
            Alors v.valeur <- d
               v.parent <- u
         Fin Si
      Fin Pour
   Fin Tant que
   Fin
    */

   /**
    * Résolution du chemin le plus court en partant d'un nœud de départ
    *
    * @param g      le graphe
    * @param depart le nœud de départ
    * @return la valeur du plus court chemin
    */
    public Valeur resoudre(Graphe g, String depart) {

	Valeur v = new Valeur();
	ArrayList<String> Q = new ArrayList<>();
	for(String n : g.listeNoeuds()){
	    v.setValeur(n, Double.MAX_VALUE);
	    v.setParent(n, null);
	    Q.add(n);
	}

	v.setValeur(depart, 0);
	while(!Q.isEmpty()){
	    String noeud = Q.get(0);
	    for(String s : Q){
		if(v.getValeur(s) < v.getValeur(noeud)){
		    noeud = s;
		}
	    }
	    Q.remove(noeud);

	    for(String u : Q){
		int index_u_suivant;
		index_u_suivant = -1;
		for(Arc suivant : g.suivants(noeud)){
		    if(suivant.getDest().equals(u)){
			index_u_suivant = g.suivants(noeud).indexOf(suivant);
		    }
		}

		if(index_u_suivant != -1){
		    double dist = v.getValeur(noeud) + g.suivants(noeud).get(index_u_suivant).getCout();
		    if(dist < v.getValeur(u)){
			v.setValeur(u, dist);
			v.setParent(u, noeud);
		    }
		}
	    }
	}
	return v;
    }

}
