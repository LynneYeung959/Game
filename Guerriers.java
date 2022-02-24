abstract class Guerriers extends Personnage implements Attaquer{

  protected int puissanceAttaque;

  public Guerriers(int positionX, int positionY,String nom) throws ErreurPV, ErreurPosition{
  	super(positionX,positionY,nom); // super() vide, lorsque la methode mere n'a pas de parametre  
  }
  public abstract void attaquer(Personnage p);

  public String allInfo(){
    return super.allInfo()+"Son point d'attaque est :"+puissanceAttaque;
  }

}
