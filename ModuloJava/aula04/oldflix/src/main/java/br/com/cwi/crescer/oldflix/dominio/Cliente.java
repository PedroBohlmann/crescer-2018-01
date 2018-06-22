package br.com.cwi.crescer.oldflix.dominio;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name="CLIENTE")
public class Cliente {

    private static final String SEQUENCE = "CLIENTE_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    @Column(name = "ID_CLIENTE", nullable = false, precision = 10, unique = true)
    private Long id;
    @Column(name="NOME",nullable = false,length = 30)
    private String nome;

    @Column(name="CPF",nullable = false,length = 11,unique = true)
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(){ }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
