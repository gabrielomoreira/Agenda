package br.com.infnet.agenda.ui.model;

import java.io.Serializable;

public class Contato implements Serializable {

    private final String nome;
    private final String telefone;
    private final String email;
    private final String cidade;

    public Contato(String nome, String telefone, String email, String cidade) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCidade() {
        return cidade;
    }


}
