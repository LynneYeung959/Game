class Princesse extends Paladins{

  public Princesse(int positionX, int positionY, String nom)throws ErreurPV,ErreurPosition
  {
    super(positionX, positionY,nom);
    this.puissanceAttaque = 2;
    this.puissanceSoigner = 5;
  }

  public void attaquer(Personnage p){
    
    if ((this.distance(p) < 10) && (this.ptDeVie > 0)){
      p.ptDeVie -= this.puissanceAttaque;
      this.ptDeVie -= this.puissanceAttaque;
      if (Integer.parseInt(p.getVie()) < 0){
         p.ptDeVie = 0;
      }
      if (Integer.parseInt(this.getVie()) <0){
        this.ptDeVie = 0;
      }
     
    }
  }

  public void soigner(Personnage p){
    this.recuperation();
    if ((p.pvInit > p.ptDeVie)&&(this.ptDeVie >0)){
      if (this.distance(p) < 10){
          p.ptDeVie += this.puissanceSoigner;
          if (p.ptDeVie > p.pvInit){
            p.ptDeVie = p.pvInit;
          }
        }
      }
    
  }
}
