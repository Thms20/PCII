
public class Avancer extends Thread{
	public Affichage aff;
	
	public Avancer(Affichage affichage) {
		aff = affichage;
	}
	
	
	@Override
	public void run() {
		
		
		while(true) {
		this.aff.repaint();
		this.aff.etat.getP().setParcours(aff.etat.getParcours());
		try { Thread.sleep(20); }
	       catch (Exception e) { e.printStackTrace(); }
		
     	}
	}

}
