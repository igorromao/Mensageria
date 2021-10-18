package br.com.modelo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Dominio Jogador.
 * @version 1.1 - 15/10/21
 * @auhtor Igor Romão
 * @since 15/10/21
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Jogador implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nomeServidor;
    private Integer id;
    private Calendar dataEntrada;

    public Jogador() {

    }

   @XmlElementWrapper(name = "jogador")
   @XmlElement(name = "jogador")
   private Set<Item> jogador = new LinkedHashSet<>();

    public Jogador(String nomeServidor, Integer id, Calendar dataEntrada) {
        this.nomeServidor = nomeServidor;
        this.id = id;
        this.dataEntrada = dataEntrada;
    }

    public void adicionarJogador(Item jogador) {
        this.jogador.add(jogador);
    }

    public String getNomeServidor() {
        return nomeServidor;
    }

    public void setNomeServidor(String nomeServidor) {
        this.nomeServidor = nomeServidor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Calendar dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Set<Item> getJogador() {
        return jogador;
    }

    public void setJogador(Set<Item> jogador) {
        this.jogador = jogador;
    }
}
