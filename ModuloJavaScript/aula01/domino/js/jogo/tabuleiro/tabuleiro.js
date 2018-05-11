class Tabuleiro {
    constructor() {
        this.pecasNoTabuleiro = Array()
        this.valorLeste = null
        this.valorOeste = null
        this.quantidadeMaximaDePecas = 28
    }

    adicionarPecaOeste(peca) {
        if (peca instanceof Peca && this.pecasNoTabuleiro.length <= this.quantidadeMaximaDePecas) {
            if (this.pecasNoTabuleiro.length == 0) {
                this.valorLeste = peca.leste
                this.valorOeste = peca.oeste
                this.pecasNoTabuleiro.unshift(peca)
            }
            else if (!this.verificaSePecaJaFoiColocada(peca)) {
                if (this.valorOeste === peca.oeste) {
                    this.valorOeste = peca.leste
                }
                else if (this.valorOeste === peca.leste) {
                    this.valorOeste = peca.oeste
                }
                else {
                    throw new JogadaInvalidaError('Nenhum valor das pontas dessa peça combinam')
                }
                this.pecasNoTabuleiro.unshift(peca)
            }
            else {
                throw new JogadaInvalidaError('Peca ja foi colocada')
            }
        }
        else {
            throw new JogadaInvalidaError('Não é uma peça')
        }
    }

    adicionarPecaLeste(peca) {
        if (peca instanceof Peca && this.pecasNoTabuleiro.length <= this.quantidadeMaximaDePecas) {
            if (this.pecasNoTabuleiro.length == 0) {
                this.valorLeste = peca.leste
                this.valorOeste = peca.oeste
                this.pecasNoTabuleiro.push(peca)
            }
            else if (!this.verificaSePecaJaFoiColocada(peca)) {
                if (this.valorLeste === peca.oeste) {
                    this.valorLeste = peca.leste
                }
                else if (this.valorLeste === peca.leste) {
                    this.valorLeste = peca.oeste
                }
                else {
                    throw new JogadaInvalidaError('Nenhum valor das pontas dessa peça combinam')
                }
                this.pecasNoTabuleiro.push(peca)
            }
            else {
                throw new JogadaInvalidaError('Peca ja foi colocada')
            }
        }
        else {
            throw new JogadaInvalidaError('Não é uma peça')
        }
    }

    verificaSePecaJaFoiColocada(peca) {
        for (let i = 0; i < this.pecasNoTabuleiro.length; i++) {
            const item = this.pecasNoTabuleiro[i]
            if ((item.leste == peca.leste && item.oeste == peca.oeste) || (item.leste == peca.oeste && item.oeste == peca.leste)) {
                return true
            }
        }
        return false
    }
}