test('jogador: jogador recebe uma peça',assert =>{
    const tabuleiro = new Tabuleiro()
    const jogador = new Jogador(tabuleiro)
    const peca = new Peca(2,1)

    jogador.recebePeca(peca)

    jogador.jogaPeca(0,'l')

    const pecaResultado = tabuleiro.pecasNoTabuleiro[0]
    
    assert.equals(peca,pecaResultado)
})

test('jogador: jogador tenta receber algo que não é uma peca',assert=>{
    assert.throws(JogadaInvalidaError,()=>{
        const jogador = new Jogador()
        const peca = {
            leste:2,
            oeste:1
        }
    
        jogador.recebePeca(peca)
    
    })
})

test('jogador: jogador tenta jogar peca sendo que não possui alguma',assert=>{
    assert.throws(JogadaInvalidaError,()=>{
        const jogador = new Jogador(new Tabuleiro())
        
        const pecaResultado = jogador.jogaPeca(0,'l')
    })
})