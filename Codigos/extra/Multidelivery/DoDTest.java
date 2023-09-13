package Multidelivery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoDTest {
    private Cliente cliente1 = new Cliente(1, "Eurico", "123123");
    private Cliente cliente2 = new Cliente(2, "vasconcelos", "124123");
    private Cliente[] clientes = {this.cliente1, this.cliente2};
    private DoD fds = new DoD(clientes);

    @Test
    void addDelivery() {
        Delivery entrega1 = new Delivery("Mouse", "Eurico", 1);
        assertTrue(fds.addDelivery(entrega1));

        Delivery entrega2 = new Delivery("Mouse", "Eurico", 1);
        assertFalse(fds.addDelivery(entrega2));

        Delivery entrega3 = new Delivery("Mousa", "Eurica", 2);
        assertTrue(fds.addDelivery(entrega3));

        Delivery entrega4 = new Delivery("Mouse", "Eurice", 2);
        assertTrue(fds.addDelivery(entrega4));

        Delivery entrega5 = new Delivery("Mous4", "Euric3", 1);
        assertTrue(fds.addDelivery(entrega5));

        Delivery entrega6 = new Delivery("Mousa", "Euricf", 1);
        assertTrue(fds.addDelivery(entrega6));

        Delivery entrega7 = new Delivery("Mousi", "Euricu", 2);
        assertTrue(fds.addDelivery(entrega7));

        assertEquals(entrega1.getStatus(), "ongoing");
        assertEquals(entrega2.getStatus(), "ready");

        Delivery entrega8 = new Delivery("Mouse", "Eur4cu", 2);
        assertFalse(fds.addDelivery(entrega8));

    }

    @Test
    void listDoD() {
        Delivery entrega1 = new Delivery("Mouio", "Eurico", 1);
        fds.addDelivery(entrega1);
        Delivery entrega2 = new Delivery("Mouse", "Euric4", 2);
        fds.addDelivery(entrega2);

        assertEquals(fds.listDoD(), "Delivery [idCliente=1, pedido=Mouio, fornecedor=Eurico, status=ongoing]\nDelivery [idCliente=2, pedido=Mouse, fornecedor=Euric4, status=ongoing]\n");
    }

    @Test
    void finishDelivery() {
        Delivery entrega1 = new Delivery("Mouse", "Eurico", 1);
        fds.addDelivery(entrega1);
        Delivery entrega2 = new Delivery("Mous1", "Euric4", 2);
        fds.addDelivery(entrega2);

        assertTrue(fds.finishDelivery(0));
        assertFalse(fds.finishDelivery(0));
        assertTrue(fds.finishDelivery(1));
        try{
            fds.finishDelivery(100);
        }
        catch (IllegalArgumentException ex){
            assertEquals(ex.getMessage(), "Posicao Invalida!");
        }

    }

    @Test
    void listFinished() {
        Delivery entrega1 = new Delivery("Mouso", "Eurico", 1);
        Delivery entrega2 = new Delivery("Mouse", "Euric4", 2);
        fds.addDelivery(entrega2);
        fds.addDelivery(entrega1);


        fds.finishDelivery(1);
        assertEquals(fds.listFinished(), "Delivery [idCliente=1, pedido=Mouso, fornecedor=Eurico, status=finished]\n");
    }
}