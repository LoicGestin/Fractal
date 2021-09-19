class DessinFractale{
    private final Turtle bob;
    
    private final static int LARGEUR = 800;
    private final static int HAUTEUR = 600;
    //taille de la fenetre graphique

    public DessinFractale(){
	bob  = new Turtle();
	Turtle.setCanvasSize(LARGEUR,HAUTEUR);//à appeler APRES création de la tortue
    }

    public DessinFractale(int v){
	//attention, plus v est grand, plus bob va lentement !
	this();
	bob.speed(0.1);


    }


    public void reset(){
	bob.clear();
	bob.up();
	bob.setPosition(0,0);
	bob.setDirection(0);
	bob.down();

    }
	public void vonKoch(double l, int n){
    	if(n == 0) {
			bob.forward(l);
		}
    	else {
    		vonKoch(l/3,n-1);
    		bob.left(55);
    		vonKoch(l/3,n-1);
    		bob.right(55+55);
    		vonKoch(l/3,n-1);
    		bob.left(55);
			vonKoch(l/3,n-1);
		}

	}

	public void tree(double l, int n){
    	if (n == 0){
    		bob.forward(l);
		}
    	else{
			bob.forward(l/2);
    		bob.left(45);
    		tree(l/2,n-1);
    		bob.right(180);
    		bob.forward(l/2);
    		bob.right(180+90);
			tree(l/2,n-1);
			bob.right(180);
			bob.forward(l/2);
			bob.right(180-45);
			tree(l/2,n-1);
		}
	}
	public void triangle(double l, int n){
		if (n == 0) {
			bob.forward(l);
			bob.left(120);
			bob.forward(l);
			bob.left(120);
			bob.forward(l);
			bob.left(120);


		}
		else {
			triangle(l/2,n-1);
			bob.forward(l/2);
			triangle(l/2,n-1);


			bob.left(180);
			bob.forward(l/2);
			bob.left(180);

			bob.left(60);
			bob.forward(l/2);
			bob.right(60);

			triangle(l/2,n-1);

			bob.left( 60);
			bob.left(180 );
			bob.forward(l/2);
			bob.right( 180);
			bob.right(60);


		}
	}
	public void dragon(double l, int n,int angle){
		if( n == 0){
			bob.forward(l);
		}
		else {
			dragon(l,n-1,90);
			bob.left(angle);
			dragon(l,n-1,-90);

		}
	}

    public void close(){
	bob.exit();
    }


    public void carre(double l){
		bob.forward(l);
		bob.left(90);
		bob.forward(l);
		bob.left(90);
		bob.forward(l);
		bob.left(90);
		bob.forward(l);
		bob.left(90);
    }


    public static void main(String[] args){

	DessinFractale d = new DessinFractale(500);

	d.triangle(1200,7);
    }
    
}