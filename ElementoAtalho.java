package documin;

/**
@author gabrielecalafange
 A classe ElementoAtalho representa um elemento de atalho para um documento.
 Ela herda da classe Elemento e implementa os métodos abstratos representacaoCompleta(),
 representacaoResumida() e isTitulo().
 */
public class ElementoAtalho extends Elemento {

    private String repCompleta;
    private String repResumo;

    /**
     Cria um novo elemento de atalho com a prioridade, valor, representação completa
     e representação resumida especificados.
     @param prioridade a prioridade do elemento
     @param valor o valor do elemento
     @param repCompleta a representação completa do elemento
     @param repResumo a representação resumida do elemento
     */
    public ElementoAtalho(int prioridade, String valor, String repCompleta, String repResumo) {
        super(prioridade, valor);
        this.repCompleta = repCompleta;
        this.repResumo = repResumo;
    }

    /**
     Retorna a representação completa do elemento de atalho.
     @return a representação completa do elemento de atalho
     */
    @Override
    public String representacaoCompleta() {
        return repCompleta;
    }

    /**
     Retorna a representação resumida do elemento de atalho.
     @return a representação resumida do elemento de atalho
     */
    @Override
    public String representacaoResumida() {
        return repResumo;
    }

    /**
     Verifica se o elemento de atalho é um título.
     @return false, pois o elemento de atalho não é um título
     */
    @Override
    public boolean isTitulo() {
        return false;
    }
}
