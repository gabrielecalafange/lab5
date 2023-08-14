package documin;

import java.util.Arrays;

/**
 * @author gabrielecalafange
A classe VisaoCompleta representa a visão completa de um documento, exibindo a representação completa de cada elemento.
Ela herda da classe Visao e implementa o método exibirVisao().
 */
public class VisaoCompleta extends Visao {

    /**
     Cria uma nova instância da visão completa com base no documento fornecido.
     @param doc o documento a ser visualizado
     */
    public VisaoCompleta(Documento doc) {
        super(doc);
    }

    /**
     * Exibe a visão completa do documento, contendo a representação completa de cada elemento.
     *
     * @return um array de strings contendo as representações completas dos elementos do documento
     */
    @Override
    public String[] exibirVisao() {
        Documento doc = super.getDoc();
        String[] array = new String[doc.elementosQtd()];

        for (int i = 0; i <= doc.elementosQtd()-1; i++) {
            array[i] = doc.pegarrepresentacaoCompleta(i);
        }
        return array;
    }
}
