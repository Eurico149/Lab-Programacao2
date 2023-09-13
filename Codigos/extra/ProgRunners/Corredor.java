package ProgRunners;

public class Corredor {
    private String cpf;
    private String nome;
    private int anoNascimento;
    private String categoria;
    private Treino[] treinos;

    public Corredor(String nome, String cpf, int anoNascimento){
        this.cpf = cpf;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.treinos = new Treino[0];
    }

    private void setCategoria(){
        int idade = 2023 - this.anoNascimento;
        if (15 <= idade && idade <= 24){
            this.categoria = "JOVEM";
        } else if (idade <= 40) {
            this.categoria = "ADULTO";
        } else if (idade <= 64) {
            this.categoria = "SUPER_ADULTO";
        } else {
            this.categoria = "MELHOR_IDADE";
        }
    }

    public String getCpf(){
        return this.cpf;
    }

    public Treino[] getTreinos() {
        return this.treinos;
    }

    public String getCategoria() {
        setCategoria();
        return this.categoria;
    }

    public void setTreinos(Treino[] treino) {
        this.treinos = treino;
    }

    @Override
    public boolean equals(Object obj) {
        if (((Corredor)obj).getCpf() == this.cpf){
            return true;
        } return false;
    }

    @Override
    public String toString() {
        setCategoria();
        String str = "%s - %s - %s".formatted(this.nome, this.cpf, this.categoria);
        return str;
    }

}