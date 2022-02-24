abstract class Paladins extends Personnage implements Attaquer, Soigner{
  int puissanceAttaque;
  int puissanceSoigner;
  
  public Paladins(int positionX, int positionY,String nom) throws ErreurPV,ErreurPosition{
    super(positionX, positionY,nom);
  }

  public void recuperation(){
    try
    {
      while (this.ptDeVie < this.ptDeVieInitiale()){
        this.ptDeVie += 5;
        if (this.ptDeVie >= this.ptDeVieInitiale()){
          this.ptDeVie = this.ptDeVieInitiale();
        }
      }
    }
    catch(ErreurPV e)
    {
      System.out.println(e.getMessage());
      this.ptDeVie = 0;
    }
  }

  public String allInfo(){
    return super.allInfo()+"Son point d'attaque est :"+puissanceAttaque+". Son point de soin est :"+puissanceSoigner;
  }

  public abstract void soigner(Personnage p);

  public abstract void attaquer(Personnage p);

}
