package Multidelivery;

public class Delivery {
    private final String produto;
    private final String fornecedor;
    private final int idCliente;
    private String status;

    public Delivery(String produto, String fornecedor, int idCliente){
        this.produto = produto;
        this.fornecedor = fornecedor;
        this.idCliente = idCliente;
        this.status = "ready";
    }

    public Delivery(String produto, String fornecedor, int idCliente, String status){
        this.produto = produto;
        this.fornecedor = fornecedor;
        this.idCliente = idCliente;
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (((Delivery)obj).getProduto().equals(this.produto)){
            if (((Delivery)obj).getFornecedor().equals(this.fornecedor)){
                if (((Delivery)obj).getIdCliente() == this.idCliente){
                    return true;
                }
            }
        } return false;
    }

    public String getProduto() {
        return this.produto;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public String getFornecedor() {
        return this.fornecedor;
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "Delivery [idCliente=%d, pedido=%s, fornecedor=%s, status=%s]".formatted(this.idCliente, this.produto, this.fornecedor, this.status);
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
