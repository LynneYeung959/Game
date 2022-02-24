import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.event.* ;
class Fenetre extends JFrame implements ListSelectionListener{

	//Boutons
	private JButton combat = new JButton("Combat");
	private JButton soigne = new JButton("Soigne");

	//case à saisir les texts
	private JList<Object> liste1;
	private JList<Object> liste2;



	private JTextField infotype1 = new JTextField();
	private JTextField infoPV1 = new JTextField();
	private JTextField infobattre1 = new JTextField();
	private JTextField infotype2 = new JTextField();
	private JTextField infoPV2 = new JTextField();
	private JTextField infobattre2 = new JTextField();
  	public Fenetre (Desk d1, Desk d2){
  		super();
  		liste1 = new JList<Object>(d1.desk.toArray());
		liste2 = new JList<Object>(d2.desk.toArray());


		setTitle("JEUX"); // on donne un titre à l'application
		setSize(320,400); // on donne une taille à notre fenêtre
		setLocationRelativeTo(null);// on centre la fenêtre sur l'écran
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());


	}

	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		//panel.setLayout(new FlowLayout());
		
		
		panel.add(liste1);
		liste1.addListSelectionListener(this);
		panel.add(combat);
		panel.add(soigne);
		panel.add(liste2);
		liste2.addListSelectionListener(this);

		infotype1.setColumns(20);
		infotype1.setEditable(true);
		panel.add(infotype1);

		infoPV1.setColumns(20);
		infoPV1.setEditable(true);
		panel.add(infoPV1);

		infobattre1.setColumns(20);
		infobattre1.setEditable(true);
		panel.add(infobattre1);

		infotype2.setColumns(20);
		infotype2.setEditable(true);
		panel.add(infotype2);

		infoPV2.setColumns(20);
		infoPV2.setEditable(true);
		panel.add(infoPV2);

		infobattre2.setColumns(20);
		infobattre2.setEditable(true);
		panel.add(infobattre2);

		return panel;
	}

	public void valueChanged (ListSelectionEvent e){
		if(!e.getValueIsAdjusting()){
			//liste gauche
			Personnage p = (Personnage) liste1.getSelectedValue();
			String ch = p.allInfo(); // le rôle et le nom de Personnage 
			infotype1.setText(ch);

			
			String ch1 = "PV : "+p.getVie();
			infoPV1.setText(ch1);

			String type1 = liste1.getSelectedValue().getClass().getSuperclass().getName();
			String ch2 ="";
			if (type1 == "Guerriers"){
				Guerriers g = (Guerriers) liste1.getSelectedValue();
				ch2 = "points d'attaque :"+g.puissanceAttaque;
			}
			if (type1 == "Soigneurs"){
				Soigneurs s = (Soigneurs) liste1.getSelectedValue();
				ch2 = "points de soin :"+s.puissanceSoigner;
			}
			if (type1 == "Paladins"){
				Paladins b = (Paladins) liste1.getSelectedValue();
				ch2 = "points d'attaque/de soin :"+b.puissanceAttaque+"/"+b.puissanceSoigner;
			}
			infobattre1.setText(ch2);
			
			//liste droite
			String sh = liste2.getSelectedValue().getClass().allInfo();
			infotype2.setText(sh);

			Personnage p2 = (Personnage) liste2.getSelectedValue();
			String sh1 = "PV : "+p2.getVie();
			infoPV2.setText(sh1);

			String type2 = liste2.getSelectedValue().getClass().getSuperclass().getName();
			String sh2 ="";
			if (type2 == "Guerriers"){
				Guerriers g = (Guerriers) p2;
				sh2 = "points d'attaque :"+g.puissanceAttaque;
			}
			if (type2 == "Soigneurs"){
				Soigneurs s = (Soigneurs) liste2.getSelectedValue();
				sh2 = "points de soin :"+s.puissanceSoigner;
			}
			if (type2 == "Paladins"){
				Paladins b = (Paladins) liste2.getSelectedValue();
				sh2 = "points d'attaque/de soin :"+b.puissanceAttaque+"/"+b.puissanceSoigner;
			}
			infobattre2.setText(sh2);

			/*
			les opérations pour les bouton Combat et Soigne


			*/
			String carac1 = liste1.getSelectedValue().getClass().getName();
			String carac2 = liste2.getSelectedValue().getClass().getName();


			/*
			pas besoin de implements ActionListener pour la classe
			combat.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					( (Combat) attaquant).attaque(defenseur);
					infoAttaquant.setText(attaquant.showInfo());
					infoDefenseur.setText(defenseur.showInfo());
				}

			}
			);

			pareil pour le bouton soigne
			*/
			combat.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked (MouseEvent ev)
				{
					if ((type1 == "Guerriers")||(type1 == "Paladins")){
						Personnage g1 = (Personnage) liste1.getSelectedValue();
						if ((type2 == "Guerriers")||(type2 == "Paladins")){
							Personnage g2 = (Personnage) liste2.getSelectedValue();
							if ((JButton)ev.getSource() == combat){
								g1.attaquer(g2);
								g2.attaquer(g1);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}else if (type2 == "Soigneurs"){
							Personnage g2 = (Personnage) liste2.getSelectedValue();
							if ((JButton)ev.getSource() == combat){
								g1.attaquer(g2);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}
					} else if ((type2 == "Guerriers") || (type2 == "Paladins")){
						Personnage g2 = (Personnage) liste2.getSelectedValue();
						if ((type1 == "Guerriers")||(type1 == "Paladins")){
							Personnage g1 = (Personnage) liste1.getSelectedValue();
							if ((JButton)ev.getSource() == combat){
								g1.attaquer(g2);
								g2.attaquer(g1);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}else if (type1 == "Soigneurs"){
							Personnage g1 = (Personnage) liste1.getSelectedValue();
							if ((JButton)ev.getSource() == combat){
								g2.attaquer(g1);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}
					}

					/*
					si la personne sélectionnée est un type PERSONNAGE
					*/
					if (carac1 == "Personnage"){
						Personnage g1 = (Personnage) liste1.getSelectedValue();
						if ((carac2 == "Personnage")||(type2 == "Guerriers")||(type2 == "Paladins")){
							Personnage g2 = (Personnage) liste2.getSelectedValue();
							if ((JButton)ev.getSource() == combat){
								g1.attaquer(g2);
								g2.attaquer(g1);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}else if (type2 == "Soigneurs"){
							Personnage g2 = (Personnage) liste2.getSelectedValue();
							if ((JButton)ev.getSource() == combat){
								g1.attaquer(g2);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}
					}
					if (carac2 == "Personnage"){
						Personnage g2 = (Personnage) liste2.getSelectedValue();
						if ((carac1 == "Personnage")||(type1 == "Guerriers")||(type1 == "Paladins")){
							Personnage g1 = (Personnage) liste1.getSelectedValue();
							if ((JButton)ev.getSource() == combat){
								g1.attaquer(g2);
								g2.attaquer(g1);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}else if (type1 == "Soigneurs"){
							Personnage g1 = (Personnage) liste1.getSelectedValue();
							if ((JButton)ev.getSource() == combat){
								g2.attaquer(g1);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}
					}
  				}
			} );

			soigne.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked (MouseEvent ev)
				{
					if ((type1 == "Soigneurs")||(type1 == "Paladins")){
						Personnage g1 = (Personnage) liste1.getSelectedValue();
						if ((type2 == "Soigneurs")||(type2 == "Paladins")){
							Personnage g2 = (Personnage) liste2.getSelectedValue();
							if ((JButton)ev.getSource() == soigne){
								g1.soigner(g2);
								g2.soigner(g1);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}else if (type2 == "Guerriers"){
							Personnage g2 = (Personnage) liste2.getSelectedValue();
							if ((JButton)ev.getSource() == soigne){
								g1.soigner(g2);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}
					} else if ((type2 == "Soigneurs") || (type2 == "Paladins")){
						Personnage g2 = (Personnage) liste2.getSelectedValue();
						if ((type1 == "Soigneurs")||(type1 == "Paladins")){
							Personnage g1 = (Personnage) liste1.getSelectedValue();
							if ((JButton)ev.getSource() == soigne){
								g1.soigner(g2);
								g2.soigner(g1);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}else if (type1 == "Guerriers"){
							Personnage g1 = (Personnage) liste1.getSelectedValue();
							if ((JButton)ev.getSource() == soigne){
								g2.soigner(g1);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}
					}
					if (carac1 == "Personnage"){
						Personnage g1 = (Personnage) liste1.getSelectedValue();
						if ((carac2 == "Personnage")||(type2 == "Soigneurs")||(type2 == "Paladins")){
							Personnage g2 = (Personnage) liste2.getSelectedValue();
							if ((JButton)ev.getSource() == soigne){
								g1.soigner(g2);
								g2.soigner(g1);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}else if (type2 == "Guerriers"){
							Personnage g2 = (Personnage) liste2.getSelectedValue();
							if ((JButton)ev.getSource() == soigne){
								g1.soigner(g2);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}
					}
					if (carac2 == "Personnage"){
						Personnage g2 = (Personnage) liste2.getSelectedValue();
						if ((carac1 == "Personnage") || (type1 == "Soigneurs")||(type1 == "Paladins")){
							Personnage g1 = (Personnage) liste1.getSelectedValue();
							if ((JButton)ev.getSource() == soigne){
								g1.soigner(g2);
								g2.soigner(g1);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}else if (type1 == "Guerriers"){
							Personnage g1 = (Personnage) liste1.getSelectedValue();
							if ((JButton)ev.getSource() == soigne){
								g2.soigner(g1);
								String c = "PV : "+g1.getVie();
								String s = "PV : "+g2.getVie();
								infoPV1.setText(c);
								infoPV2.setText(s);
							}
						}

					}
				}
			} );






		}
	}
















}
