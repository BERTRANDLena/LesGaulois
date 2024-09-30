package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[]tabEquipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		verifierForce(force);
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		verifierForce(force);
		int avant =  force;
		force -= forceCoup;
		int apres = force;
		if (force > 0) {
			parler("Aïe !");
		} else {
			parler("J'abandonne...");
		}
		verifierDiminution(avant,apres);
	}
	
	private void verifierForce(int force) {
		assert force > 0 : "La force du romain est positive";
	}
	
	private void verifierDiminution(int avant, int apres) {
		assert (apres < avant) : "La force a diminuée";
	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		
			case 2:
				System.out.println("Le soldat " + nom + "est déjà bien protégé!");
				break;
			case 1:
				if (tabEquipements[0] == equipement) {
					System.out.println("Le soldat " + nom + " possède déjà un casque!");
				}
				else {
					System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
					tabEquipements[1]=equipement;
					nbEquipement +=1;
				}
				break;
			case 0:
				tabEquipements[0] = equipement;
				nbEquipement += 1;
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
				break;
		}
		
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		
		System.out.println(minus);
		minus.parler("Bonjour");
		minus.recevoirCoup(5);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
	}

}
