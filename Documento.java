package documin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
/**
 A classe Documento representa um documento com elementos.
 @author gabrielecalafange
 */

public class Documento {

    private String titulo;
    private int tamanhoMaximo;
    private ArrayList<Elemento> elementos;
    private int posicaoArray = 1;
    private Verificador v = new Verificador();

    /**
     Cria um novo documento com o título e tamanho máximo especificados.
     @param titulo o título do documento
     @param tamanhoMaximo o tamanho máximo do documento
     */
    public Documento(String titulo, int tamanhoMaximo) {
        this.titulo = titulo;
        this.tamanhoMaximo = tamanhoMaximo;
        this.elementos = new ArrayList<>(tamanhoMaximo);
    }

    /**
     Cria um novo documento com o título especificado.
     @param titulo o título do documento
     */
    public Documento(String titulo) {
        this.titulo = titulo;
        this.elementos = new ArrayList<>();
    }

    /**
     Verifica se o documento é igual a outro objeto.
     @param o o objeto a ser comparado
     @return true se o objeto for igual ao documento, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Documento)) return false;
        Documento documento = (Documento) o;
        return titulo.equals(documento.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }

    /**
     Retorna a quantidade de elementos no documento.
     @return a quantidade de elementos no documento
     */
    public int elementosQtd() {
        if (elementos.isEmpty()) {return 0;}
        return elementos.size();
    }

    public String getElementoIdx(int idx) {
        return elementos.get(idx).toString();
    }

    /**
     Retorna a representação dos elementos do documento como um array de strings.
     @return a representação dos elementos do documento
     */
    public String[] representacao() {
        String[] s = new String[elementos.size()];
        int i = 0;
        for (Elemento elemento: elementos) {
            if (elemento != null) {s[i++] = elemento.toString();}
        } return s;
    }

    /**
     Cria um novo elemento e adiciona ao documento.
     @param e o elemento a ser adicionado
     @return a posição do elemento no documento
     */
    public int criarElemento(Elemento e) {
        //if (elementos.isEmpty()) {elementos.set(0, e);}
        elementos.add(e);
       // elementos.set(posicaoArray++, e);
        return elementos.indexOf(e);
    }

    /**
     Remove o elemento na posição especificada do documento.
     @param posicao a posição do elemento a ser removido
     @return true se o elemento foi removido com sucesso, false caso contrário
     */
    public boolean apagarElemento(int posicao) {
        if (elementos.get(posicao) != null) {
            elementos.set(posicao, null);
            return true;}
        return false;
    }

    /**
     Move o elemento da posição especificada para cima no documento.
     @param posicao a posição do elemento a ser movido
     */
    public void moverAcima(int posicao) {
        if (posicao+1 > elementosQtd()) {throw new NullPointerException("Não há elementos acima.");}
        v.testeElemento(elementos.contains(elementos.get(posicao)));
        Collections.swap(elementos, posicao, posicao+1);
    }

    /**
     Move o elemento na posição especificada para baixo no documento.
     @param posicao a posição do elemento a ser movido para baixo
     */
    public void moverAbaixo (int posicao){
        if (posicao-1 < 0) {throw new NullPointerException("Não há elementos abaixo.");}
        v.testeElemento(elementos.contains(elementos.get(posicao)));
        Collections.swap(elementos, posicao,posicao-1);
    }

    /**
     Retorna a representação resumida do elemento na posição especificada.
     @param posicao a posição do elemento
     @return a representação resumida do elemento
     */
    public String pegarrepresentacaoResumida(int posicao) {
        v.testeElemento(elementos.contains(elementos.get(posicao)));
        return elementos.get(posicao).representacaoResumida();
    }

    /**
     Retorna a representação completa do elemento na posição especificada.
     @param posicao a posição do elemento
     @return a representação completa do elemento
     */
    public String pegarrepresentacaoCompleta(int posicao) {
        v.testeElemento(elementos.contains(elementos.get(posicao)));

        return elementos.get(posicao).representacaoCompleta();
    }

    /**
     Retorna a lista de elementos do documento.
     @return a lista de elementos
     */
    public ArrayList<Elemento> listaElementos() {
        return elementos;
    }

    /**
     Retorna a lista de elementos com prioridade igual ou maior que a especificada.
     @param prioridade a prioridade mínima dos elementos
     @return a lista de elementos com a prioridade especificada ou maior
     */
    public ArrayList<String> listaElementosPrioridades(int prioridade) {
        ArrayList<String> elementosPrioridade = new ArrayList<>();
        for (Elemento e: elementos) {
            if (e.getPrioridade() >= prioridade) {
                String representacao = e.representacaoCompleta();
                elementosPrioridade.add(representacao);
            }
        } return elementosPrioridade;
    }

    /**
     Retorna a lista de elementos do tipo título do documento.
     @return a lista de elementos título
     */
    public ArrayList<String> listaElementosTitulo() {
        ArrayList<String> elementosTitulo = new ArrayList<>();
        for (Elemento e: elementos) {
            if (e.isTitulo()) {
                elementosTitulo.add(e.representacaoResumida());
            }
        } return elementosTitulo;
    }

    /**
     Cria um atalho para outro documento e o adiciona ao documento atual.
     @param documentoAtalho o documento a ser referenciado pelo atalho
     @return a posição do elemento atalho no documento
     */
   public int criarAtalho(Elemento documentoAtalho) {
       elementos.add(documentoAtalho);
       return elementos.indexOf(documentoAtalho);
   }

    /**
     Retorna um elemento atalho para o documento em questão ser.
     @return o elemento de atalho para o próprio documento
     */
    public Elemento serAtalho() {
        int soma = 0;
        for (Elemento elemento: elementos) {
            soma += elemento.getPrioridade();
        }
        int prioridade = soma/elementos.size();
        Elemento documentoAtalho = new ElementoAtalho(prioridade, titulo, repCompleta(), repResumo());
        return documentoAtalho;
    }

    /**
     Retorna a representação completa do atalho que o documento é.
     @return a representação completa do elemento
     */
    private String repCompleta() {
        String saida = "";
        for (Elemento elemento: elementos) {
            if (elemento.getPrioridade() >= 4) {
                saida += elemento.representacaoCompleta() + "\n";}
        } return saida;
    }

    /**
     Retorna a representação resumida do atalho que o documento é.
     @return a representação resumida do elemento
     */
    private String repResumo() {
        String saida = "";
        for (Elemento elemento: elementos) {
            if (elemento.getPrioridade() >= 4) {
                saida += elemento.representacaoResumida() + "\n";}
        } return saida;
    }
}