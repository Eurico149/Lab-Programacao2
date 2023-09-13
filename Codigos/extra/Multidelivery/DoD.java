package Multidelivery;

public class DoD {
    private Delivery[] entregas;
    private Cliente[] clientes;

    public DoD(int entregas, Cliente[] clientes){
        this.entregas = new Delivery[entregas];
        this.clientes = clientes;
    }

    public DoD(Cliente[] clientes){
        this.entregas = new Delivery[6];
        this.clientes = clientes;

    }

    public boolean addDelivery(Delivery d1) {
        for (int i=0; i < this.entregas.length; ++i){
            if (this.entregas[i] == null){
                for (int j=0; j < this.clientes.length; ++j){
                    if (this.clientes[j].getId() == d1.getIdCliente()){
                        this.entregas[i] = d1;
                        d1.setStatus("ongoing");
                        return true;
                    }
                }
            }else {
                if (d1.equals(this.entregas[i])) {
                    return false;
                }
            }
        } return false;
    }

    public String listDoD(){
        String str = "";
        for (Delivery i: this.entregas){
            if (i != null){
                str += i + "\n";}
        }
        return str;
    }

    public boolean finishDelivery(int pos){
        if (pos >= this.entregas.length || this.entregas[pos] == null){
            throw new IllegalArgumentException("Posicao Invalida!");
        }
        if (this.entregas[pos].getStatus().equals("finished")){
            return false;
        }
        this.entregas[pos].setStatus("finished");
        return true;
    }

    public String listFinished(){
        String str = "";
        for (Delivery i: this.entregas){
            if (i != null) {
                if (i.getStatus().equals("finished")) {
                    str += i + "\n";
                }
            }
        } return str;
    }

}
