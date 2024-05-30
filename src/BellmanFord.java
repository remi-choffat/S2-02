import java.util.ArrayList;
import java.util.List;

public class BellmanFord{

    public static Valeur resoudre(Graphe g, String depart){
	Valeur v = new Valeur();

	// Liste des noeuds du graphe
	List<String> listeNoeuds = g.listeNoeuds();

	// Initialise le noeud de départ à 0 et le reste à +∞
	for(int i = 0; i < listeNoeuds.size(); i++){
	    String noeud = listeNoeuds.get(i);

	    if(noeud.equals(depart)){
		v.setValeur(depart, 0);
	    }else{
		v.setValeur(noeud, Double.MAX_VALUE);
	    }
	} 

	// Listes servant à comparer les différentes itérations
	ArrayList<Double> list_vals = new ArrayList<>();
	ArrayList<Double> list_tmp_vals = new ArrayList<>();

	// Application de la méthode de point fixe
	while(true){

	    // La liste temporaire prend les valeurs de l'itération précédente
	    list_tmp_vals = list_vals;
	    // On fait une nouvelle liste pour ajouter de nouvelles valeurs
	    list_vals = new ArrayList<>();

	    for(int i = 0; i < listeNoeuds.size(); i++){
		// Le noeud actuellement parcouru
		String noeud = listeNoeuds.get(i);
		// Création d'une liste contenant les noeuds suivants au noeud actuel
		List<Arc> suivants = g.suivants(noeud);
		for(int j = 0; j < suivants.size(); j++){
		    // Un successeur au noeud actuel
		    Arc successeur = suivants.get(j);
		    // La distance du noeud suivant + la valeur du noeud actuel
		    double val = successeur.getCout() + v.getValeur(noeud);
		    // Vérifie si le calcul fait est inférieur à la valeur déjà présente sur le successeur
		    if(v.getValeur(successeur.getDest()) > val){
			// Applique la valeur au successeur
			v.setValeur(successeur.getDest(), val);
			// Applique le noeud actuel en tant que parent au successeur
			v.setParent(successeur.getDest(), noeud);
		    }
		    // Ajoute le résultat à la liste de comparaison
		    list_vals.add(val);
		}
	    }

	    // Si le résultat est le même que le précédent, arrêter la boucle
	    if(list_vals.equals(list_tmp_vals)){
		break;
	    }
	}

	return v;
    }
}
