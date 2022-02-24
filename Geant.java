class Geant extends Guerriers{

  public Geant(int positionX,int positionY, String nom)throws ErreurPosition,ErreurPV
  {
    super(positionX,positionY,nom);
    this.puissanceAttaque = 5;
  }

  public void attaquer(Personnage p){
      if ((this.distance(p) > 5)&&(this.ptDeVie >0)){
        p.ptDeVie -= this.puissanceAttaque;
      }else {
        p.ptDeVie -=3;
        if (Integer.parseInt(p.getVie()) <0){
          p.ptDeVie = 0;
        }
      }

  }

}
