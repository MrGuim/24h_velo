package com.troisieme.model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.troisieme.chrono.Coureur;
import com.troisieme.chrono.Resultat;
import com.troisieme.vue.Fenetre;

public class AjoutCoureur extends JDialog {
  /**
	 * 
	 */
  private static final long serialVersionUID = -6550461413372428429L;
  private Coureur coureur = new Coureur();
  private JLabel nomLabel;
  private JTextField nom;
  private Resultat resultat = new Resultat();
  private static int count = 1;

  public AjoutCoureur(JFrame parent, String title, boolean modal){
    super(parent, title, modal);
    this.setSize(250, 100);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    this.initComponent();
  }

  public Coureur showAjoutCoureur(){
    this.setVisible(true);      
    return this.coureur;      
  }

 
  private void initComponent(){

    //Le nom
    JPanel panNom = new JPanel();
    panNom.setBackground(Color.white);
    panNom.setPreferredSize(new Dimension(220, 60));
    nom = new JTextField();
    nom.setPreferredSize(new Dimension(100, 25));
    nomLabel = new JLabel("Saisir un nom :");
    panNom.add(nomLabel);
    panNom.add(nom);

    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panNom);

    JPanel control = new JPanel();
    JButton okBouton = new JButton("OK");
    
    okBouton.addActionListener(new ActionListener(){
      @Override
	public void actionPerformed(ActionEvent arg0) {        
        coureur = new Coureur((nom.getText()).toUpperCase());
        resultat = new Resultat(coureur);
        Vector<String> resultatV  = resultat.toVector();
        resultatV.add(0, String.valueOf(((DefaultTableModel) (Fenetre.table).getModel()).getRowCount()+1));
        ((DefaultTableModel) (Fenetre.table).getModel()).addRow(resultatV);
        setVisible(false);
      } 
    });

    JButton cancelBouton = new JButton("Annuler");
    cancelBouton.addActionListener(new ActionListener(){
      @Override
	public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }      
    });

    control.add(okBouton);
    control.add(cancelBouton);

    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
  }  
}