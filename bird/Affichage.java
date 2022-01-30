package bird;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * @author Thomas
 *
 * La classe Affichage correspond à la vue dans le modèle MVC. 
 * Elle décrit les formes utilisées dans l'affichage.
 */

public class Affichage extends JPanel {	
	public static final int largeur_panel = 800; /** Largeur du panel */
    public static final int hauteur_panel = 500; /** Hauteur du panel */
    
    public static int OVAL_X = 50;
    public static int OVAL_Y = 200;
    public static final int OVAL_WIDTH = 50;  /** Largeur de l'oval */
    public static final int OVAL_HEIGHT = 100; /** Hauteur de l'oval */
    
    public Etat etat = new Etat(this);
    
    
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

        for(int i = 0; i < etat.getP().getPoints().size()-1; i++) {
        	Point p1 = etat.getP().getPoints().get(i);
        	Point p2 = etat.getP().getPoints().get(i + 1);
        	g.setColor(Color.RED);
        	g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

    }
    
    /** Permet de changer la valeur centrale en ordonnée de l'oval de l'affichage */
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