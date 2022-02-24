class Nain extends Guerriers{

  public Nain(int positionX, int positionY, String nom) throws ErreurPosition,ErreurPV
  {
    super(positionX,positionY,nom);
    this.puissanceAttaque = 3;
  }

  public void attaquer(Personnage p){
      if ((this.distance(p) <= 10)&&(this.ptDeVie >0)){
        p.ptDeVie = p.ptDeVie - this.puissanceAttaque;
        if (Integer.parseInt(p.getVie()) < 0){
          p.ptDeVie = 0;
        }
      }
   
    
  }

}
