package br.com.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Criação de jogadores.
 * @version 1.1 - 15/10/21
 * @auhtor Igor Romão
 * @since 15/10/21
 */
public class GerarJogador {
    public Jogador gerarJogadores() {

        Jogador jogador = new Jogador("Poderoso", 25,  geraData("15/10/2021"),gerarHorario());
       Item jogador1 = geraJogador(1, "Igor");
       Item jogador2 = geraJogador(2, "Maria");
       Item jogador3 = geraJogador(3, "Cascao");


       jogador.adicionarJogador(jogador1);
       jogador.adicionarJogador(jogador2);
       jogador.adicionarJogador(jogador3);

       return jogador;
    }

    private LocalDateTime gerarHorario(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime;
    }

    private Item geraJogador(int id, String nome) {
        return new Item(id,nome);
    }

    private Calendar geraData(String dataComString) {
        try {
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataComString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(data);
            return cal;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
