package br.com.cwi.treinamento.java.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = { "id", "color" })
@RequiredArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class CarEntity {

    private Long id;

    private String model;

    private Color color;

    private Brand brand;

}
