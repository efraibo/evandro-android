package sourceinformation.com.br.widgets_app.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private Integer codPessoa;
    private String nome;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(Integer codPessoa, String nome, String telefone) {
        this.codPessoa = codPessoa;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return codPessoa + "-" + nome + "-" + telefone;
    }

    public List<Pessoa> getPessoa() {

        Pessoa pessoa1 = new Pessoa(1, "Fernando", "123");
        Pessoa pessoa2 = new Pessoa(1, "Maria", "456");
        Pessoa pessoa3 = new Pessoa(1, "José", "789");

        List<Pessoa> Pessoas = new ArrayList<Pessoa>();

        Pessoas.add(pessoa1);

        Pessoas.add(pessoa2);

        Pessoas.add(pessoa3);

        return Pessoas;

    }

}
