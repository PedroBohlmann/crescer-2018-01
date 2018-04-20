package itens;

import corredores.Corredor;
import exceptions.AlvoInvalidoException;
import itens.tipos_de_itens.ataque.ItemDeAtaque;
import pistas.Pista;

import java.util.List;

public class CascoAzul implements ItemDeAtaque {

    @Override
    public void usarAlvo(Corredor corredorQueUsouItem, Corredor alvo) throws AlvoInvalidoException {
        Pista pista = corredorQueUsouItem.getPistaQuePertence();
        List<Corredor> listaDeCorredores = pista.getListaDeCorredores();

        Corredor primeiroCorredor = corredorQueUsouItem;

        for (Corredor corredorAtual : listaDeCorredores) {
            if (corredorAtual.getCasaAtual() != null) {
                if (corredorAtual.getCasaAtual().getNumeroDaCasa() > primeiroCorredor.getCasaAtual().getNumeroDaCasa()) {
                    primeiroCorredor = corredorAtual;
                }
            }
        }

        if (primeiroCorredor == corredorQueUsouItem || primeiroCorredor.getCasaAtual() != alvo.getCasaAtual()) {
            throw new AlvoInvalidoException();
        }

        int casaASerAtingida = alvo.getCasaAtual().getNumeroDaCasa();
        int danoASerCausado = casaASerAtingida - corredorQueUsouItem.getCasaAtual().getNumeroDaCasa();

        for (Corredor corredorAtual : listaDeCorredores) {
            if (corredorAtual.getCasaAtual() != null) {
                if (corredorAtual.getCasaAtual().getNumeroDaCasa() == casaASerAtingida) {
                    corredorAtual.recebeDano(danoASerCausado);
                }
            }
        }


    }
}
