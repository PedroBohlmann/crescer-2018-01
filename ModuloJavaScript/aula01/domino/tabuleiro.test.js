test('tabuleiro: tabuleiro deve começar vazio',assert=>{
    const tabuleiro=new Tabuleiro()

    assert.equals(0,tabuleiro.pecasNoTabuleiro.length)
})

test('tabuleiro: adicionar primeira peca define os valores',assert =>{
    const tabuleiro= new Tabuleiro()
    const peca = new Peca(1,4)

    tabuleiro.adicionarPecaOeste(peca)

    assert.equals(1,tabuleiro.valorOeste)
    assert.equals(4,tabuleiro.valorLeste)
    
})

test('tabuleiro: adicionar peça invalida ao leste causa erro',assert=>{
    assert.throws(JogadaInvalidaError,()=>{
        const tabuleiro= new Tabuleiro()
        const pecaInicial = new Peca(1,6)
        const pecaInvalida = new Peca(1,2)

        tabuleiro.adicionarPecaOeste(pecaInicial)
        tabuleiro.adicionarPecaLeste(pecaInvalida)
    })
})

test('tabuleiro: adicionar peça invalida ao oeste causa erro',assert=>{
    assert.throws(JogadaInvalidaError,()=>{
        const tabuleiro= new Tabuleiro()
        const pecaInicial = new Peca(6,1)
        const pecaInvalida = new Peca(1,2)

        tabuleiro.adicionarPecaOeste(pecaInicial)
        tabuleiro.adicionarPecaOeste(pecaInvalida)
    })
})

test('tabuleiro: adicionar peça valida a oeste funciona',assert =>{
    const tabuleiro = new Tabuleiro()
    const pecaA = new Peca(1,2)
    const pecaB = new Peca(3,1)

    tabuleiro.adicionarPecaOeste(pecaA)
    assert.equals(1,tabuleiro.valorOeste)

    tabuleiro.adicionarPecaOeste(pecaB)
    assert.equals(3,tabuleiro.valorOeste)
})

test('tabuleiro: adicionar peça valida se ela for virada a oeste funciona',assert =>{
    const tabuleiro = new Tabuleiro()
    const pecaA = new Peca(1,2)
    const pecaB = new Peca(1,3)

    tabuleiro.adicionarPecaOeste(pecaA)
    assert.equals(1,tabuleiro.valorOeste)

    tabuleiro.adicionarPecaOeste(pecaB)
    assert.equals(3,tabuleiro.valorOeste)
})

test('tabuleiro: adicionar peça a oeste é valido',assert =>{
    const tabuleiro = new Tabuleiro()
    const pecaInicial = new Peca(2,4)
    const pecaSecundaria = new Peca(1,2)

    tabuleiro.adicionarPecaLeste(pecaInicial)
    tabuleiro.adicionarPecaOeste(pecaSecundaria)

    assert.equals(1,tabuleiro.valorOeste)
    assert.equals(4,tabuleiro.valorLeste)
})

test('tabuleiro: adicionar peça a leste é valido',assert =>{
    const tabuleiro = new Tabuleiro()
    const pecaInicial = new Peca(2,4)
    const pecaSecundaria = new Peca(4,6)

    tabuleiro.adicionarPecaLeste(pecaInicial)
    tabuleiro.adicionarPecaLeste(pecaSecundaria)

    assert.equals(2,tabuleiro.valorOeste)
    assert.equals(6,tabuleiro.valorLeste)
})

test('tabuleiro: mesma peca não pode ser adicionada',assert=>{
    assert.throws(JogadaInvalidaError,()=>{
        const tabuleiro = new Tabuleiro()
        const peca = new Peca(1,1)

        tabuleiro.adicionarPecaOeste(peca)
        tabuleiro.adicionarPecaOeste(peca)
    })
})