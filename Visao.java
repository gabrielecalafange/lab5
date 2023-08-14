package documin;
/**
 A classe abstrata Visao representa uma visualização de um documento.
 @author gabrielecalafange
 */
public abstract class Visao {
    private Documento tituloDoc;
    private int prioridade;

    /**
     Cria uma nova instância de Visao com o documento especificado.
     @param tituloDoc o documento associado à visão
     */
    public Visao(Documento tituloDoc) {
        this.tituloDoc = tituloDoc;
    }

    /**
     Cria uma nova instância de Visao com o documento e a prioridade especificados.
     @param doc o documento associado à visão
     @param prioridade a prioridade da visão
     */
    public Visao(Documento doc, int prioridade) {
        this.tituloDoc = doc;
        this.prioridade = prioridade;
    }

    /**
     * Retorna a representação da visão como um array de strings.
     *
     * @return a representação da visão
     */
    public abstract String[] exibirVisao();
    public Documento getDoc() {
        return tituloDoc;
    }

    public int getPrioridade() {
        return prioridade;
    }

}
