package ProgRunners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgRunnerTest {
    private ProgRunner prog = new ProgRunner();

    @Test
    void cadastrarCorredor() {
        assertTrue(prog.cadastrarCorredor("eurico", "00000000001", 2004));
        assertTrue(prog.cadastrarCorredor("eurico", "00000000002", 2002));
        assertFalse(prog.cadastrarCorredor("eurico", "00000000002", 2001));
    }

    @Test
    void listarCorredores() {
        assertEquals(prog.listarCorredores(), "");
        prog.cadastrarCorredor("eurico", "00000000001", 2004);
        prog.cadastrarCorredor("eurico", "00000000002", 2002);
        prog.cadastrarCorredor("eurico", "00000000003", 2001);
        assertEquals(prog.listarCorredores(), "eurico - 00000000001 - JOVEM\neurico - 00000000002 - JOVEM\neurico - 00000000003 - JOVEM\n");
    }

    @Test
    void exibirCategoriaCorredor() {
        prog.cadastrarCorredor("eurico", "00000000001", 2004);
        prog.cadastrarCorredor("eurico", "00000000002", 2002);
        prog.cadastrarCorredor("eurico", "00000000003", 2001);

        assertEquals(prog.exibirCategoriaCorredor("00000000003"), "JOVEM");
        assertEquals(prog.exibirCategoriaCorredor(""), "Não esta presente na lista de Corredores!");
    }

    @Test
    void contarTreinosFinalizadosCorredor(){
        prog.cadastrarCorredor("eurico", "00000000001", 2004);
        prog.cadastrarCorredor("eurico", "00000000002", 2002);
        prog.cadastrarCorredor("eurico", "00000000003", 2001);

        prog.cadastrarTreinoCorredor("00000000001", 20, 60, "fds1");
        prog.finalizarTreino("00000000001", 0, 100);
        assertEquals(prog.contarTreinosFinalizadosCorredor("00000000001"), 1);

        prog.cadastrarTreinoCorredor("00000000001", 10, 30, "fds2");
        prog.finalizarTreino("00000000001", 1, 100);

        assertEquals(prog.contarTreinosFinalizadosCorredor("00000000001"), 2);


    }

    @Test
    void resistenciaCorredor(){
        prog.cadastrarCorredor("eurico", "00000000001", 2004);
        prog.cadastrarCorredor("eurico", "00000000002", 2002);
        prog.cadastrarCorredor("eurico", "00000000003", 2001);
        assertEquals(prog.resistenciaCorredor("00000000001"), 0);

        prog.cadastrarTreinoCorredor("00000000001", 20, 60, "fds1");
        prog.finalizarTreino("00000000001", 0, 100);
        assertEquals(prog.resistenciaCorredor("00000000001"), -1);

        prog.cadastrarTreinoCorredor("00000000001", 20, 60, "fds1");
        prog.finalizarTreino("00000000001", 1, 50);
        assertEquals(prog.resistenciaCorredor("00000000001"), 0);

    }
}