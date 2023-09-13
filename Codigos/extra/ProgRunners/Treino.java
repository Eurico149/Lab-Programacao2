package ProgRunners;

public class Treino {
    private final double distancia;
    private final int tempo_esperado;
    private int tempo_gasto;
    private final String descricao;
    private String status;

    public Treino(double distancia, int tempoEsperado, String descricao){
        this.distancia = distancia;
        this.tempo_esperado = tempoEsperado;
        this.descricao = descricao;
        this.status = "não iniciado.";
    }

    public void setStatus() {
        this.status = "terminado";
    }

    public String getStatus() {
        return this.status;
    }

    public void setTempo_gasto(int tempo_gasto) {
        this.tempo_gasto = tempo_gasto;
    }

    public int resistencia(){
        if (this.status.equals("terminado")){
            if (this.tempo_gasto > this.tempo_esperado){
                return -1;
            } else if (this.tempo_esperado > this.tempo_gasto) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "%fkm - %dmin - %s".formatted(this.distancia, this.tempo_esperado, this.descricao);
    }

}
