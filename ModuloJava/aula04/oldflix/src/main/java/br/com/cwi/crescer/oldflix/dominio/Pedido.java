package br.com.cwi.crescer.oldflix.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PEDIDO")
public class Pedido {

    private static final String SEQUENCE = "PEDIDO_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "ID_PEDIDO", nullable = false, precision = 10, unique = true)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_PEDIDO")
    private List<Locacao> locacoes;

    @Column( name = "VALOR", nullable = false)
    private double valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_PEDIDO")
    private StatusPedido status;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.locacoes = new ArrayList<>();
        this.valorTotal = 0;
        this.status = StatusPedido.ATIVO;
    }

    public void adicionaFita(Fita fita) {
        if (status == StatusPedido.ATIVO) {
            Locacao locacao = new Locacao(fita,this);
            locacoes.add(locacao);
            fita.loca();
            calcularValorTotal();
            this.status = StatusPedido.PENDENTE;
        }
    }

    public void adicionarFitas(List<Fita> novasFitas) {
        if (status == StatusPedido.ATIVO) {
            for (Fita fita : novasFitas) {
                fita.loca();
                Locacao locacao = new Locacao(fita,this);
                locacoes.add(locacao);
            }
        }
        verificaSeECombo();
        calcularValorTotal();
        status = StatusPedido.PENDENTE;
    }

    public void calcularValorTotal() {
        this.valorTotal = 0;
        for (Locacao locacao : locacoes) {
            this.valorTotal += locacao.getFita().getValor();
        }
    }

    public void devolveFita(Fita fita) {
        if (status == StatusPedido.PENDENTE) {
            Locacao locacao = locacoes.stream().filter(p -> p.getFita().equals(fita)).findFirst().orElseThrow(() -> new RuntimeException("Essa fita não está locada neste pedido"));
            locacao.devolve();
            locacao.getFita().entrega();
            if (quantidadeDeLocacoesLocados() == 0) {
                status = StatusPedido.FECHADO;
            }
        }
    }

    private int quantidadeDeLocacoesLocados() {
        int contador = 0;
        for (Locacao locacao : locacoes) {
            if (locacao.getStatus() == StatusLocacao.LOCADO) {
                contador++;
            }
        }
        return contador;
    }

    public void verificaSeECombo() {
        int quantidadeDeFitasBronze = quantidadeDeLocacoesComFitasBronze();
        int quantidadeDeFitasPratas = quantidadeDeLocacoesComFitasPrata();

        if (quantidadeDeFitasBronze > quantidadeDeFitasPratas && quantidadeDeFitasPratas > 0) {
            atualizaPrazoDeLocacoesNoCombo(Categoria.BRONZE.getPrazo());
        } else if (quantidadeDeFitasPratas > quantidadeDeFitasBronze && quantidadeDeFitasBronze > 0) {
            atualizaPrazoDeLocacoesNoCombo(Categoria.PRATA.getPrazo());
        }

    }

    private void atualizaPrazoDeLocacoesNoCombo(int dias) {
        for(Locacao locacao:locacoes){
            if(locacao.getFita().getCategoria()==Categoria.BRONZE||locacao.getFita().getCategoria()==Categoria.PRATA){
                locacao.atualizaPrazo(dias);
            }
        }
    }

    private int quantidadeDeLocacoesComFitasBronze() {
        int contador = 0;
        for (Locacao locacao : locacoes) {
            if (locacao.getFita().getCategoria() == Categoria.BRONZE) {
                contador++;
            }
        }
        return contador;
    }

    private int quantidadeDeLocacoesComFitasPrata() {
        int contador = 0;
        for (Locacao locacao : locacoes) {
            if (locacao.getFita().getCategoria() == Categoria.PRATA) {
                contador++;
            }
        }
        return contador;
    }
}

