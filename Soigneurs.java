abstract class Soigneurs extends Personnage implements Soigner{
  protected int puissanceSoigner;

  public Soigneurs(int positionX, int positionY,String nom)throws ErreurPV, ErreurPosition{
    super(positionX,positionY,nom);
  }

  public String allInfo(){
    return super.allInfo()+"Son point de soin est :"+puissanceSoigner;
  }

  public abstract void soigner(Personnage p);
}
