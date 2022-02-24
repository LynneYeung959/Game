class Sorciere extends Soigneurs{
  
  public Sorciere(int positionX,int positionY,String nom)throws ErreurPV,ErreurPosition{
    super(positionX, positionY,nom);
    this.puissanceSoigner = 8;
  }

  public void soigner(Personnage p){
      if (p.pvInit > p.ptDeVie){
        if (this.distance(p) < 20){
          p.ptDeVie += this.puissanceSoigner;
          if (p.ptDeVie > p.pvInit){
            p.ptDeVie = p.pvInit;
          }
        }
      }
  
  }
}
