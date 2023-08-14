package documin;

import java.util.Arrays;

/**
@author gabrielecalafange
 A classe VisaoPrioritaria representa a visão prioritária de um documento, exibindo apenas os elementos iguais ou acima de uma determinada prioridade.
 Ela herda da classe Visao e implementa o método exibirVisao().
 */
public class VisaoPrioritaria extends Visao {

    /**
     Cria uma nova instância da visão prioritária com base no documento e na prioridade fornecidos.
     @param doc o documento a ser visualizado
     @param prioridade a prioridade dos elementos a serem exibidos
     */
    public VisaoPrioritaria(Documento doc, int prioridade) {
        super(doc, prioridade);
    }


    /**
     * Exibe a visão completa do documento, contendo apenas os elementos com a prioridade especificada.
     *
     * @return um array de strings contendo as representações dos elementos com a prioridade especificada
     */
    @Override
    public String[] exibirVisao() {
        Documento doc = super.getDoc();
        int p = super.getPrioridade();
        String[] array = new String[doc.listaElementosPrioridades(p).size()];

        for (int i = 0; i < doc.listaElementosPrioridades(p).size(); i++) {
            array[i] = doc.listaElementosPrioridades(p).get(i);
        } return array;
    }
}
