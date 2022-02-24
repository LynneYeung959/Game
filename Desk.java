import java.util.ArrayList;
import java.util.*;
import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.event.* ;

public class Desk{

	protected ArrayList<Personnage> desk = new ArrayList<Personnage>();
	//protected JList<Object> liste = new JList<Object>(desk.toArray());

	
	public Desk(Personnage p){
		desk.add(p);
		//liste.setListData(desk.toArray());
	}

	public void addObjet(Personnage objet){
		desk.add(objet);
		//liste.setListData(desk.toArray());
	};

	public Personnage getObjet(int index){
		return  desk.get(index);
	};
/*
	public void supprimer(Personnage objet){
		if (desk.contains(objet)) desk.remove(objet);
	}
*/
	public void combat(Personnage p1, Personnage p2){
		if ( p1 instanceof Guerriers){
			((Guerriers)p1).attaquer(p2);
			if(Integer.parseInt(p2.getVie())<0){
				desk.remove(p2);
			}
			if (Integer.parseInt(p1.getVie())<0){
				desk.remove(p1);
			}
		}	
	}
		
}