package nemoproject;

public class Nemo {
	    private int x;
	    private int y;
	    private int depth;
	    private String direction;
	    private int[] position;
        /* como procesar los caracteres sin if ni switch, cam handle. dado una coleccion de elementos
        , para todx elemento en esa coleccion si el elemento cumple que haga algo
                metodo estatico que se
                Static command(cha c{
                {} para todx e   e.cumple(c)
                 }
                 tener la idea de un punto en el mapa con las coordenadas x e y variables separadas
                  na subclase por cada caracter */
	    public Nemo() {
	        this.x = 0;
	        this.y = 0; 
	        this.depth = 0;
	        this.direction = "norte";
	        this.position = new int[]{x, y};
	    }
    public int getDepth() {
    	return this.depth;
    }

    public int[] getPosition() {
        return this.position;
    }
    
    public String getDirection() {
        return this.direction;
    }
    
    public Nemo move(String command) {
        command.chars()
        .mapToObj(c -> (char) c)
        .forEach(this::processCharacter);
return this;
}
private void processCharacter(char c) {
String command = String.valueOf(c);
		if (command.equals("u")) {
			this.depth += 1;
		}
        if (command.equals("d")) {
            this.depth -= 1;
        }
        if (command.equals("r")) {
            switch (this.direction) {
                case "norte":
                    this.direction = "este";
                    break;
                case "este":
                    this.direction = "sur";
                    break;
                case "sur":
                    this.direction = "oeste";
                    break;
                case "oeste":
                    this.direction = "norte";
                    break;
            }
        }
        if (command.equals("l")) {
            switch (this.direction) {
                case "norte":
                    this.direction = "oeste";
                    break;
                case "oeste":
                    this.direction = "sur";
                    break;
                case "sur":
                    this.direction = "este";
                    break;
                case "este":
                    this.direction = "norte";
                    break;
            }
        }

        if (command.equals("f")) {
            switch (this.direction) {
                case "norte":
                    this.position[1] += 1;
                    break;
                case "sur":
                    this.position[1] -= 1;
                    break;
                case "este":
                    this.position[0] += 1;
                    break;
                case "oeste":
                    this.position[0] -= 1;
                    break;
            }
        }}}
