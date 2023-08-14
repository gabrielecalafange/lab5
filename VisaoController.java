package documin;

import java.util.ArrayList;

/**
 * A classe VisaoController é responsável por controlar as operações relacionadas às visões dos documentos.
 * @author gabrielecalafange
 */
public class VisaoController {
    private DocumentoController dc;
    private ArrayList<Visao> visoes = new ArrayList<>();

    /**
     * Constrói um objeto VisaoController com o controlador de documentos especificado.
     *
     * @param dc o controlador de documentos
     */
    public VisaoController(DocumentoController dc) {
        this.dc = dc;
    }

    /**
     * Cria uma visão completa do documento com o título especificado e a adiciona à lista de visões.
     *
     * @param tituloDoc o título do documento
     * @return o índice da visão criada na lista de visões
     */
    public int criarVisaoCompleta(String tituloDoc) {
        Documento doc = dc.getDocumento(tituloDoc);
        Visao v = new VisaoCompleta(doc);
        visoes.add(v);
        return visoes.indexOf(v);
    }

    /**
     * Cria uma visão resumida do documento com o título especificado e a adiciona à lista de visões.
     *
     * @param tituloDoc o título do documento
     * @return o índice da visão criada na lista de visões
     */
    public int criarVisaoResumida(String tituloDoc) {
        Documento doc = dc.getDocumento(tituloDoc);
        Visao v = new VisaoResumida(doc);
        visoes.add(v);
        return visoes.indexOf(v);
    }

    /**
     * Cria uma visão prioritária do documento com o título e a prioridade especificados e a adiciona à lista de visões.
     *
     * @param tituloDoc  o título do documento
     * @param prioridade a prioridade da visão
     * @return o índice da visão criada na lista de visões
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        Documento doc = dc.getDocumento(tituloDoc);
        Visao v = new VisaoPrioritaria(doc, prioridade);
        visoes.add(v);
        return visoes.indexOf(v);
    }

    /**
     * Cria uma visão do título do documento com o título especificado e a adiciona à lista de visões.
     *
     * @param tituloDoc o título do documento
     * @return o índice da visão criada na lista de visões
     */
    public int criarVisaoTitulo(String tituloDoc) {
        Documento doc = dc.getDocumento(tituloDoc);
        Visao v = new VisaoTitulo(doc);
        visoes.add(v);
        return visoes.indexOf(v);
    }

    /**
     * Exibe a visão com o ID especificado.
     *
     * @param visaoId o ID da visão
     * @return um array de strings que representa a visão
     */
    public String[] exibirVisao(int visaoId) {
        Visao v = visoes.get(visaoId);
        return v.exibirVisao();
    }
}

