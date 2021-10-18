package br.com.modelo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    private String nomeJogador;
    private Integer id;
    private Calendar dataEntrada;
    private LocalDateTime dataEntradaServidor;

    public Jogador() {

    }

   @XmlElementWrapper(name = "jogador")
   @XmlElement(name = "jogador")
   private Set<Item> jogador = new LinkedHashSet<Item>();

    public Jogador(String nomeJogador, Integer id, Calendar dataEntrada, LocalDateTime dataEntradaServidor) {
        this.nomeJogador = nomeJogador;
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataEntradaServidor = dataEntradaServidor;
    }

    public void adicionarJogador(Item jogador) {
        this.jogador.add(jogador);
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
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

    public LocalDateTime getDataEntradaServidor() {
        return dataEntradaServidor;
    }

    public void setDataEntradaServidor(LocalDateTime dataEntradaServidor) {
        this.dataEntradaServidor = dataEntradaServidor;
    }
}
