package documin;

import java.util.Arrays;

/**
@author gabrielecalafange
 A classe VisaoTitulo representa a visão de um documento contendo apenas os elementos de título.
 Ela herda da classe Visao e implementa o método exibirVisao().
 */
public class VisaoTitulo extends Visao {

    /**
     Cria uma nova instância da visão de título com base no documento fornecido.
     @param doc o documento a ser visualizado
     */
    public VisaoTitulo(Documento doc) {
        super(doc);
    }

    /**
     * Exibe a visão do documento, contendo apenas os elementos de título.
     *
     * @return um array de strings contendo os elementos de título do documento
     */
    @Override
    public String[] exibirVisao() {
        Documento doc = super.getDoc();
        String[] array = new String[doc.listaElementosTitulo().size()];

        for (int i = 0; i < doc.listaElementosTitulo().size(); i++) {
            array[i] = doc.listaElementosTitulo().get(i);

        } return array;
    }
}
