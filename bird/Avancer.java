package bird;

import javax.swing.JOptionPane;

public class Avancer extends Thread{
	public Affichage aff;
	
	public Avancer(Affichage affichage) {
		aff = affichage;
	}
	
	
	@Override
	public void run() {
		
		
		while(!aff.etat.testPerdu()) {
			this.aff.repaint();
		    this.aff.etat.getP().setParcours(aff.etat.getParcours());
		    try { Thread.sleep(20); }
	            catch (Exception e) { e.printStackTrace(); }
		
     	 }
		
		   JOptionPane fin = new JOptionPane();
		   String s = "Votre score est de " + aff.etat.getP().getScore();
		   fin.showConfirmDialog(aff, s, "Perdu!", JOptionPane.DEFAULT_OPTION); 
	}

}
