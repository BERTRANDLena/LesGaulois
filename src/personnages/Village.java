package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois += 1;
	}

	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}

	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les l�gendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irr�ductibles", 30);

//		Gaulois gaulois = village.trouverHabitant(30);
//		30 d�passe la limite du tableau

		Chef chef = new Chef("Abraracourcix", 6, village);
		village.setChef(chef);
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		village.ajouterHabitant(asterix);

//		Gaulois gaulois = village.trouverHabitant(1); 
//		System.out.println(gaulois);
//		Ast�rix est le villageois 0 du village

		Gaulois obelix = new Gaulois("Ob�lix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
		
	}
}
