package bird;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Thomas
 *
 * La classe Control est le contrôleur du modèle MVC. Il définit l'évolution de notre programme.
 * Selon les actions effectuées dans le monde réel, il informe la vue des changements qu'il doit
 * faire.
 */

public class Control implements MouseListener{
	public Etat etat;
	public Affichage affichage;
	
	
	public Control(Etat e, Affichage aff) {
		etat =  e;
		affichage = aff;
	}

	
	/** Quand l'utilisateur clique dans la fenêtre, on recommence un affichage avec l'ovale qui 
	 * effectue la méthode jump, c'est-à-dire que la hauteur de son centre augmente de la valeur
	 * définie dans la classe Etat (ici 10). */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(!affichage.etat.testPerdu()) {
		//	this.affichage.revalidate();
		//	this.affichage.repaint();
			
			int h = this.etat.jump();
			affichage.setOval_Y(h);
		}
        
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}