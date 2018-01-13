package com.troisieme.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.troisieme.time.ChronoAutre;
import com.troisieme.time.ChronoBossut;
import com.troisieme.time.ChronoDragon;
import com.troisieme.time.ChronoHibou;
import com.troisieme.time.ChronoLinkebeek;
import com.troisieme.time.ChronoStAnne;
import com.troisieme.time.ChronoStMarc;
import com.troisieme.time.ChronoTison;
import com.troisieme.time.ChronoVND;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class ChronoTroupes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -361323441845320718L;
	private JPanel contentPane;
	public static JLabel labelTisonMin = new JLabel("00");
	public static JLabel labelTisonSec = new JLabel("00");
	public static JLabel labelDragonMin = new JLabel("00");
	public static JLabel labelDragonSec = new JLabel("00");
	public static JLabel labelVNDMin = new JLabel("00");
	public static JLabel labelVNDSec = new JLabel("00");
	public static JLabel labelHibouMin = new JLabel("00");
	public static JLabel labelHibouSec = new JLabel("00");
	public static JLabel labelBossutMin = new JLabel("00");
	public static JLabel labelBossutSec = new JLabel("00");
	public static JLabel labelStMarcMin = new JLabel("00");
	public static JLabel labelStMarcSec = new JLabel("00");
	public static JLabel labelStAnneMin = new JLabel("00");
	public static JLabel labelStAnneSec = new JLabel("00");
	public static JLabel labelLinkebeekMin = new JLabel("00");
	public static JLabel labelLinkebeekSec = new JLabel("00");
	public static JLabel labelAutreMin = new JLabel("00");
	public static JLabel labelAutreSec = new JLabel("00");
	private JButton btnStartTison = new JButton("Start");
	private JButton btnStartDragon = new JButton("Start");
	private JButton btnStartVND = new JButton("Start");
	private JButton btnStartHibou = new JButton("Start");
	private JButton btnStartBossut = new JButton("Start");
	private JButton btnStartStMarc = new JButton("Start");
	private JButton btnStartStAnne = new JButton("Start");
	private JButton btnStartLinkebeek = new JButton("Start");
	private JButton btnStartAutre = new JButton("Start");
	private ChronoTison chronoTison;
	private ChronoDragon chronoDragon;
	private ChronoHibou chronoHibou;
	private ChronoVND chronoVND;
	private ChronoBossut chronoBossut;
	private ChronoStMarc chronoStMarc;
	private ChronoStAnne chronoStAnne;
	private ChronoLinkebeek chronoLinkebeek;
	
	public void showChronoTroupes(){
		this.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public ChronoTroupes() {
		setTitle("35ème des Ardents de Saint-Michel");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 582, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		chronoTison = new ChronoTison();
		chronoDragon = new ChronoDragon();
		chronoVND = new ChronoVND();
		chronoHibou = new ChronoHibou();
		chronoBossut = new ChronoBossut();
		chronoStMarc = new ChronoStMarc();
		chronoStAnne = new ChronoStAnne();
		chronoLinkebeek = new ChronoLinkebeek();
		ChronoAutre chronoAutre = new ChronoAutre();
		
		JLabel lblTison = new JLabel("Tison");
		lblTison.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		
		
		labelTisonMin.setHorizontalAlignment(SwingConstants.CENTER);
		labelTisonMin.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JLabel label_1 = new JLabel(":");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		
		labelTisonSec.setHorizontalAlignment(SwingConstants.CENTER);
		labelTisonSec.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		btnStartTison.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(btnStartTison.getText() == "Start"){
            		chronoTison.start();
            		btnStartTison.setText("Stop");
            	}
            	else{
            		chronoTison.stop();
            		btnStartTison.setText("Start");
            	}
            }
        });
		
		JButton btnStopTison = new JButton("RAZ");
		btnStopTison.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                			chronoTison.stop();
                			chronoTison.raz();
                			labelTisonMin.setText("00");
                			labelTisonSec.setText("00");
                			btnStartTison.setText("Start");
            }
        });
		
		
		labelDragonMin.setHorizontalAlignment(SwingConstants.CENTER);
		labelDragonMin.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JLabel label_4 = new JLabel(":");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		labelDragonSec.setHorizontalAlignment(SwingConstants.CENTER);
		labelDragonSec.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		
		btnStartDragon.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(btnStartDragon.getText() == "Start"){
            		chronoDragon.start();
            		btnStartDragon.setText("Stop");
            	}
            	else{
            		chronoDragon.stop();
            		btnStartDragon.setText("Start");
            	}
            }
        });
		
		JButton btnStopDragon = new JButton("RAZ");
		btnStopDragon.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                			chronoDragon.stop();
                			chronoDragon.raz();
                			labelDragonMin.setText("00");
                			labelDragonSec.setText("00");
                			btnStartDragon.setText("Start");
            }
        });
		
		JLabel lblDragon = new JLabel("Dragon");
		lblDragon.setHorizontalAlignment(SwingConstants.CENTER);
		lblDragon.setFont(new Font("Lucida Grande", Font.BOLD, 28));
			
		labelVNDMin.setHorizontalAlignment(SwingConstants.CENTER);
		labelVNDMin.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JLabel label_8 = new JLabel(":");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		labelVNDSec.setHorizontalAlignment(SwingConstants.CENTER);
		labelVNDSec.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		btnStartVND.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(btnStartVND.getText() == "Start"){
            		chronoVND.start();
            		btnStartVND.setText("Stop");
            	}
            	else{
            		chronoVND.stop();
            		btnStartVND.setText("Start");
            	}
            }
        });
		
		JButton btnStopVND = new JButton("RAZ");
		btnStopVND.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                			chronoVND.stop();
                			chronoVND.raz();
                			labelVNDMin.setText("00");
                			labelVNDSec.setText("00");
                			btnStartVND.setText("Start");
            }
        });
		
		JLabel lblVnd = new JLabel("Santiano");
		lblVnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblVnd.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		
		labelHibouMin.setHorizontalAlignment(SwingConstants.CENTER);
		labelHibouMin.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JLabel label_12 = new JLabel(":");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		labelHibouSec.setHorizontalAlignment(SwingConstants.CENTER);
		labelHibouSec.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		labelBossutMin.setHorizontalAlignment(SwingConstants.CENTER);
		labelBossutMin.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JLabel label_15 = new JLabel(":");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("Lucida Grande", Font.BOLD, 24));

		labelBossutSec.setHorizontalAlignment(SwingConstants.CENTER);
		labelBossutSec.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		btnStartBossut.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(btnStartBossut.getText() == "Start"){
            		chronoBossut.start();
            		btnStartBossut.setText("Stop");
            	}
            	else{
            		chronoBossut.stop();
            		btnStartBossut.setText("Start");
            	}
            }
        });
		
		JButton btnStopBossut = new JButton("RAZ");
		btnStopBossut.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                			chronoBossut.stop();
                			chronoBossut.raz();
                			labelBossutMin.setText("00");
                			labelBossutSec.setText("00");
                			btnStartBossut.setText("Start");
            }
        });
		
		labelStMarcMin.setHorizontalAlignment(SwingConstants.CENTER);
		labelStMarcMin.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JLabel label_18 = new JLabel(":");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		btnStartStMarc.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(btnStartStMarc.getText() == "Start"){
            		chronoStMarc.start();
            		btnStartStMarc.setText("Stop");
            	}
            	else{
            		chronoStMarc.stop();
            		btnStartStMarc.setText("Start");
            	}
            }
        });
		
		JLabel lblHibou = new JLabel("Hibou");
		lblHibou.setHorizontalAlignment(SwingConstants.CENTER);
		lblHibou.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		
		JLabel lblBossut = new JLabel("Edelweis");
		lblBossut.setHorizontalAlignment(SwingConstants.CENTER);
		lblBossut.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		
		JButton btnStopStMarc = new JButton("RAZ");
		btnStopStMarc.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                			chronoStMarc.stop();
                			chronoStMarc.raz();
                			labelStMarcMin.setText("00");
                			labelStMarcSec.setText("00");
                			btnStartStMarc.setText("Start");
            }
        });
		
		labelStMarcSec.setHorizontalAlignment(SwingConstants.CENTER);
		labelStMarcSec.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JLabel lblStmarx = new JLabel("St-Marc");
		lblStmarx.setHorizontalAlignment(SwingConstants.CENTER);
		lblStmarx.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		
		btnStartHibou.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(btnStartHibou.getText() == "Start"){
            		chronoHibou.start();
            		btnStartHibou.setText("Stop");
            	}
            	else{
            		chronoHibou.stop();
            		btnStartHibou.setText("Start");
            	}
            }
        });
		
		JButton btnStopHibou = new JButton("RAZ");
		btnStopHibou.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                			chronoHibou.stop();
                			chronoHibou.raz();
                			labelHibouMin.setText("00");
                			labelHibouSec.setText("00");
                			btnStartHibou.setText("Start");
            }
        });
		
		labelStAnneMin.setHorizontalAlignment(SwingConstants.CENTER);
		labelStAnneMin.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JLabel label_24 = new JLabel(":");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		labelStAnneSec.setHorizontalAlignment(SwingConstants.CENTER);
		labelStAnneSec.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		btnStartStAnne.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(btnStartStAnne.getText() == "Start"){
            		chronoStAnne.start();
            		btnStartStAnne.setText("Stop");
            	}
            	else{
            		chronoStAnne.stop();
            		btnStartStAnne.setText("Start");
            	}
            }
        });
		
		JButton btnStopStAnne = new JButton("RAZ");
		btnStopStAnne.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                			chronoStAnne.stop();
                			chronoStAnne.raz();
                			labelStAnneMin.setText("00");
                			labelStAnneSec.setText("00");
                			btnStartStAnne.setText("Start");
            }
        });
		
		JLabel lblStanne = new JLabel("St-Anne");
		lblStanne.setHorizontalAlignment(SwingConstants.CENTER);
		lblStanne.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		
		JLabel lblLinkebeek = new JLabel("Linkebeek");
		lblLinkebeek.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		
		labelLinkebeekMin.setHorizontalAlignment(SwingConstants.CENTER);
		labelLinkebeekMin.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JLabel label_29 = new JLabel(":");
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		labelLinkebeekSec.setHorizontalAlignment(SwingConstants.CENTER);
		labelLinkebeekSec.setFont(new Font("Lucida Grande", Font.BOLD, 24));

		btnStartLinkebeek.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(btnStartLinkebeek.getText() == "Start"){
            		chronoLinkebeek.start();
            		btnStartLinkebeek.setText("Stop");
            	}
            	else{
            		chronoLinkebeek.stop();
            		btnStartLinkebeek.setText("Start");
            	}
            }
        });
		
		JButton btnStopLinkebeek = new JButton("RAZ");
		btnStopLinkebeek.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                			chronoLinkebeek.stop();
                			chronoLinkebeek.raz();
                			labelLinkebeekMin.setText("00");
                			labelLinkebeekSec.setText("00");
                			btnStartLinkebeek.setText("Start");
            }
        });
		
		JLabel lblAutre = new JLabel("Autre");
		lblAutre.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutre.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		
		labelAutreMin.setHorizontalAlignment(SwingConstants.CENTER);
		labelAutreMin.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		JLabel label_33 = new JLabel(":");
		label_33.setHorizontalAlignment(SwingConstants.CENTER);
		label_33.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		labelAutreSec.setHorizontalAlignment(SwingConstants.CENTER);
		labelAutreSec.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		
		btnStartAutre.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(btnStartAutre.getText() == "Start"){
            		chronoAutre.start();
            		btnStartAutre.setText("Stop");
            	}
            	else{
            		chronoAutre.stop();
            		btnStartAutre.setText("Start");
            	}
            }
        });
		
		JButton btnStopAutre = new JButton("RAZ");
		btnStopAutre.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                			chronoAutre.stop();
                			chronoAutre.raz();
                			labelAutreMin.setText("00");
                			labelAutreSec.setText("00");
                			btnStartAutre.setText("Start");
            }
        });
		
		JLabel lblChronoDesAutres = new JLabel("Chrono des autres troupes");
		lblChronoDesAutres.setHorizontalAlignment(SwingConstants.CENTER);
		lblChronoDesAutres.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblChronoDesAutres, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(73)
									.addComponent(btnStopStAnne, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnStartStAnne, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnStartLinkebeek, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(73)
									.addComponent(btnStopLinkebeek, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
							.addGap(53)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnStartAutre, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(73)
									.addComponent(btnStopAutre, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnStartHibou, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(73)
									.addComponent(btnStopHibou, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(23)
									.addComponent(labelStAnneMin, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(label_24, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(labelStAnneSec, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addComponent(lblStanne, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(73)
											.addComponent(btnStopBossut, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnStartBossut, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
									.addGap(53)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnStartStMarc, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(73)
											.addComponent(btnStopStMarc, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(23)
											.addComponent(labelLinkebeekMin, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(label_29, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(labelLinkebeekSec, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblLinkebeek))
									.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(labelAutreMin, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(label_33, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(labelAutreSec, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(23))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblAutre, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
											.addGap(13))))))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(23)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(labelHibouMin, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(labelHibouSec, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblHibou, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(66)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(labelBossutMin, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(labelBossutSec, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(25))
										.addComponent(lblBossut, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(23)
											.addComponent(labelTisonMin, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(labelTisonSec, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(31))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(73)
											.addComponent(btnStopTison))
										.addComponent(btnStartTison)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(34)
											.addComponent(lblTison)
											.addGap(40)))
									.addGap(49)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnStartDragon, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(73)
											.addComponent(btnStopDragon, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblDragon)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(labelDragonMin, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
													.addGap(6)
													.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
													.addGap(6)
													.addComponent(labelDragonSec, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))))))
							.addGap(53)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(23)
										.addComponent(labelVNDMin, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(labelVNDSec, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(73)
										.addComponent(btnStopVND, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
									.addComponent(btnStartVND, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblVnd, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(labelStMarcMin, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(label_18, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(labelStMarcSec, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(14))
										.addComponent(lblStmarx, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
									.addGap(11)))))
					.addGap(14))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChronoDesAutres)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblVnd, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(labelVNDMin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelVNDSec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGap(6)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(btnStopVND)
									.addComponent(btnStartVND)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblTison)
									.addComponent(lblDragon, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelTisonSec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelTisonMin))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnStartTison)
									.addComponent(btnStopTison))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(labelDragonMin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelDragonSec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnStartDragon)
								.addComponent(btnStopDragon))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHibou, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblStmarx, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblBossut, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(labelHibouMin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelHibouSec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelBossutMin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelBossutSec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelStMarcMin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_18, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelStMarcSec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStartHibou)
						.addComponent(btnStopHibou)
						.addComponent(btnStopBossut)
						.addComponent(btnStartBossut)
						.addComponent(btnStartStMarc)
						.addComponent(btnStopStMarc))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLinkebeek, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStanne, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(labelStAnneMin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_24, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelStAnneSec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelLinkebeekMin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_29, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelLinkebeekSec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAutre, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(labelAutreMin, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_33, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelAutreSec, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStopStAnne)
						.addComponent(btnStartStAnne)
						.addComponent(btnStartLinkebeek)
						.addComponent(btnStopLinkebeek)
						.addComponent(btnStartAutre)
						.addComponent(btnStopAutre))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
