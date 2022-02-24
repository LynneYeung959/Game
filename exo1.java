import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class exo1 {
  public static void main (String args[]){

    try
    {
        Personnage ange = new Ange(30,32); // positionX = 10, positionY = 20;
        //Sorciere madame1 = new Sorciere( 5,6);
        Personnage man1 = new Geant(30,30);
        Personnage man2 = new Nain(33,33);
        Personnage queen = new Princesse ( 31,30);


    /*
    man1.attaquer(man2);
    man2.attaquer(queen);
    queen.attaquer(angle);
    angle.soigner(man2);
    //madame1.soigner(queen);
    queen.attaquer(man1);
    */


    //////////////////////////////////Partie du TP2

        Personnage angel = new Ange(36,40);
        Desk listeP = new Desk(angel);

        Personnage big = new Geant (33,32);
        Personnage small = new Nain(30,31);
        Personnage beauty = new Princesse(33,31);
        Personnage doctor = new Sorciere(33,34);
        Personnage sorceress = new Sorciere(35,37);
        Personnage angelbaby = new Ange(33,36,"AngleBaby");

        //verification la fonctionnement des exceptions
        //Personnage test = new Princesse(-2,0);
    
        listeP.addObjet(big);
        listeP.addObjet(beauty);
        listeP.addObjet(doctor);
        listeP.addObjet(sorceress);
        listeP.addObjet(angel);
/*
    Personnage p = new Geant(30,30);
    Personnage d = new Geant(30,31);
    d.getVie();
    p.attaquer(d);
    d.getVie();
*/
    /*
    Random rnd = new Random();
    int nbA = rnd.nextInt(5);
    int nbB = rnd.nextInt(5);

    System.out.println("\nles informations de la presonnage A: \n"+listeP.getObjet(nbA).allInfo());
    listeP.getObjet(nbA).getNom();
    System.out.println("Son point de vie initiale est: "+listeP.getObjet(nbA).ptDeVieInitiale());
    System.out.println("\nles informations de la personnage B: \n"+listeP.getObjet(nbB).allInfo());
    listeP.getObjet(nbB).getNom();
    System.out.println("Son point de vie initiale est: "+listeP.getObjet(nbB).ptDeVieInitiale());


    Personnage a = listeP.getObjet(nbA);
    Personnage b = listeP.getObjet(nbB);

    if (a instanceof Ange ){ //  si A est Soigneur
       ((Ange)a).soigner(b); 
    }
    if (a instanceof Sorciere ){ // si A est Soigneur
        ((Sorciere)a).soigner(b);
    }
    if (a instanceof Geant){  // si A est Guerrier
       ((Geant)a).attaquer(b); 
    }
    if (a instanceof Nain) {  // si A est Guerrier
        ((Nain)a).attaquer(b);
    }
    if (a instanceof Princesse){ // si A est Paladin
       ((Princesse)a).soigner(b); 
    }



    if (b instanceof Ange ){ //  si B est Soigneur
       ((Ange)b).soigner(a); 
    }
    if (b instanceof Sorciere ){ // si B est Soigneur
        ((Sorciere)b).soigner(a);
    }
    if (b instanceof Geant){  // si B est Guerrier
       ((Geant)b).attaquer(a); 
    }
    if (b instanceof Nain) {  // si B est Guerrier
        ((Nain)b).attaquer(a);
    }
    if (b instanceof Princesse){ // si B est Paladin
       ((Princesse)b).soigner(a); 
    }

    System.out.println("\nle point de vie actuel de Personnage A est : ");
    a.getVie();
    a.getNom();

    System.out.println("\nSon point de vie actuel de Personnage B est : ");
    b.getVie();
    b.getNom();




    int nbC = rnd.nextInt(5);
    int nbD = rnd.nextInt(5);

    System.out.println("\nles informations de la presonnage C: \n"+listeP.getObjet(nbC).allInfo());
    listeP.getObjet(nbC).getNom();
    System.out.println("Son point de vie initiale est: "+listeP.getObjet(nbC).ptDeVieInitiale());
    System.out.println("\nles informations de la personnage D: \n"+listeP.getObjet(nbD).allInfo());
    listeP.getObjet(nbD).getNom();
    System.out.println("Son point de vie initiale est: "+listeP.getObjet(nbD).ptDeVieInitiale());


    Personnage c = listeP.getObjet(nbC);
    Personnage d = listeP.getObjet(nbD);

    if (c instanceof Ange ){ //  si C est Soigneur
       ((Ange)c).soigner(d); 
    }
    if (c instanceof Sorciere ){ // si C est Soigneur
        ((Sorciere)c).soigner(d);
    }
    if (c instanceof Geant){  // si C est Guerrier
       ((Geant)c).attaquer(d); 
    }
    if (c instanceof Nain) {  // si C est Guerrier
        ((Nain)c).attaquer(d);
    }
    if (c instanceof Princesse){ // si C est Paladin
       ((Princesse)c).soigner(d); 
    }



    if (d instanceof Ange ){ //  si D est Soigneur
       ((Ange)d).soigner(c); 
    }
    if (d instanceof Sorciere ){ // si D est Soigneur
        ((Sorciere)d).soigner(c);
    }
    if (d instanceof Geant){  // si D est Guerrier
       ((Geant)d).attaquer(c); 
    }
    if (d instanceof Nain) {  // si D est Guerrier
        ((Nain)d).attaquer(c);
    }
    if (d instanceof Princesse){ // si D est Paladin
       ((Princesse)d).soigner(c); 
    }

    System.out.println("\nle point de vie actuel de Personnage C est : ");
    c.getVie();
    c.getNom();

    System.out.println("\nSon point de vie actuel de Personnage D est : ");
    d.getVie();
    d.getNom();
*/

        Desk listef = new Desk(ange);
        listef.addObjet(man1);
        listef.addObjet(man2);
        listef.addObjet(queen);
        listef.addObjet(angelbaby);
        listef.addObjet(big);

        //listef.combat(man1,man2);

        SwingUtilities.invokeLater(new Runnable(){;
            public void run(){
                Fenetre fenetre = new Fenetre(listeP,listef);
                fenetre.setVisible(true);
                
            }
        });

    }
    catch(ErreurPosition e1){
        System.out.println(e1.getMessage());
    }
    catch(ErreurPV e2){
        System.out.println(e2.getMessage());

    }




  }
}
