import java.awt.EventQueue;

import com.troisieme.vue.Fenetre;

public class main {
	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		/*
		System.setProperty("apple.laf.useScreenMenuBar", "true");
	    System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Name");
	    */
		//a ne mettre que si apple
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Fenetre frame = new Fenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
