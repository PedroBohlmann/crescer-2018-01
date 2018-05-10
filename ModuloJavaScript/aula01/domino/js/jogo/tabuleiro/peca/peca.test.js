test('peca: peca 6/5 encaixa com peca 5/1', assert =>{
    const pecaA = new Peca(6,1)
    const pecaB = new Peca(5,1)

    assert.isTrue(pecaA.podeEncaixar(pecaB))
})

test('peca: peca 1/1 não encaixa com 2/4.',assert =>{
    const pecaA = new Peca(1,1)
    const pecaB = new Peca(2,4)

    assert.isFalse(pecaA.podeEncaixar(pecaB))
})

test('peca: criar peça 7/1 resulta erro.', assert=>{
    assert.throwsWithMessage(PecaError,`O número máximo do valor para o lado da peça é ${Peca.VALOR_MAXIMO}`,()=>{
        const peca = new Peca(7,1)
    })
})

test('peca: criar peça -1/4 resulta em erro.',assert=>{
    assert.throwsWithMessage(PecaError,`O número minimo do valor para o lado da peça é ${Peca.VALOR_MINIMO}`,()=>{
        const peca = new Peca(-1,4)
    })
})