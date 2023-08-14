package documin;

/**
@author gabrielecalafange
 A classe ElementoTexto representa um elemento de texto em um documento.
 Ela herda da classe Elemento e implementa os métodos abstratos representacaoCompleta(),
 representacaoResumida() e isTitulo().
 */
public class ElementoTexto extends Elemento {

    /**
     Cria um novo elemento de texto com a prioridade e valor especificados.
     @param prioridade a prioridade do elemento
     @param valor o valor do elemento de texto
     */
    public ElementoTexto(int prioridade, String valor) {
        super(prioridade, valor);
    }

    /**
     Retorna a representação completa do elemento de texto.
     @return a representação completa do elemento de texto
     */
    @Override
    public String representacaoCompleta() {
        return super.getValor();
    }

    /**
     Retorna a representação resumida do elemento de texto.
     @return a representação resumida do elemento de texto
     */
    @Override
    public String representacaoResumida() {
        return super.getValor();
    }

    /**
     Verifica se o elemento de texto é um título.
     @return false, pois o elemento de texto não é um título
     */
    @Override
    public boolean isTitulo() {
        return false;
    }

}
