import documin.DocumentoController;
import documin.VisaoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestesVisao {
    private DocumentoController dc;
    private VisaoController vc;

    @BeforeEach
    public void init() {
        this.dc = new DocumentoController();
        this.vc = new VisaoController(dc);

        dc.criarDocumento("Documento");
        dc.criarTexto("Documento", "texto", 0); // no array esse seria a posição 0
        dc.criarTitulo("Documento", "exemplodetexto", 4, 1, true); // idx 1
        dc.criarLista("Documento", "Exemplo | de uma lista | de 3 termos", 5, "|", "-"); // idx 2
        dc.criarTermos("Documento", "Teste / termos /Aleatórios", 2, "/", "TAMANHO");
        vc.criarVisaoCompleta("Documento");
        vc.criarVisaoResumida("Documento");
        vc.criarVisaoTitulo("Documento");
        vc.criarVisaoPrioritaria("Documento", 3);
    }

    @Test
    public void criarVisaoCompleta(){
        assertEquals(4,vc.criarVisaoCompleta("Documento"));
    }
    @Test
    public void criarVisaoResumida(){
        assertEquals(4, vc.criarVisaoResumida("Documento"));

    }
    @Test
    public void criarVisaoTitulo(){
        assertEquals(4,vc.criarVisaoTitulo("Documento"));

    }
    @Test
    public void criarVisaoPrioritaria(){
        assertEquals(4,vc.criarVisaoPrioritaria("Documento", 3));

    }

   @Test
   public void exibirVisaoCompleta() {
        String saida = "[texto, 1. exemplodetexto -- 1- EXEMPLODETEXTO, - Exemplo\n" +
                "- de uma lista\n" +
                "- de 3 termos, Total termos: 3\n" +
                "-Aleatórios,  termos , Teste]";
        assertEquals(saida, Arrays.toString(vc.exibirVisao(0)));
   }
    @Test
    public void exibirVisaoResumida() {
        String saida = "[texto, 1. exemplodetexto, Exemplo| de uma lista| de 3 termos, Aleatórios/ termos /Teste /]";
        assertEquals(saida, Arrays.toString(vc.exibirVisao(1)));
    }
    @Test
    public void exibirVisaoTitulo() {
        String saida = "[1. exemplodetexto]";
        assertEquals(saida, Arrays.toString(vc.exibirVisao(2)));
    }
    @Test
    public void exibirVisaoPrioritaria() {
        String saida = "[1. exemplodetexto -- 1- EXEMPLODETEXTO, - Exemplo\n" +
                "- de uma lista\n" +
                "- de 3 termos]";
        assertEquals(saida, Arrays.toString(vc.exibirVisao(3)));
    }

}
