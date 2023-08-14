package documin;


/**
@author gabrielecalafange
 A classe ElementoTitulo representa um elemento de título em um documento.
 Ela herda da classe Elemento e implementa os métodos abstratos representacaoCompleta(),
 representacaoResumida() e isTitulo().
 */
public class ElementoTitulo extends Elemento {

    boolean link;

    /**
     Cria um novo elemento de título com a prioridade, valor, nível e indicador de link especificados.
     @param prioridade a prioridade do elemento
     @param valor o valor do elemento de título
     @param nivel o nível do título
     @param linkavel indica se o título é linkável
     */
    public ElementoTitulo(String prioridade, int valor, int nivel, boolean linkavel) {
        super(valor, prioridade);
        propriedades.put("nivel", String.valueOf(nivel));
        propriedades.put("linkavel", String.valueOf(linkavel));
        this.link = linkavel;
    }

    /**
     Retorna a representação completa do elemento de título.
     @return a representação completa do elemento de título
     */

    @Override
    public String representacaoCompleta() {
        if (link == true) {
            return propriedades.get("nivel") + ". " + super.getValor() + " -- " + propriedades.get("nivel") + "- " + super.getValor().toUpperCase();
        } return propriedades.get("nivel") + ". " + super.getValor();
    }

    /**
     Retorna a representação resumida do elemento de título.
     @return a representação resumida do elemento de título
     */

    @Override
    public String representacaoResumida() {
        return propriedades.get("nivel") + ". " + super.getValor();
    }

    /**
     Verifica se o elemento de título é um título.
     @return true, pois o elemento de título é um título
     */
    @Override
    public boolean isTitulo() {
        return true;
    }
}
