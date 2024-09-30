package personnages;

public class Romain {
	private String nom;
	private int force;

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
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		
		System.out.println(minus);
		minus.parler("Bonjour");
		minus.recevoirCoup(5);
	}

}
