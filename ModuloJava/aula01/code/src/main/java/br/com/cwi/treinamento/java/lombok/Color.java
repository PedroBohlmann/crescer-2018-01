package br.com.cwi.treinamento.java.lombok;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Color {

    private final int red;

    private final int green;

    private final int blue;

}
