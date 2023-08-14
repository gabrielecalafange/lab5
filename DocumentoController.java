package documin;
import java.util.HashMap;

/**
 * A classe DocumentoController é responsável por controlar as operações relacionadas aos documentos.
 * @author gabrielecalafange
 */
public class DocumentoController {
    private HashMap<String, Documento> documentos = new HashMap<>();
    private Verificador v = new Verificador();

    /**
     * Cria um novo documento com o título especificado.
     *
     * @param titulo o título do documento
     * @return true se o documento foi criado com sucesso, false se o documento já existe
     */
    public boolean criarDocumento(String titulo) {
        v.testeTitulo(titulo);

        Documento novoDoc = new Documento(titulo);
        if (documentos.containsKey(titulo)) {return false;}
        documentos.put(titulo, novoDoc);
        return true;
    }

    /**
     * Cria um novo documento com o título e o tamanho máximo especificados.
     *
     * @param titulo       o título do documento
     * @param tamanhoMaximo o tamanho máximo do documento
     * @return true se o documento foi criado com sucesso, false se o documento já existe
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        v.testeTitulo(titulo);

        Documento novoDoc = new Documento(titulo, tamanhoMaximo);
        if (documentos.containsKey(titulo)) {return false;}
        documentos.put(titulo, novoDoc);
        return true;
    }

    /**
     * Remove o documento com o título especificado.
     *
     * @param titulo o título do documento a ser removido
     */
    public void removerDocumento(String titulo) {
        v.testeTitulo(titulo);
        v.testeCadastro(documentos.containsKey(titulo));

        documentos.remove(titulo);
    }

    /**
     * Retorna a quantidade de elementos no documento com o título especificado.
     *
     * @param titulo o título do documento
     * @return a quantidade de elementos no documento
     */
    public int contarElementos(String titulo) {
        v.testeTitulo(titulo);
        v.testeCadastro(documentos.containsKey(titulo));

        Documento d = documentos.get(titulo);
        return d.elementosQtd();
    }

    /**
     * Retorna a representação do documento com o título especificado.
     *
     * @param titulo o título do documento
     * @return um array de strings que representa o documento
     */
    public String[] exibirDocumento(String titulo) {
        v.testeTitulo(titulo);
        v.testeCadastro(documentos.containsKey(titulo));

        Documento d = documentos.get(titulo);
        return d.representacao();
    }

    /**
     * Move o elemento para cima no documento com o título especificado.
     *
     * @param titulo o título do documento
     * @param elementoPosicao a posição do elemento a ser movido para cima
     */
    public void moverParaCima(String titulo, int elementoPosicao) {
        v.testeTitulo(titulo);
        v.testeCadastro(documentos.containsKey(titulo));

        Documento d = documentos.get(titulo);
        d.moverAcima(elementoPosicao);
    }

    /**
     * Move o elemento para baixo no documento com o título especificado.
     *
     * @param titulo o título do documento
     * @param elementoPosicao a posição do elemento a ser movido para baixo
     */
    public void moverParaBaixo(String titulo, int elementoPosicao) {
        v.testeTitulo(titulo);
        v.testeCadastro(documentos.containsKey(titulo));

        Documento d = documentos.get(titulo);
        d.moverAbaixo(elementoPosicao);
    }

    /**
     * Apaga o elemento na posição especificada no documento com o título especificado.
     *
     * @param titulo o título do documento
     * @param elementoPosicao a posição do elemento a ser apagado
     * @return true se o elemento foi apagado com sucesso, false se a posição do elemento é inválida
     */
    public boolean apagarElemento(String titulo, int elementoPosicao) {
        v.testeTitulo(titulo);
        v.testeCadastro(documentos.containsKey(titulo));

        Documento d = documentos.get(titulo);
        if (elementoPosicao > d.elementosQtd()) {return false;}
        return d.apagarElemento(elementoPosicao);
    }

    /**
     * Cria um elemento de texto no documento com o título especificado.
     *
     * @param titulo o título do documento
     * @param valor o valor do elemento de texto
     * @param prioridade a prioridade do elemento
     * @return o índice do elemento criado
     */
    public int criarTexto(String titulo, String valor, int prioridade) {
        v.testeTitulo(titulo);
        v.testeCadastro(documentos.containsKey(titulo));

        Documento d = documentos.get(titulo);
        Elemento e = new ElementoTexto(prioridade, valor);
        return d.criarElemento(e);
    }

