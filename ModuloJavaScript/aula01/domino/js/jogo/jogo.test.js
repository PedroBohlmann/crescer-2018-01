test('jogo: popula as pecas do jogo de forma correta', assert => {
    const jogo = new Jogo()

    assert.isTrue(jogo.pecasDoJogo[0].verificaSeEIgual(new Peca(0, 0)))
    assert.isTrue(jogo.pecasDoJogo[1].verificaSeEIgual(new Peca(0, 1)))
    assert.isTrue(jogo.pecasDoJogo[2].verificaSeEIgual(new Peca(0, 2)))
    assert.isTrue(jogo.pecasDoJogo[3].verificaSeEIgual(new Peca(0, 3)))
    assert.isTrue(jogo.pecasDoJogo[4].verificaSeEIgual(new Peca(0, 4)))
    assert.isTrue(jogo.pecasDoJogo[5].verificaSeEIgual(new Peca(0, 5)))
    assert.isTrue(jogo.pecasDoJogo[6].verificaSeEIgual(new Peca(0, 6)))
    assert.isTrue(jogo.pecasDoJogo[7].verificaSeEIgual(new Peca(1, 1)))
    assert.isTrue(jogo.pecasDoJogo[8].verificaSeEIgual(new Peca(1, 2)))
    assert.isTrue(jogo.pecasDoJogo[9].verificaSeEIgual(new Peca(1, 3)))
    assert.isTrue(jogo.pecasDoJogo[10].verificaSeEIgual(new Peca(1, 4)))
    assert.isTrue(jogo.pecasDoJogo[11].verificaSeEIgual(new Peca(1, 5)))
    assert.isTrue(jogo.pecasDoJogo[12].verificaSeEIgual(new Peca(1, 6)))
    assert.isTrue(jogo.pecasDoJogo[13].verificaSeEIgual(new Peca(2, 2)))
    assert.isTrue(jogo.pecasDoJogo[14].verificaSeEIgual(new Peca(2, 3)))
    assert.isTrue(jogo.pecasDoJogo[15].verificaSeEIgual(new Peca(2, 4)))
    assert.isTrue(jogo.pecasDoJogo[16].verificaSeEIgual(new Peca(2, 5)))
    assert.isTrue(jogo.pecasDoJogo[17].verificaSeEIgual(new Peca(2, 6)))
    assert.isTrue(jogo.pecasDoJogo[18].verificaSeEIgual(new Peca(3, 3)))
    assert.isTrue(jogo.pecasDoJogo[19].verificaSeEIgual(new Peca(3, 4)))
    assert.isTrue(jogo.pecasDoJogo[20].verificaSeEIgual(new Peca(3, 5)))
    assert.isTrue(jogo.pecasDoJogo[21].verificaSeEIgual(new Peca(3, 6)))
    assert.isTrue(jogo.pecasDoJogo[22].verificaSeEIgual(new Peca(4, 4)))
    assert.isTrue(jogo.pecasDoJogo[23].verificaSeEIgual(new Peca(4, 5)))
    assert.isTrue(jogo.pecasDoJogo[24].verificaSeEIgual(new Peca(4, 6)))
    assert.isTrue(jogo.pecasDoJogo[25].verificaSeEIgual(new Peca(5, 5)))
    assert.isTrue(jogo.pecasDoJogo[26].verificaSeEIgual(new Peca(5, 6)))
    assert.isTrue(jogo.pecasDoJogo[27].verificaSeEIgual(new Peca(6, 6)))
})

test('jogo: jogadores recebem suas pecas', assert => {
    const jogo = new Jogo()

    jogo.iniciaJogo()

    assert.equals(7, jogo.jogadorUm.pecasNaMao.length)
    assert.equals(7, jogo.jogadorDois.pecasNaMao.length)
})

test('jogo: jogadorUm saca mais uma peca', assert => {
    const jogo = new Jogo()

    jogo.iniciaJogo()

    assert.equals(7, jogo.jogadorUm.pecasNaMao.length)

    jogo.jogadorUmSacaUmaQuantiaDePecas(1)

    assert.equals(8, jogo.jogadorUm.pecasNaMao.length)
})

test('jogo: jogadorDois saca mais uma peca',assert=>{
    const jogo = new Jogo()

    jogo.iniciaJogo()

    assert.equals(7, jogo.jogadorDois.pecasNaMao.length)

    jogo.jogadorDoisSacaUmaQuantiaDePecas(1)

    assert.equals(8, jogo.jogadorDois.pecasNaMao.length)
})

test('jogo: testa quantidade de pecas validas em um jogo',assert=>{
    const jogo = new  Jogo()
    
    jogo.iniciaJogo()

    assert.isTrue(jogo.verificaSeAindaHaPecasValidas())
})

test('jogo: testa quantidade de peças validas em um jogo que não possui mais peças validas',assert=>{
    const jogo = new  Jogo()
    
    jogo.iniciaJogo()

    jogo.jogadorUmSacaUmaQuantiaDePecas(14)

    assert.isFalse(jogo.verificaSeAindaHaPecasValidas())
})