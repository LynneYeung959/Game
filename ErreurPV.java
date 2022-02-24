class ErreurPV extends Exception{
	public ErreurPV(){
		super("ErreurPV! cette personnage a un point de vie null!");
	}
	public ErreurPV(Personnage p){
		super("Cette personnage est morte");
	}

}