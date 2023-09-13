package Multidelivery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoDTest {
    private Cliente cliente1 = new Cliente(001, "Eurico", "123123");
    private Cliente cliente2 = new Cliente(002, "vasconcelos", "124123");
    private Cliente[] clientes = {this.cliente1, this.cliente2};
    private DoD fds = new DoD(clientes);

    @Test
    void addDelivery() {
        Delivery entrega1 = new Delivery("Dildo", "Eurico", 001);
        assertTrue(fds.addDelivery(entrega1));

        Delivery entrega2 = new Delivery("Dildo", "Eurico", 001);
        assertFalse(fds.addDelivery(entrega2));

        Delivery entrega3 = new Delivery("Dilda", "Eurica", 002);
        assertTrue(fds.addDelivery(entrega3));

        Delivery entrega4 = new Delivery("Dilde", "Eurice", 002);
        assertTrue(fds.addDelivery(entrega4));

        Delivery entrega5 = new Delivery("Dild2", "Euric3", 001);
        assertTrue(fds.addDelivery(entrega5));

        Delivery entrega6 = new Delivery("Dildg", "Euricf", 001);
        assertTrue(fds.addDelivery(entrega6));

        Delivery entrega7 = new Delivery("Dilde", "Euricu", 002);
        assertTrue(fds.addDelivery(entrega7));

        assertEquals(entrega1.getStatus(), "ongoing");
        assertEquals(entrega2.getStatus(), "ready");

        Delivery entrega8 = new Delivery("Dil4e", "Eur4cu", 002);
        assertFalse(fds.addDelivery(entrega8));

    }

    @Test
    void listDoD() {
        Delivery entrega1 = new Delivery("Dildo", "Eurico", 001);
        fds.addDelivery(entrega1);
        Delivery entrega2 = new Delivery("Dild5", "Euric4", 002);
        fds.addDelivery(entrega2);

        assertEquals(fds.listDoD(), "Delivery [idCliente=1, pedido=Dildo, fornecedor=Eurico, status=ongoing]\nDelivery [idCliente=2, pedido=Dild5, fornecedor=Euric4, status=ongoing]\n");
    }

    @Test
    void finishDelivery() {
        Delivery entrega1 = new Delivery("Dildo", "Eurico", 001);
        fds.addDelivery(entrega1);
        Delivery entrega2 = new Delivery("Dild5", "Euric4", 002);
        fds.addDelivery(entrega2);

        assertTrue(fds.finishDelivery(0));
        assertFalse(fds.finishDelivery(0));
    }

    @Test
    void listFinished() {
        Delivery entrega1 = new Delivery("Dildo", "Eurico", 001);
        Delivery entrega2 = new Delivery("Dild5", "Euric4", 002);
        fds.addDelivery(entrega2);
        fds.addDelivery(entrega1);


        fds.finishDelivery(1);
        assertEquals(fds.listFinished(), "Delivery [idCliente=1, pedido=Dildo, fornecedor=Eurico, status=finished]\n");
    }
}