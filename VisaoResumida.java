package documin;

import java.util.Arrays;

/**
 * @author gabrielecalafange
 A classe VisaoResumida representa a visão resumida de um documento, exibindo a representação resumida de cada elemento.
 Ela herda da classe Visao e implementa o método exibirVisao().
 */
public class VisaoResumida extends Visao {

    /**
     Cria uma nova instância da visão resumida com base no documento fornecido.
     @param doc o documento a ser visualizado
     */
    public VisaoResumida(Documento doc) {
        super(doc);
    }

    /**
     * Exibe a visão resumida do documento, contendo a representação resumida de cada elemento.
     *
     * @return um array de strings contendo as representações resumidas dos elementos do documento
     */
    @Override
    public String[] exibirVisao() {
        Documento doc = super.getDoc();
        String[] array = new String[doc.elementosQtd()];

        for (int i = 0; i <= doc.elementosQtd()-1; i++) {
            array[i] = doc.pegarrepresentacaoResumida(i);
        }
        return array;
    }
}
