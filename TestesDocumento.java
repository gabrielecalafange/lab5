import documin.DocumentoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestesDocumento {

    private DocumentoController dc;
    @BeforeEach
    public void init() {
        this.dc = new DocumentoController();
        dc.criarDocumento("Documento");
        dc.criarTexto("Documento", "texto", 0); // no array esse seria a posição 0
        dc.criarTitulo("Documento", "exemplodetexto", 4, 1, true); // idx 1
        dc.criarLista("Documento", "Exemplo | de uma lista | de 3 termos", 5, "|", "-"); // idx 2
        dc.criarTermos("Documento", "Teste / termos /Aleatórios", 1, "/", "TAMANHO"); // idx 3
    }

    @Test
    public void testCriaDoc() {
        assertEquals(true, dc.criarDocumento("Doc"));
        assertEquals(false, dc.criarDocumento("Doc", 10));
    }
    @Test
    public void testCriarTexto() {
        assertEquals(4, dc.criarTexto("Documento", "texto 2", 4));
    }
    @Test
    public void testContaElemento() {
        assertEquals(4, dc.contarElementos("Documento"));
    }
    @Test
    public void testCriarTitulo() {
        assertEquals(4, dc.criarTitulo("Documento", "Título", 3, 1, false));
    }
    @Test
    public void testCriarLista() {
        assertEquals(4, dc.criarLista("Documento","Teste | lista | novos termos", 5, "|", "-" ));
    }
    @Test
    public void testCriarTermos() {
        assertEquals(4, dc.criarTermos("Documento", "meus / termos / NOVOS", 1, "/", "TAMANHO"));
    }
    @Test
    public void testApagarElementoSim(){
        assertEquals(true, dc.apagarElemento("Documento", 3));
    }
    @Test
    public void testApagarElementoNao(){
        assertEquals(false, dc.apagarElemento("Documento", 7));
    }
    @Test
    public void testRepresentacaoResumidaTexto() {
        assertEquals("texto", dc.pegarrepresentacaoResumida("Documento", 0)); // rep resumida de texto
    }
    @Test
    public void testRepresentacaoResumidaTitulo() {
        assertEquals("1. exemplodetexto", dc.pegarrepresentacaoResumida("Documento", 1));
    }
    @Test
    public void testRepresentacaoResumidaLista() {
        assertEquals("Exemplo| de uma lista| de 3 termos", dc.pegarrepresentacaoResumida("Documento", 2));
    }
    @Test
    public void testRepresentacaoResumidaTermos() {
        assertEquals("Aleatórios/ termos /Teste /", dc.pegarrepresentacaoResumida("Documento", 3));
    }
    @Test
    public void testRepresentacaoCompletaTexto() {
        assertEquals("texto", dc.pegarrepresentacaoCompleta("Documento", 0));
    }
    @Test
    public void testRepresentacaoCompletaTitulo(){
        assertEquals("1. exemplodetexto -- 1- EXEMPLODETEXTO", dc.pegarrepresentacaoCompleta("Documento", 1));}
    @Test
    public void testRepresentacaoCompletaLista(){
        assertEquals("- Exemplo\n- de uma lista\n- de 3 termos", dc.pegarrepresentacaoCompleta("Documento", 2));}
    @Test
    public void testRepresentacaoCompletaTermos(){
        assertEquals("Total termos: 3\n-Aleatórios,  termos , Teste", dc.pegarrepresentacaoCompleta("Documento", 3));}
    @Test
    public void testCriarAtalaho() {
        dc.criarDocumento("Doc");
        assertEquals(0, dc.criarAtalho("Doc", "Documento"));
    }
    @Test
    public void moverElementosParaCima() {
        dc.moverParaCima("Documento", 0);
        assertEquals("exemplodetexto",dc.getDocumento("Documento").getElementoIdx(0));
    }
    @Test
    public void moverElementosParaBaixo() {
        dc.moverParaBaixo("Documento", 3);
        assertEquals("Exemplo | de uma lista | de 3 termos",dc.getDocumento("Documento").getElementoIdx(3));
    }
    @Test
    public void testExibirDoc(){
        String saida = "[texto, exemplodetexto, Exemplo | de uma lista | de 3 termos, Teste / termos /Aleatórios]";
        assertEquals(saida, Arrays.toString(dc.exibirDocumento("Documento")));
    }

}