class Peca{
    constructor(oeste,leste){

        if(leste>Peca.VALOR_MAXIMO || oeste>Peca.VALOR_MAXIMO){
            throw new PecaError(`O número máximo do valor para o lado da peça é ${Peca.VALOR_MAXIMO}`)
        }
        if(leste<Peca.VALOR_MINIMO || oeste<Peca.VALOR_MINIMO){
            throw new PecaError(`O número minimo do valor para o lado da peça é ${Peca.VALOR_MINIMO}`)
        }

        this.leste=leste
        this.oeste=oeste
    }

    podeEncaixar(peca){
        if(peca instanceof Peca){
            if(!(this===peca)){
                return (this.leste==peca.leste || this.leste==peca.oeste) || (this.oeste==peca.leste || this.oeste==peca.oeste)
            }
        }
        else{
            throw new PecaError('Peca invalida')
        }
    }

    static get VALOR_MAXIMO(){
        return 6
    }

    static get VALOR_MINIMO(){
        return 0
    }
}