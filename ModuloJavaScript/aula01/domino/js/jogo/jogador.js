class Jogador {
    constructor(tabuleiro) {
        this.pecasNaMao = new Array()
        this.tabuleiro = null
        if (tabuleiro instanceof Tabuleiro) {
            this.tabuleiro = tabuleiro
        }
    }

    recebePeca(peca) {
        if (peca instanceof Peca) {
            this.pecasNaMao.push(peca)
        }
        else {
            throw new JogadaInvalidaError('Jogador recebe algo que não é uma peça')
        }
    }

    jogaPeca(posicao, lugar) {
        if (posicao < this.pecasNaMao.length && posicao >= 0 && (lugar === 'l' || lugar === 'o')) {
            const pecaASerJogada = this.pecasNaMao[posicao]
            this.pecasNaMao[posicao] = null
            if (lugar === 'o') {
                this.tabuleiro.adicionarPecaOeste(pecaASerJogada)
            }
            else {
                this.tabuleiro.adicionarPecaLeste(pecaASerJogada)
            }
        }
        else {
            throw new JogadaInvalidaError('Jogador não pode jogar a peca nessa posicao')
        }
    }
}