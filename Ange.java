class Ange extends Soigneurs{

  public Ange(int positionX, int positionY, String nom)throws ErreurPV,ErreurPosition
  {
    super(positionX, positionY,nom); 
    this.puissanceSoigner = 10;
  }


  public void soigner(Personnage p){
      if ((p.pvInit > p.ptDeVie) && (this.ptDeVie >0)){
        p.ptDeVie += this.puissanceSoigner;
        this.ptDeVie -= 5;
        if (p.ptDeVie > p.pvInit){
          p.ptDeVie = p.pvInit;
        }
        if (this.ptDeVie <0){
            this.ptDeVie = 0;
          }
      }
  }

}
