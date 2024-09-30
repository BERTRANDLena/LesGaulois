package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] tabEquipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert verifierForce();
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
		int avant = force;
		force -= forceCoup;
		assert verifierForce();
		if (force > 0) {
			parler("Aïe !");
		} else {
			parler("J'abandonne...");
		}
		assert (force < avant) : "La force a diminuée";
	}

	private boolean verifierForce() {
		return force > 0 ;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {

		case 2:
			System.out.println("Le soldat " + nom + "est déjà bien protégé!");
			break;
		case 1:
			if (tabEquipements[0] == equipement) {
				System.out.println("Le soldat " + nom + " possède déjà un casque!");
			} else {
				ajouterEquipement(equipement);
			}
			break;
		case 0:
			ajouterEquipement(equipement);
			break;
		default:
			System.out.println("problème dans le nombre d'équipement");
			break;
		}


	}

	private void ajouterEquipement(Equipement equipement) {
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
		tabEquipements[nbEquipement] = equipement;
		nbEquipement++;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);

		System.out.println(minus);
		minus.parler("Bonjour");
		minus.recevoirCoup(5);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}

}
