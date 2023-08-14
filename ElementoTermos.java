package documin;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


/**
@author gabrielecalafange
 A classe ElementoTermos representa um elemento de termos em um documento.
 Ela herda da classe Elemento e implementa os métodos abstratos representacaoCompleta(),
 representacaoResumida() e isTitulo().
 */

public class ElementoTermos extends Elemento {

    /**
     Cria um novo elemento de termos com o valor dos termos, prioridade, separador e ordem especificados.
     @param valorTermos o valor dos termos do elemento
     @param prioridade a prioridade do elemento
     @param separador o separador utilizado para separar os termos
     @param ordem a ordem de apresentação dos termos (ALFABÉTICA, TAMANHO ou NENHUM)
     */
    public ElementoTermos(String valorTermos, int prioridade, String separador, String ordem) {
        super(prioridade, valorTermos);
        propriedades.put("separador", separador);
        propriedades.put("ordem", ordem);
    }

    /**
     Retorna um array de termos em ordem alfabética.
     @param str a string contendo os termos separados pelo separador
     @param sep o separador utilizado para separar os termos
     @return um array de termos em ordem alfabética
     */
    private String[] ordemAlfabetica(String str, String sep) {
        sep = propriedades.get("separador");
        String[] array = str.split(sep);
        Collections.sort(Arrays.asList(array), String.CASE_INSENSITIVE_ORDER);
        return array;
    }

    /**
     Retorna um array de termos em ordem de tamanho decrescente.
     @param str a string contendo os termos separados pelo separador
     @param sep o separador utilizado para separar os termos
     @return um array de termos em ordem de tamanho decrescente
     */
    private String[] ordemTamanho(String str, String sep) {
        sep = propriedades.get("separador");
        String[] array = str.split(sep);
        Arrays.sort(array, Comparator.comparingInt(String::length).reversed());;
        return array;
    }

    /**
     Retorna a representação completa do elemento de termos.
     @return a representação completa do elemento de termos
     */
    @Override
    public String representacaoCompleta() {
        String sep = propriedades.get("separador");
        String ordem = propriedades.get("ordem");
        String str = "-"; int termos = 0;

        if (ordem.equals("ALFABÉTICA")) {
            for (String palavra: ordemAlfabetica(super.getValor(), sep)) {
                str += palavra + ", ";
                termos += 1;
            }
        }

        if (ordem.equals("TAMANHO")) {
            for (String palavra: ordemTamanho(super.getValor(), sep)) {
                str += palavra + ", ";
                termos += 1;
            }
        }
        
        if (ordem.equals("NENHUM")) {
            for (String palavra : super.getValor().split(sep)) {
                str += palavra + ", ";
                termos += 1;
            }
        }

        return "Total termos: " + termos + "\n" + str.substring(0,str.length()-3);
    }

    /**
     Retorna a representação resumida do elemento de termos.
     @return a representação resumida do elemento de termos
     */
    @Override
    public String representacaoResumida() {
        String sep = propriedades.get("separador");
        String ordem = propriedades.get("ordem");
        String str = "";

        if (ordem.equals("ALFABÉTICA")) {
            for (String palavra: ordemAlfabetica(super.getValor(), sep)) {
                str += palavra + sep;
            }
        }

        if (ordem.equals("TAMANHO")) {
            for (String palavra: ordemTamanho(super.getValor(), sep)) {
                str += palavra + sep;
            }
        }

        if (ordem.equals("NENHUM")) {
            for (String palavra : super.getValor().split(sep)) {
                str += palavra + sep;
            }
        }

        return str;
    }

    /**
     Verifica se o elemento de termos é um título.
     @return false, pois o elemento de termos não é um título
     */

    @Override
    public boolean isTitulo() {
        return false;
    }
}
