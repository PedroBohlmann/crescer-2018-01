class Peca{
    constructor(leste,oeste){
        this.VALOR_MAXIMO = 6
        this.VALOR_MINIMO = 0

        if(leste>this.VALOR_MAXIMO || oeste>this.VALOR_MAXIMO){
            throw new PecaError(`O número máximo do valor para o lado da peça é ${this.VALOR_MAXIMO}`)
        }
        if(leste<this.VALOR_MINIMO || oeste<this.VALOR_MINIMO){
            throw new PecaError(`O número minimo do valor para o lado da peça é ${this.VALOR_MINIMO}`)
        }

        this.leste=leste
        this.oeste=oeste
    }

    podeEncaixar(peca){
        if(peca instanceof Peca){
            if(this===peca){
                return (this.leste==peca.leste || this.leste==peca.oeste) || (this.oeste==peca.leste || this.oeste==peca.oeste)
            }
        }
    }
}