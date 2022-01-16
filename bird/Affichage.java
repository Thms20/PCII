package bird;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author Thomas
 *
 * La classe Affichage correspond � la vue dans le mod�le MVC. 
 * Elle d�crit les formes utilis�es dans l'affichage.
 */

public class Affichage extends JPanel {
	public Etat etat = new Etat(this);
	
	public static final int largeur_panel = 800; /** Largeur du panel */
    public static final int hauteur_panel = 500; /** Hauteur du panel */
    
    public static int OVAL_X = 200;
    public static int OVAL_Y = 200;
    public static final int OVAL_WIDTH = 50;  /** Largeur de l'oval */
    public static final int OVAL_HEIGHT = 100; /** Hauteur de l'oval */
    
    
    public Affichage() {
    	this.setPreferredSize(new Dimension(largeur_panel, hauteur_panel));
    }
    
    
    /** 
     * Affichage d'un ovale
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(OVAL_X, OVAL_Y, OVAL_WIDTH, OVAL_HEIGHT);
    }
    
    /** Permet de changer la valeur centrale en ordonn�e de l'oval de l'affichage */
    public void setOval_Y(int x) {
    	OVAL_Y = x;
    }
    
    /** @return la largeur de notre panel */
    public int getLargeurPanel() {
    	return largeur_panel;
    }
    
    /** @return la hauteur de notre panel */
    public int getHauteurPanel() {
    	return hauteur_panel;
    }

}
