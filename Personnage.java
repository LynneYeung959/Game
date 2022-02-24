import java.util.Random;

abstract class Personnage{
  private String nom;  // protected pour hériter aux classes filles
  protected int ptDeVie; // static cad que c'est pareil pour tout le monde
  protected int positionX;
  protected int positionY;
  protected int pvInit;


  Random rnd= new Random();

  public Personnage(int positionX, int positionY,String nom) throws ErreurPV,ErreurPosition
  {
    this.nom = nom;
    this.positionX = positionX;
    this.positionY = positionY;
    if ((positionX<0)||(positionY<0)) throw new ErreurPosition();   //lance une exception de type ErreurPostion
    this.pvInit = rnd.nextInt(50);
    if (this.pvInit < 0) throw new ErreurPV();
    this.ptDeVie = pvInit;
  }

  public int ptDeVieInitiale() throws ErreurPV{
    if (this.pvInit < 0) throw new ErreurPV();
    System.out.println("son PV initial est :" + this.pvInit);
    return this.pvInit;
  }

  public String getVie(){
    System.out.println("son point de vie est: " +this.ptDeVie+".");
    return String.valueOf(this.ptDeVie);
  }

  public String getNom(){
    System.out.println("Son nom est:" + this.nom+".");
    return this.nom;
  }

  public double distance(Personnage p){
    return Math.sqrt(Math.pow(p.positionX - this.positionX,2) + Math.pow(p.positionY - this.positionY,2));
  }

  public String allInfo(){
    return this.getClass().getName()+"("+this.getClass().getSuperclass().getName()+")";
  }

  public String toString(){
    return this.getClass().getName();
  }





}
