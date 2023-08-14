package documin;
import java.util.regex.Pattern;


/**
@author gabrielecalafange
 A classe ElementoLista representa um elemento de lista em um documento.
 Ela herda da classe Elemento e implementa os métodos abstratos representacaoCompleta(),
 representacaoResumida() e isTitulo().
 */
public class ElementoLista extends Elemento {

    /**
     Cria um novo elemento de lista com a prioridade, valor da lista, separador e caractere da lista especificados.
     @param prioridade a prioridade do elemento
     @param valorLista o valor do elemento
     @param separador o separador utilizado na lista
     @param charLista o caractere utilizado para identificar os itens da lista
     */
    public ElementoLista(int prioridade, String valorLista, String separador, String charLista) {
        super(prioridade, valorLista);
        propriedades.put("separador", separador);
        propriedades.put("charLista", charLista);
    }

    /**
     Retorna a representação completa do elemento de lista.
     @return a representação completa do elemento de lista
     */
    @Override
    public String representacaoCompleta() {
        String item = propriedades.get("separador");
        String cl = propriedades.get("charLista");
        return cl + " " + super.getValor().replaceAll(Pattern.quote(" " + item), "\n"+ cl);
    }

    /**
     Retorna a representação resumida do elemento de lista.
     @return a representação resumida do elemento de lista
     */
    @Override
    public String representacaoResumida() {
        String item = propriedades.get("separador");
        return super.getValor().replaceAll(Pattern.quote(" " + item), item);
    }

    /**
     Verifica se o elemento de lista é um título.
     @return false, pois o elemento de lista não é um título
     */
    @Override
    public boolean isTitulo() {
        return false;
    }
}
