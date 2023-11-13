    package linea;

    public class JuegaRojo extends EstadoJuego {


        public EstadoJuego playRedAs(int column, Linea game) {
            game.dropPieceInColumn(column, Linea.redPlayer);
            return this.isDraw(game) ? new Empate() : new JuegaAzul();
        }

        public EstadoJuego playBlueAs(int column, Linea game) {
            throw new RuntimeException("Not blue turn");
        }

        public String getStatus() {
            return "> Playing Red <";
        }
    }
