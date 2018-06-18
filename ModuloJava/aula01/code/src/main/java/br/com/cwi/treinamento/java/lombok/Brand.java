package br.com.cwi.treinamento.java.lombok;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum Brand {

    FORD,
    FIAT,
    AUDI,
    CHEVROLET,
    KIA;

}
