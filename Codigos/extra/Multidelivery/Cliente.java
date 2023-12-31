package Multidelivery;

public class Cliente {
    private final int id;
    private final String nome;
    private String endereco;

    public Cliente(int id, String nome, String end) {
        this.id = id;
        this.nome = nome;
        this.endereco = end;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }
}