    /**
     * Cria um elemento de lista no documento com o título especificado.
     *
     * @param titulo o título do documento
     * @param valorLista o valor da lista
     * @param prioridade a prioridade do elemento
     * @param separador o separador dos itens da lista
     * @param charLista o caractere que representa a lista
     * @return o índice do elemento criado
     */
    public int criarLista(String titulo, String valorLista, int prioridade, String separador, String charLista) {
        v.testeTitulo(titulo);
        v.testeCadastro(documentos.containsKey(titulo));

        Documento d = documentos.get(titulo);
        Elemento e = new ElementoLista(prioridade, valorLista, separador, charLista);
        return d.criarElemento(e);
    }

    /**
     * Cria um elemento de termos no documento com o título especificado.
     *
     * @param titulo o título do documento
     * @param valorTermos os termos separados por um separador
     * @param prioridade a prioridade do elemento
     * @param separador o separador dos termos
     * @param ordem a organização da ordem que os termos serão apresentados
     * @return o índice do elemento criado
     */
    public int criarTermos(String titulo, String valorTermos, int prioridade, String separador, String ordem) {
        v.testeTitulo(titulo);
        v.testeCadastro(documentos.containsKey(titulo));

        Documento d = documentos.get(titulo);
        Elemento e = new ElementoTermos(valorTermos, prioridade, separador, ordem);
        return d.criarElemento(e);
    }

    /**
     * Cria um elemento de título no documento com o título especificado.
     *
     * @param titulo o título do documento
     * @param valor o valor do elemento de título
     * @param prioridade a prioridade do elemento
     * @param nivel o nível do título
     * @param linkavel indica se o título é linkável
     * @return o índice do elemento criado
     */
    public int criarTitulo(String titulo, String valor, int prioridade, int nivel, boolean linkavel) {
        v.testeTitulo(titulo);
        v.testeCadastro(documentos.containsKey(titulo));

        Documento d = documentos.get(titulo);
        Elemento e = new ElementoTitulo(valor, prioridade, nivel, linkavel);
        return d.criarElemento(e);
    }

    /**
     * Retorna a representação resumida do elemento na posição especificada no documento com o título especificado.
     *
     * @param titulo o título do documento
     * @param elementoPosicao a posição do elemento
     * @return a representação resumida do elemento
     */
    public String pegarrepresentacaoResumida(String titulo, int elementoPosicao) {
        v.testeTitulo(titulo);
        v.testeCadastro(documentos.containsKey(titulo));

        Documento d = documentos.get(titulo);
        return d.pegarrepresentacaoResumida(elementoPosicao);
    }

    /**
     * Retorna a representação completa do elemento na posição especificada no documento com o título especificado.
     *
     * @param titulo o título do documento
     * @param elementoPosicao a posição do elemento
     * @return a representação completa do elemento
     */
    public String pegarrepresentacaoCompleta(String titulo, int elementoPosicao) {
        v.testeTitulo(titulo);
        v.testeCadastro(documentos.containsKey(titulo));

        Documento d = documentos.get(titulo);
        return d.pegarrepresentacaoCompleta(elementoPosicao);
    }

    /**
     * Cria um atalho para o documento com o título especificado.
     *
     * @param titulo o título do documento
     * @param tituloRef o título do documento de referência para o atalho
     * @return o índice do atalho criado
     */
    public int criarAtalho(String titulo, String tituloRef) {
        v.testeTitulo(titulo); v.testeAtalho(documentos.get(tituloRef)); v.testeTitulo(tituloRef);
        v.testeCadastro(documentos.containsKey(titulo));

        Documento d = documentos.get(titulo);
        Documento r = documentos.get(tituloRef);
        Elemento documentoAtalho = r.serAtalho();
        return d.criarAtalho(documentoAtalho);
    }

    public Documento getDocumento(String titulo) {
        v.testeTitulo(titulo);
        v.testeCadastro(documentos.containsKey(titulo));

        return documentos.get(titulo);
    }

}
