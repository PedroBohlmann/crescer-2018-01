package models;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Cliente {
    private String nome;
    private String cpf;
}
