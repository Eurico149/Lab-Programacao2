package ProgRunners;

public class ProgRunner {
    private Corredor[] corredores;

    public ProgRunner(){
        this.corredores = new Corredor[0];
    }

    public boolean cadastrarCorredor(String nome, String cpf, int anoNascimento){
        if (this.corredores != null){
            Corredor corredor = new Corredor(nome, cpf, anoNascimento);
            for (Corredor i: this.corredores) {
                if (i.equals(corredor)) {
                    return false;
                }
            }
            Corredor[] auxCorredores = new Corredor[this.corredores.length+1];
            auxCorredores[this.corredores.length] = corredor;
            for (int j=0; j<this.corredores.length; ++j){
                auxCorredores[j] = this.corredores[j];
            }
            this.corredores = auxCorredores;
            return true;

        }
        Corredor corredor = new Corredor(nome, cpf, anoNascimento);
        Corredor[] auxCorredores = new Corredor[1];
        auxCorredores[0] = corredor;
        this.corredores = auxCorredores;
        return true;
    }

    public String listarCorredores(){
        String str = "";
        if (this.corredores != null) {
            for (Corredor i : this.corredores) {
                str += i.toString() + "\n";
            }
        }
        return str;
    }

    public String exibirCategoriaCorredor(String cpf){
        for (Corredor i: this.corredores){
            if (i.getCpf() == cpf){
                return i.getCategoria();
            }
        } return "Não esta presente na lista de Corredores!";
    }

    public void cadastrarTreinoCorredor(String cpf, double distancia, int tempoEsperado, String descricao){
        int tamanho = 0;
        if (this.corredores != null){
            for (Corredor i: this.corredores){
                if (i.getCpf() == cpf){
                    Treino treino = new Treino(distancia, tempoEsperado, descricao);
                    if (i.getTreinos() != null){
                        tamanho = i.getTreinos().length+1;
                        Treino[] auxTreinos = new Treino[tamanho];
                        for (int j=0; j < i.getTreinos().length; ++j){
                            auxTreinos[j] = i.getTreinos()[j];
                        }
                        auxTreinos[tamanho-1] = treino;
                        i.setTreinos(auxTreinos);
                        break;
                    } else {
                        Treino[] auxTreinos = new Treino[1];
                        auxTreinos[0] = treino;
                        i.setTreinos(auxTreinos);
                        break;
                    }
                }
            }
        }
    }

    public void finalizarTreino(String cpf, int indice, int tempoGasto){
        if (this.corredores != null) {
            for (Corredor i : this.corredores) {
                if (i.getCpf().equals(cpf)) {
                    i.getTreinos()[indice].setTempo_gasto(tempoGasto);
                    i.getTreinos()[indice].setStatus();
                }
            }
        }
    }

    public int contarTreinosFinalizadosCorredor(String cpf){
        int cont = 0;
        if (this.corredores != null) {
            for (Corredor i : this.corredores) {
                if (i.getCpf().equals(cpf)) {
                    for (Treino j : i.getTreinos()) {
                        if (j != null && j.getStatus().equals("terminado")) {
                            cont += 1;
                        }
                    }
                    break;
                }
            }
        }
        return cont;
    }

    public double resistenciaCorredor(String cpf){
        int cont = 0;
        double media = 0;
        if (this.corredores != null) {
            for (Corredor i : this.corredores) {
                if (i.getCpf().equals(cpf)) {
                    for (Treino j: i.getTreinos()){
                        media += j.resistencia();
                        cont = i.getTreinos().length;
                    }
                    break;
                }
            }
        }
        if (cont == 0){
            return 0;
        }
        return media/cont;
    }

}
