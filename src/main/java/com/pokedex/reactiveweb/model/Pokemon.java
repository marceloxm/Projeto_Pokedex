package com.pokedex.reactiveweb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Pokemon {

    @Id
    private String id;
    private String nome;
    private String categoria;
    private String habilidades;
    private Double peso;
    private String cor;
    private Double tamanho;

    public Pokemon() {
        super();
    }

    public Pokemon(String id, String nome, String categoria, String habilidades, Double peso, String cor, Double tamanho) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.habilidades = habilidades;
        this.peso = peso;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", habilidades='" + habilidades + '\'' +
                ", peso=" + peso +
                ", cor=" + cor +
                ", tamanho=" + tamanho +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pokemon)) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id) &&
                Objects.equals(nome, pokemon.nome) &&
                Objects.equals(categoria, pokemon.categoria) &&
                Objects.equals(habilidades, pokemon.habilidades) &&
                Objects.equals(peso, pokemon.peso) &&
                Objects.equals(cor, pokemon.cor) &&
                Objects.equals(tamanho, pokemon.tamanho);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, categoria, habilidades, peso, cor, tamanho);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getTamanho() {
        return getTamanho();
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

}

}