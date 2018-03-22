package com.troisieme.vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.troisieme.chrono.Temps;
import com.troisieme.classement.Classement;
import com.troisieme.vue.Fenetre;


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
import java.util.concurrent.TimeUnit;

import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class PelotonFenetre extends JFrame{
	private JTable table;
	private Timer chrono;
	private int secChrono = 0;
	private int minChrono = 0;
	private int count = 0;
	private JScrollPane scrollPane_1;
	private Classement classm = new Classement(Fenetre.FILENAME);
	
	public void showPeloton(){
	    this.setVisible(true);    
	  }
	
	public void putTemps() {
		boolean flag = false;
		Temps t1 = new Temps(0, minChrono, secChrono);
		for (int i = 0; i <= ((DefaultTableModel) table.getModel()).getRowCount() && !flag; i++) {
			if ((((DefaultTableModel) table.getModel()).getValueAt(i, 1)).equals("Temps en attente")) {
				((DefaultTableModel) table.getModel()).setValueAt("-"+t1.toString(), i, 1);
				flag = true;
			}
		}
	}
	
	public PelotonFenetre() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("35ème des Ardents de Saint-Michel");
		setBounds(100, 100, 534, 431);
		setResizable(false);
		
		JLabel lblTempsDuPeloton = new JLabel("Temps du peloton");
		lblTempsDuPeloton.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTempsDuPeloton.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempsDuPeloton.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JLabel label_1 = new JLabel("00");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JLabel label_2 = new JLabel("00");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JLabel label_3 = new JLabel(":");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JButton btnRinitialiserLePeloton = new JButton("Réinitialiser le peloton");
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new javax.swing.table.DefaultTableModel());
		((DefaultTableModel) table.getModel()).setColumnIdentifiers(new String[] { "Temps du peloton", "Différence de temps" });
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportView(table);
		
		chrono = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (secChrono == 60) {
					secChrono = 0;
					minChrono++;
				}
				secChrono++;
				if (secChrono == 60) {
					if (minChrono < 10)
						label_1.setText("0" + String.valueOf(minChrono + 1));
					else
						label_1.setText(String.valueOf(minChrono + 1));
					label_2.setText("00");
				} else {
					if (minChrono < 10)
						label_1.setText("0" + String.valueOf(minChrono));
					else
						label_1.setText(String.valueOf(minChrono));
					if (secChrono < 10)
						label_2.setText("0" + String.valueOf(secChrono));
					else
						label_2.setText(String.valueOf(secChrono));
				}
			}
		});
		
		JButton btnChrono = new JButton("Start");
		btnChrono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnChrono.getText() == "Passage") {
					// on stop le chrono
					chrono.stop();
					// remise a zero des labels (esthetique)
					label_1.setText("00");
					label_2.setText("00");
					Temps temps = new Temps(0, minChrono, secChrono);
					Vector<String> vec = new Vector<String>();
	    				vec.add(temps.toString());
	    				classm.updateResultat();
	    				classm.updateStats();
	    				minChrono = 0;
	    				secChrono = 0;
	    				chrono.start();
	    				int tempsMoyen = 0;
	    				for(int i = 0; i < classm.getListeCoureursWithStats().size(); i++){
		    		    		if(Fenetre.currentRouleur.equals(classm.getListeCoureursWithStats().get(i).getNom())){
		    		    			tempsMoyen = classm.getListeCoureursWithStats().get(i).getTempsMoyen().secondes();
		    		    		}
		    		    	}
	    				Temps t = new Temps(0, Fenetre.minG, Fenetre.secG);
	    				if(t.secondes()<= (tempsMoyen/2))
	    					vec.add("+"+t.toString());
	    				else
	    					Fenetre.flagPeloton = true;
	    					vec.add("Temps en attente");
	    				((DefaultTableModel) table.getModel()).addRow(vec);
					count++;
				}
				if (btnChrono.getText() == "Start") {
					chrono.start();
					btnChrono.setText("Passage");
				}
					
			}
		});
		
		btnRinitialiserLePeloton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				chrono.stop();
				label_1.setText("00");
				label_2.setText("00");
				minChrono = 0;
				secChrono = 0;
				btnChrono.setText("Start");
				for(int i = ((DefaultTableModel) table.getModel()).getRowCount()-1; i >=0 ; i--)
            			((DefaultTableModel) table.getModel()).removeRow(i);
				
			}
		});
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTempsDuPeloton, GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnChrono, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
							.addGap(59)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(172)
							.addComponent(btnRinitialiserLePeloton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblTempsDuPeloton)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(68)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnChrono))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(btnRinitialiserLePeloton)
					.addGap(15))
		);
		
		
		
		getContentPane().setLayout(groupLayout);
	}
}
