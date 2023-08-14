package documin;

import java.util.HashMap;
import java.util.Objects;
/**
 A classe Elemento é uma classe abstrata que representa um elemento de um documento.
 @author gabrielecalafange
 */
public abstract class Elemento {
    private int prioridade;
    private String valor;
    protected HashMap<String, String> propriedades = new HashMap<>();
    private Verificador v = new Verificador();

    /**
     Cria um novo elemento com a prioridade e valor especificados.
     @param prioridade a prioridade do elemento
     @param valor o valor do elemento
     */
    public Elemento(int prioridade, String valor) {
        v.testePrioridade(prioridade);

        this.prioridade = prioridade;
        this.valor = valor;
    }

    /**
     Retorna a representação completa do elemento.
     @return a representação completa do elemento
     */
    public abstract String representacaoCompleta();

    /**
     Retorna a representação resumida do elemento.
     @return a representação resumida do elemento
     */
    public abstract String representacaoResumida();

    /**
     Verifica se o elemento é um título.
     @return true se o elemento for um título, false caso contrário
     */
    public abstract boolean isTitulo();

    /**
     Verifica se o elemento é igual a outro objeto.
     @param o o objeto a ser comparado
     @return true se os objetos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Elemento elemento)) return false;
        return prioridade == elemento.prioridade && Objects.equals(valor, elemento.valor) && Objects.equals(propriedades, elemento.propriedades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prioridade, valor, propriedades);
    }

    @Override
    public String toString() {
        return valor;
    }
    public String getValor() {
        return valor;
    }

    public int getPrioridade() {
        return prioridade;
    }
}
