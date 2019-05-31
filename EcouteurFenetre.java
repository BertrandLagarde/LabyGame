import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EcouteurFenetre implements KeyListener {
    private Fenetre f;
    private Panneau pan;
    private Grid grid;
    private int positionColonneJ1;
    private int positionLigneJ1;
    private int positionColonneJ2;
    private int positionLigneJ2;
    private int positionColonneFinish;
    private int positionLigneFinish;
    private int positionColonneTP1;
    private int positionLigneTP1;
    private int positionColonneTP2;
    private int positionLigneTP2;
    private int positionColonneTP3;
    private int positionLigneTP3;
    private Boolean FlagJ1Tp1;
    private Boolean FlagJ1Tp2;
    private Boolean FlagJ1Tp3;
    private Boolean FlagJ2Tp1;
    private Boolean FlagJ2Tp2;
    private Boolean FlagJ2Tp3;
    private int a;

    // constructeur
    public EcouteurFenetre(Fenetre f, Panneau p, Grid g) {
        this.f = f;
        this.pan = p;
        this.grid = g;
        positionColonneJ1 = 1;
        positionLigneJ1 = 1;
        positionColonneJ2 = 1;
        positionLigneJ2 = grid.getNbLines();
        positionColonneFinish = grid.getNbColumns();
        positionLigneFinish = grid.getNbLines() / 2 + 1;
        positionColonneTP1 = grid.getNbColumns() / 2 + 1;
        positionLigneTP1 = 1;
        positionColonneTP2 = grid.getNbColumns() / 2 + 1;
        positionLigneTP2 = grid.getNbLines() / 2 + 1;
        positionColonneTP3 = grid.getNbColumns() / 2 + 1;
        positionLigneTP3 = grid.getNbLines();
        FlagJ1Tp1 = false;
        FlagJ1Tp2 = false;
        FlagJ1Tp3 = false;
        FlagJ2Tp1 = false;
        FlagJ2Tp2 = false;
        FlagJ2Tp3 = false;
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed" + e.getKeyCode());

        // Pour le J1
        if (e.getKeyCode() == e.VK_LEFT) {
            if (grid.getBox(positionLigneJ1 - 1, positionColonneJ1 - 2).getRight() == false) {
                if (pan.getPos1X() > 40) {
                    pan.setPos1X(pan.getPos1X() - 40);
                    pan.repaint();
                    positionColonneJ1--;
                }
            }
        }
        // Pour le J2
        if (e.getKeyCode() == e.VK_Q) {
            if (grid.getBox(positionLigneJ2 - 1, positionColonneJ2 - 2).getRight() == false) {
                if (pan.getPos2X() > 40) {
                    pan.setPos2X(pan.getPos2X() - 40);
                    pan.repaint();
                    positionColonneJ2--;
                }
            }
        }
        // Pour le J1
        if (e.getKeyCode() == e.VK_RIGHT) {
            if (pan.getPos1X() < 40 + (grid.getNbColumns() - 2) * 40) {
                if (grid.getBox(positionLigneJ1 - 1, positionColonneJ1 - 1).getRight() == false) {
                    pan.setPos1X(pan.getPos1X() + 40);
                    pan.repaint();
                    positionColonneJ1++;
                }
            }
        }
        // Pour le J2
        if (e.getKeyCode() == e.VK_D) {
            if (pan.getPos2X() < 40 + (grid.getNbColumns() - 2) * 40) {
                if (grid.getBox(positionLigneJ2 - 1, positionColonneJ2 - 1).getRight() == false) {
                    pan.setPos2X(pan.getPos2X() + 40);
                    pan.repaint();
                    positionColonneJ2++;
                }
            }
        }
        // Pour le J1
        if (e.getKeyCode() == e.VK_DOWN) {
            if (grid.getBox(positionLigneJ1 - 1, positionColonneJ1 - 1).getDown() == false) {
                if (pan.getPos1Y() < 40 + (grid.getNbLines() - 2) * 40) {
                    pan.setPos1Y(pan.getPos1Y() + 40);
                    pan.repaint();
                    positionLigneJ1++;
                }
            }
        }
        // Pour le J2
        if (e.getKeyCode() == e.VK_S) {
            if (grid.getBox(positionLigneJ2 - 1, positionColonneJ2 - 1).getDown() == false) {
                if (pan.getPos2Y() < 40 + (grid.getNbLines() - 2) * 40) {
                    pan.setPos2Y(pan.getPos2Y() + 40);
                    pan.repaint();
                    positionLigneJ2++;
                }
            }
        }
        // Pour le J1
        if (e.getKeyCode() == e.VK_UP) {
            if (grid.getBox(positionLigneJ1 - 2, positionColonneJ1 - 1).getDown() == false) {
                if (pan.getPos1Y() > 40) {
                    pan.setPos1Y(pan.getPos1Y() - 40);
                    pan.repaint();
                    positionLigneJ1--;
                }
            }
        }
        // Pour le J2
        if (e.getKeyCode() == e.VK_Z) {
            if (grid.getBox(positionLigneJ2 - 2, positionColonneJ2 - 1).getDown() == false) {
                if (pan.getPos2Y() > 40) {
                    pan.setPos2Y(pan.getPos2Y() - 40);
                    pan.repaint();
                    positionLigneJ2--;
                }
            }
        }

        // Condition de victoire
        if (positionLigneJ1 == positionLigneFinish && positionColonneJ1 == positionColonneFinish
                && pan.getWinJ2() == false) {
            pan.setWinJ1(true);
        }
        if (positionLigneJ2 == positionLigneFinish && positionColonneJ2 == positionColonneFinish
                && pan.getWinJ1() == false) {
            pan.setWinJ2(true);
        }

        // Teleporteur 1 J1
        if (positionLigneJ1 == positionLigneTP1 & positionColonneJ1 == positionColonneTP1 && FlagJ1Tp1 == false) {
            FlagJ1Tp1 = true;
            reculer("J2");
        }
        // Teleporteur 2 J1
        if (positionLigneJ1 == positionLigneTP2 && positionColonneJ1 == positionColonneTP2 && FlagJ1Tp2 == false) {
            FlagJ1Tp2 = true;
            reculer("J2");
        }

        // Teleporteur 3 J1
        if (positionLigneJ1 == positionLigneTP3 && positionColonneJ1 == positionColonneTP3 && FlagJ1Tp3 == false) {
            FlagJ1Tp3 = true;
            reculer("J2");
        }
        // Teleporteur 1 J2
        if (positionLigneJ2 == positionLigneTP1 && positionColonneJ2 == positionColonneTP1 && FlagJ2Tp1 == false) {
            FlagJ2Tp1 = true;
            reculer("J1");
        }
        // Teleporteur 2 J2
        if (positionLigneJ2 == positionLigneTP2 && positionColonneJ2 == positionColonneTP2 && FlagJ2Tp2 == false) {
            FlagJ2Tp2 = true;
            reculer("J1");
        }

        // Teleporteur 3 J2
        if (positionLigneJ2 == positionLigneTP3 && positionColonneJ2 == positionColonneTP3 && FlagJ2Tp3 == false) {
            FlagJ2Tp3 = true;
            reculer("J1");
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    // fonction qui fait reculer le joueur à l'arriver sur un TP
    public void reculer(String joueur) {
        if (joueur.contains("J1")) {
            if (positionColonneJ1 < 6) {
                pan.setPos1X(15);
                positionColonneJ1 = 1;
                pan.repaint();
            } else {
                positionColonneJ1 = positionColonneJ1 - 5;
                pan.setPos1X(15 + (positionColonneJ1 - 1) * 40);
                pan.repaint();
            }
        }
        if (joueur.contains("J2")) {
            if (positionColonneJ2 < 6) {
                pan.setPos2X(15);
                positionColonneJ2 = 1;
                pan.repaint();
            } else {
                positionColonneJ2 = positionColonneJ2 - 5;
                pan.setPos2X(15 + (positionColonneJ2 - 1) * 40);
                pan.repaint();
            }
        }
    }
}
