package com.troisieme.vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import com.troisieme.chrono.Coureur;
import com.troisieme.chrono.Resultat;
import com.troisieme.chrono.Temps;
import com.troisieme.classement.Classement;
import com.troisieme.model.AjoutCoureur;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JLayeredPane;
import java.awt.Color;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 352804715383710710L;
	private JPanel contentPane;
	public static JTable table;
	private JScrollPane scrollPane;
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu options = new JMenu("Options"),
		    aProposMenu = new JMenu("À propos");
	private JMenuItem statJoueur = new JMenuItem("Statistiques joueurs"),
		    chronoTroupe = new JMenuItem("Chrono des autres troupes"),
		    aProposItem = new JMenuItem("?");
	
	
	private JLabel hourLabel = new JLabel("24");
	private JLabel minLabel = new JLabel("00");
	private JLabel secLabel = new JLabel("00");
	private JLabel label_2 = new JLabel("00");
	private JLabel label_4 = new JLabel("00");
	private Timer timer;
	private Timer chrono;
	private int secChrono = 0;
	private int minChrono = 0;
	private int secTimer = 0;
	private int minTimer = 0;
	private int hourTimer = 24;
	private PrintWriter outFile;
	public final static String FILENAME = "DonneesCoureurs.txt";
	private AjoutCoureur ac = new AjoutCoureur(null, "Ajouter un coureur", true);
	
	ChronoTroupes chronoTroupes = new ChronoTroupes();
	StatistiquesCoureurs statCoureurs = new StatistiquesCoureurs();
	APropos aPropos = new APropos();
	

	/**
	 * Create the frame.
	 */
	public Fenetre() {
		try{
		outFile = new PrintWriter(new FileWriter(FILENAME));
		} catch(Exception e) {
			e.printStackTrace();
		};
		setTitle("35ème des Ardents de Saint-Michel");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 709, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		statJoueur.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		
		//creation de la bar de menu
		//on la garde ???
		options.add(statJoueur);
		chronoTroupe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		options.add(chronoTroupe);
		aProposItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		
		aProposMenu.add(aProposItem);
		
		menuBar.add(options);
		menuBar.add(aProposMenu);
		
		this.setJMenuBar(menuBar);
		
		statJoueur.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  statCoureurs.showStatistiquesCoureurs();
		      }
		    });
		
		chronoTroupe.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  chronoTroupes.showChronoTroupes();
		      }
		    });
		
		aProposItem.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	  aPropos.showAPropos();
		      }
		    });
		
		
		
		/*aProposMenu.addMenuListener(new MenuListener(){
		      public void menuSelected(MenuEvent event){
		    	  aPropos.showAPropos();
		      }
		      public void menuCanceled(MenuEvent event){
		    	  
		      }
		      public void menuDeselected(MenuEvent event) {
		         
		      }
		    });*/
		//petit bouton start du debut
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                	timer.start();
                	chrono.start();
                btnStart.setEnabled(false);
            }
        });
		//chrono perso de la troupe
		chrono = new Timer(1000, new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
    			if (secChrono == 60) {
    				secChrono = 0;
    				minChrono++;
    			}
    			secChrono++;
    			if(secChrono == 60) {
    				if(minChrono<10)
        				label_2.setText("0"+String.valueOf(minChrono+1));
        			else
        				label_2.setText(String.valueOf(minChrono+1));
    				label_4.setText("00");
    			}
    			else {
    			if(minChrono<10)
    				label_2.setText("0"+String.valueOf(minChrono));
    			else
    				label_2.setText(String.valueOf(minChrono));
    			if(secChrono<10)
    				label_4.setText("0"+String.valueOf(secChrono));
    			else
    				label_4.setText(String.valueOf(secChrono));
            }
            }
        });
		
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(btnPause.getText() == "Pause"){
            		chrono.stop();
            		btnPause.setText("Resume");
            	}
            	else{
            		chrono.start();
            		btnPause.setText("Pause");
            	}
            }
        });
		
		
		//timer total du temps restant
		timer = new Timer(1000, new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	if(hourTimer!=0){
            	if(minTimer == 0 ){
            		minTimer = 60;
            		hourTimer--;
            	}}
    			if (secTimer == 0) {
    				secTimer = 60;
    				minTimer--;
    			}
    			secTimer--;
    			if(secTimer==0&&minTimer==0&&hourTimer==0){
    				timer.stop();
    				chrono.stop();
    				JOptionPane jop = new JOptionPane();
    		        JOptionPane.showMessageDialog(null, "La course est finie!", "Information course", JOptionPane.INFORMATION_MESSAGE);
    			}
    			if(hourTimer<10)
    				hourLabel.setText("0"+String.valueOf(hourTimer));
    			else
    				hourLabel.setText(String.valueOf(hourTimer));
    			if(minTimer<10)
    				minLabel.setText("0"+String.valueOf(minTimer));
    			else
    				minLabel.setText(String.valueOf(minTimer));
    			if(secTimer<10)
    				secLabel.setText("0"+String.valueOf(secTimer));
    			else
    				secLabel.setText(String.valueOf(secTimer));
            }
        });
		//on balance tous les labels et les boutons
		JLabel lblTempsRestant = new JLabel("Temps restant");
		lblTempsRestant.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		JLabel label = new JLabel();
		label.setText(" : ");
		label.setFont(new Font("Lucida Grande", Font.BOLD, 48));
		
		table = new JTable();
		table.setModel(new javax.swing.table.DefaultTableModel());
		((DefaultTableModel) table.getModel()).setColumnIdentifiers(new String [] {
                "N° du tour", "Nom", "Temps"
            });
			scrollPane = new JScrollPane();
	        scrollPane.setViewportView(table);
		
		JLabel lblDerniersTemps = new JLabel("Derniers temps");
		lblDerniersTemps.setHorizontalAlignment(SwingConstants.CENTER);
		lblDerniersTemps.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JButton btnAjouterRouleur = new JButton("Ajouter rouleur");
		btnAjouterRouleur.addActionListener(new ActionListener(){
            @Override
			public void actionPerformed(ActionEvent arg0) {
              ac = new AjoutCoureur(null, "Ajouter un coureur", true);
              ac.showAjoutCoureur();
            }         
          });      
		//tour fini
		JButton btnTourFini = new JButton("Tour fini");
		btnTourFini.addActionListener(new ActionListener(){
            @Override
			public void actionPerformed(ActionEvent arg0) {
            	//on stop le chrono
            	chrono.stop();
            	//remise a zero des labels (esthetique)
            	label_2.setText("00");
            	label_4.setText("00");
            	boolean flag = false;
            	int count=0;;
            	//parcourt de tableau pour trouver le dernier resultat qui n a pas de temps
            	//je sais bien que ca prend du temps et qu'on perd en fluidite mais je sais pas faire autrement avec mes connaissances actuels
            	Temps temps = new Temps(0,minChrono,secChrono);
            	for(int i=0;i<=((DefaultTableModel) table.getModel()).getRowCount()&&!flag;i++){
            	if(((DefaultTableModel) table.getModel()).getValueAt(i, 2)==null){
            		((DefaultTableModel) table.getModel()).setValueAt(temps.toString(), i, 2);
            		flag=true;
            		//savoir ou on est dans le tableau
            		count = i;
            		}
            	}
            	minChrono = 0;
            	secChrono = 0;
            	chrono.start();
            	//cree un coureur pour le mettre dans notre petit fichier txt qui sauve tout <3
            	Coureur coureur = new Coureur((String)((DefaultTableModel) table.getModel()).getValueAt(count, 1));
            	Resultat resultat = new Resultat(coureur, temps);
            	outFile.println(resultat.toString());
            	outFile.flush();
            }
		});
		
		//pour les bg qui font deux tours
		JButton btnSecondTour = new JButton("Tour supplémentaire");
		btnSecondTour.addActionListener(new ActionListener(){
            @Override
			public void actionPerformed(ActionEvent arg0) {
            	//debut du code est le meme que pour tour fini
            	chrono.stop();
            	label_2.setText("00");
            	label_4.setText("00");
            	boolean flag = false;
            	int count= 0;
            	Temps temps = new Temps(0,minChrono,secChrono);
            	for(int i=0;i<=((DefaultTableModel) table.getModel()).getRowCount()&&!flag;i++){
            	if(((DefaultTableModel) table.getModel()).getValueAt(i, 2)==null){
            		((DefaultTableModel) table.getModel()).setValueAt(temps.toString(), i, 2);
            		flag=true;
            		count = i;
            		}
            	}
            	//on recup le numero du tour
            	for(int i = count+1; i<((DefaultTableModel) table.getModel()).getRowCount();i++)
            		((DefaultTableModel) table.getModel()).setValueAt(String.valueOf(((Integer.parseInt((String)((DefaultTableModel) table.getModel()).getValueAt(i, 0)))+1)), i, 0);
            	minChrono = 0;
            	secChrono = 0;
            	chrono.start();
            	Coureur coureur = new Coureur((String)((DefaultTableModel) table.getModel()).getValueAt(count, 1));
                Resultat resultat = new Resultat(coureur);
                Vector<String> resultatV  = resultat.toVector();
                resultatV.add(0, String.valueOf(count+2));
                //on rejoute une row dans le tableau a notre count+1 et on inscrit le coureur dans le fichier txt
            	((DefaultTableModel) table.getModel()).insertRow(count+1, resultatV);
            	Resultat resultat2 = new Resultat(coureur, temps);
            	outFile.println(resultat2.toString());
            	outFile.flush();
            }
		});
		hourLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Chrono actuel lbl
		hourLabel.setFont(new Font("Lucida Grande", Font.BOLD, 48));
		minLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		minLabel.setFont(new Font("Lucida Grande", Font.BOLD, 48));
		
		JLabel label_1 = new JLabel();
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setText(" : ");
		label_1.setFont(new Font("Lucida Grande", Font.BOLD, 48));
		secLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		secLabel.setFont(new Font("Lucida Grande", Font.BOLD, 48));
		
		JLabel lblChronoActuel = new JLabel("Chrono actuel");
		lblChronoActuel.setHorizontalAlignment(SwingConstants.CENTER);
		lblChronoActuel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		label_2.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_3 = new JLabel(":");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Lucida Grande", Font.BOLD, 40));

		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		
		Classement classement = new Classement(Fenetre.FILENAME);
		
		//et on met en page youpiiiie
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnTourFini)
								.addComponent(btnAjouterRouleur)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
											.addGap(68))
										.addComponent(btnSecondTour)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(89)
							.addComponent(lblChronoActuel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(98)
							.addComponent(btnPause, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDerniersTemps, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(secLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(10, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(170)
					.addComponent(hourLabel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTempsRestant)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(minLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
								.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
							.addGap(345))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTempsRestant)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(label)
							.addComponent(hourLabel))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(minLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addComponent(secLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStart)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblChronoActuel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_2)))
								.addComponent(lblDerniersTemps, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPause)
							.addGap(53)
							.addComponent(btnAjouterRouleur)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnTourFini)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSecondTour)))
					.addGap(35))
		);
		contentPane.setLayout(gl_contentPane);
	}	
}
