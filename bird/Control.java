package bird;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Thomas
 *
 * La classe Control est le contr�leur du mod�le MVC. Il d�finit l'�volution de notre programme.
 * Selon les actions effectu�es dans le monde r�el, il informe la vue des changements qu'il doit
 * faire.
 */

public class Control implements MouseListener{
	public Etat etat;
	public Affichage affichage;
	
	
	public Control(Etat e, Affichage aff) {
		etat =  e;
		affichage = aff;
	}

	
	/** Quand l'utilisateur clique dans la fen�tre, on recommence un affichage avec l'ovale qui 
	 * effectue la m�thode jump, c'est-�-dire que la hauteur de son centre augmente de la valeur
	 * d�finie dans la classe Etat (ici 10). */
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