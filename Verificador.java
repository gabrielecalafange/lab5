package documin;

import java.util.NoSuchElementException;

public class Verificador {

    public void testeTitulo(String titulo) {
        if (titulo.isBlank() || titulo.isEmpty()) {
            throw new IllegalArgumentException("título inválido");
        }
    }

    public void testeCadastro(Boolean d) {
        if (!d) {
            throw new NoSuchElementException("doc não cadastrado");
        }
    }

    public void testeElemento(Boolean e) {
        if (!e) {
            throw new NoSuchElementException("elemento não cadastrado");
        }
    }

    public void testePrioridade(int p) {
        if (p < 0 || p > 5 ) {
            throw new IllegalArgumentException("prioridade inválida");
        }
    }

    public void testeAtalho(Documento d) {
        for (Elemento e: d.listaElementos()) {
            if (e instanceof ElementoAtalho) {
            throw new IllegalStateException("esse documento já possui atalho");}
        }
    }

}
