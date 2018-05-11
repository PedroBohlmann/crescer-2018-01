class Jogo {
    constructor() {
        this.pecasDoJogo = Array()
        this.tabuleiro = new Tabuleiro
        for (let x = 0; x <= 6; x++) {
            for (let y = x; y <= 6; y++) {
                const peca = new Peca(x, y)
                this.pecasDoJogo.push(peca)
            }
        }
        this.jogadorUm = new Jogador(this.tabuleiro)
        this.jogadorDois = new Jogador(this.tabuleiro)
        this.maximoPecasNoInicio = 7
    }

    iniciaJogo() {
        while (this.jogadorUm.pecasNaMao.length < this.maximoPecasNoInicio) {
            const posicao = Math.floor(Math.random() * 28)
            if (this.pecasDoJogo[posicao] !== null) {
                this.jogadorUm.recebePeca(this.pecasDoJogo[posicao])
                this.pecasDoJogo[posicao] = null
            }
        }

        while (this.jogadorDois.pecasNaMao.length < this.maximoPecasNoInicio) {
            const posicao = Math.floor(Math.random() * 28)
            if (this.pecasDoJogo[posicao] !== null) {
                this.jogadorDois.recebePeca(this.pecasDoJogo[posicao])
                this.pecasDoJogo[posicao] = null
            }
        }
    }

    jogadorUmSacaUmaQuantiaDePecas(quantidade) {
        if (this.verificaSeAindaHaPecasValidas()) {
            while (quantidade !== 0) {
                const posicao = Math.floor(Math.random() * 28)
                if (this.pecasDoJogo[posicao] !== null) {
                    this.jogadorUm.recebePeca(this.pecasDoJogo[posicao])
                    this.pecasDoJogo[posicao] = null
                    quantidade--
                }
            }
        }
        else {
            throw new JogadaInvalidaException('Não há mais peças a serem sacadas')
        }
    }

    jogadorDoisSacaUmaQuantiaDePecas(quantidade) {
        if (this.verificaSeAindaHaPecasValidas()) {
            while (quantidade !== 0) {
                const posicao = Math.floor(Math.random() * 28)
                if (this.pecasDoJogo[posicao] !== null) {
                    this.jogadorDois.recebePeca(this.pecasDoJogo[posicao])
                    this.pecasDoJogo[posicao] = null
                    quantidade--
                }
            }
        }
        else {
            throw new JogadaInvalidaException('Não há mais peças a serem sacadas')
        }
    }

    verificaSeAindaHaPecasValidas() {
        let contadorDePecasValidas = 0
        for (let i = 0; i < this.pecasDoJogo.length; i++) {
            if (this.pecasDoJogo[i] !== null) {
                contadorDePecasValidas++
            }
        }
        return contadorDePecasValidas > 0
    }
}