package com.troisieme.vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.troisieme.classement.Classement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;

public class StatistiquesCoureurs extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5682371780432962551L;
	private JPanel contentPane;
	private static JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	private JLayeredPane layeredPane;
	private JComboBox<String> comboBox;
	public static Classement classement = new Classement(Fenetre.FILENAME);
	private JButton btnRafraichir;
	private JLabel lblNom;
	private JLabel lblMeilleurTemps;
	private JLabel lblNombreDeTours;
	private JLabel lblTempsMoyen;
	private JLabel lblMoinsBonTemps;
	private JLabel lblNom_1;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	
	public void showStatistiquesCoureurs(){
	    this.setVisible(true);    
	  }
	
	public static JTable getTable(){
		return table;
	}
	
	/**
	 * Create the frame.
	 */
	public StatistiquesCoureurs() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("35ème des Ardents de Saint-Michel");
		setBounds(100, 100, 658, 515);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		classement.updateStats();
		classement.meilleursResultats();
		//tableau des coureurs qui ont fait les meilleurs temps
		table = new JTable();
		table.setModel(new javax.swing.table.DefaultTableModel());
		((DefaultTableModel) table.getModel()).setColumnIdentifiers(new String [] {
                "Nom", "Temps"
            });	
		//on check si on a bien 5 joueurs enregistre si oui on limite a 5 la prise des coureurs
		if(classement.getMeilleursResultats().size()>=5){
    		for(int i = 0; i < 5; i++){
    			Vector<String> vec = new Vector<String>();
    			vec.add(classement.getMeilleursResultats().elementAt(i).getCoureur().getNom());
    			vec.add(classement.getMeilleursResultats().elementAt(i).getTemps().toString());
    			((DefaultTableModel) table.getModel()).addRow(vec);
    		}
		}
		else {
			for(int i = 0; i < classement.getMeilleursResultats().size(); i++){
    			Vector<String> vec = new Vector<String>();
    			vec.add(classement.getMeilleursResultats().elementAt(i).getCoureur().getNom());
    			vec.add(classement.getMeilleursResultats().elementAt(i).getTemps().toString());
    			((DefaultTableModel) table.getModel()).addRow(vec);
    		}
		}
		scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
		//tableau des joueurs qui ont fait le plus de tours
		table_1 = new JTable();
		table_1.setModel(new javax.swing.table.DefaultTableModel());
		((DefaultTableModel) table_1.getModel()).setColumnIdentifiers(new String [] {
                "Nom", "Nombre de tours"
            });	
		//meme principe que pour le tableau des meilleurs temps
		if(classement.getListeCoureursWithStats().size()>=5){
			for(int i = 0; i < 5; i++){
				Vector<String> vec = new Vector<String>();
				Collections.sort(classement.getListeCoureursWithStats());
				vec.add(classement.getListeCoureursWithStats().elementAt(i).getNom());
				vec.add(String.valueOf(classement.getListeCoureursWithStats().elementAt(i).getNbreTours()));
				((DefaultTableModel) table_1.getModel()).addRow(vec);
			}
		}
		else {
			for(int i = 0; i<classement.getListeCoureursWithStats().size(); i++){
				Vector<String> vec = new Vector<String>();
				Collections.sort(classement.getListeCoureursWithStats());
				vec.add(classement.getListeCoureursWithStats().elementAt(i).getNom());
				vec.add(String.valueOf(classement.getListeCoureursWithStats().elementAt(i).getNbreTours()));
				((DefaultTableModel) table_1.getModel()).addRow(vec);
			}
		}
		scrollPane2 = new JScrollPane();
        scrollPane2.setViewportView(table_1);
		
		JLabel lblMeilleursTemps = new JLabel("Meilleurs temps");
		lblMeilleursTemps.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JLabel lblPlusDeTours = new JLabel("Plus de tours");
		lblPlusDeTours.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JLabel lblStatistiquesPersonnelles = new JLabel("Statistiques personnelles");
		lblStatistiquesPersonnelles.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		//le petit combo des stats des joueurs
		comboBox = new JComboBox<String>(classement.listeCoureursToString());
		comboBox.addItemListener(new ItemListener(){
		    @Override
			public void itemStateChanged(ItemEvent e) {
		    	for(int i = 0; i < classement.getListeCoureursWithStats().size(); i++){
		    		if(e.getItem() == classement.getListeCoureursWithStats().get(i).getNom()){
		    			lblNom_1.setText(classement.getListeCoureursWithStats().get(i).getNom());
		    			label_1.setText(classement.getListeCoureursWithStats().get(i).getMeilleurTemps().toString());
		    			label_2.setText(String.valueOf(classement.getListeCoureursWithStats().get(i).getNbreTours()));
		    			label_3.setText(classement.getListeCoureursWithStats().get(i).getTempsMoyen().toString());
		    			label_4.setText(classement.getListeCoureursWithStats().get(i).getPireTemps().toString());
		    		}
		    	}
		    }               
		  });
		
		
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(Color.BLACK, 1, true));
		
		
		/*
		 * je comprends pas d'ou vient l'erreur du fait qu'il faille appuyer deux fois sur rafraichir cette fenetre...
		 * l'erreur vient d'office de cette partie du code mais ou???????? bordel de merde
		 */
		btnRafraichir = new JButton("Rafraichir");
		btnRafraichir.addActionListener(new ActionListener(){
            @Override
			public void actionPerformed(ActionEvent arg0) {
            	comboBox.removeAllItems();
            	for(int i = ((DefaultTableModel) table.getModel()).getRowCount()-1; i >=0 ; i--)
            		((DefaultTableModel) table.getModel()).removeRow(i);
            	for(int i = ((DefaultTableModel) table_1.getModel()).getRowCount()-1; i >=0 ; i--)
            		((DefaultTableModel) table_1.getModel()).removeRow(i);
            	comboBox.updateUI();
            	table.updateUI();
            	table_1.updateUI();
            	classement.updateStats();
            	classement.updateResultat();
            	classement.meilleursResultats();
            	
            	for(int i=0 ; i<classement.getListeCoureurs().size();i++)
            		comboBox.addItem(classement.listeCoureursToString().get(i));
            	comboBox.updateUI();
            	
            	if(classement.getMeilleursResultats().size()>=5){
            		for(int i = 0; i < 5; i++){
            			Vector<String> vec = new Vector<String>();
            			vec.add(classement.getMeilleursResultats().elementAt(i).getCoureur().getNom());
            			vec.add(classement.getMeilleursResultats().elementAt(i).getTemps().toString());
            			((DefaultTableModel) table.getModel()).addRow(vec);
            		}
        		}
        		else {
        			for(int i = 0; i < classement.getMeilleursResultats().size(); i++){
            			Vector<String> vec = new Vector<String>();
            			vec.add(classement.getMeilleursResultats().elementAt(i).getCoureur().getNom());
            			vec.add(classement.getMeilleursResultats().elementAt(i).getTemps().toString());
            			((DefaultTableModel) table.getModel()).addRow(vec);
            		}
        		}
            	
            	
            	table.updateUI();
            	
            	if(classement.getListeCoureursWithStats().size()>=5){
        			for(int i = 0; i < 5; i++){
        				Vector<String> vec = new Vector<String>();
        				Collections.sort(classement.getListeCoureursWithStats());
        				vec.add(classement.getListeCoureursWithStats().elementAt(i).getNom());
        				vec.add(String.valueOf(classement.getListeCoureursWithStats().elementAt(i).getNbreTours()));
        				((DefaultTableModel) table_1.getModel()).addRow(vec);
        			}
        		}
        		else {
        			for(int i = 0; i<classement.getListeCoureursWithStats().size(); i++){
        				Vector<String> vec = new Vector<String>();
        				Collections.sort(classement.getListeCoureursWithStats());
        				vec.add(classement.getListeCoureursWithStats().elementAt(i).getNom());
        				vec.add(String.valueOf(classement.getListeCoureursWithStats().elementAt(i).getNbreTours()));
        				((DefaultTableModel) table_1.getModel()).addRow(vec);
        			}
        		}
            	table_1.updateUI();
            }
		});
		
		//mise en page
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(244)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(61)
									.addComponent(lblMeilleursTemps)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblPlusDeTours)
									.addGap(73))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnRafraichir)
							.addGap(59)
							.addComponent(lblStatistiquesPersonnelles))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(148)
							.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblStatistiquesPersonnelles)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnRafraichir)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMeilleursTemps)
						.addComponent(lblPlusDeTours))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
		);
		//lbl des stats des joueurs
		lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNom.setBounds(24, 9, 61, 16);
		layeredPane.add(lblNom);
		
		lblMeilleurTemps = new JLabel("Meilleur temps :");
		lblMeilleurTemps.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblMeilleurTemps.setBounds(24, 37, 154, 22);
		layeredPane.add(lblMeilleurTemps);
		
		lblNombreDeTours = new JLabel("Nombre de tours :");
		lblNombreDeTours.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNombreDeTours.setBounds(24, 71, 173, 22);
		layeredPane.add(lblNombreDeTours);
		
		lblTempsMoyen = new JLabel("Temps moyen :");
		lblTempsMoyen.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblTempsMoyen.setBounds(24, 105, 154, 22);
		layeredPane.add(lblTempsMoyen);
		
		lblMoinsBonTemps = new JLabel("Moins bon temps :");
		lblMoinsBonTemps.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblMoinsBonTemps.setBounds(24, 139, 173, 22);
		layeredPane.add(lblMoinsBonTemps);
		
		lblNom_1 = new JLabel("Nom");
		lblNom_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNom_1.setBounds(84, 6, 171, 22);
		layeredPane.add(lblNom_1);
		
		label_1 = new JLabel("00 : 00");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_1.setBounds(170, 37, 131, 22);
		layeredPane.add(label_1);
		
		label_2 = new JLabel("00 : 00");
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_2.setBounds(185, 71, 116, 22);
		layeredPane.add(label_2);
		
		label_3 = new JLabel("00 : 00");
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_3.setBounds(160, 105, 141, 22);
		layeredPane.add(label_3);
		
		label_4 = new JLabel("00 : 00");
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_4.setBounds(192, 139, 110, 22);
		layeredPane.add(label_4);
		contentPane.setLayout(gl_contentPane);
	}
}
