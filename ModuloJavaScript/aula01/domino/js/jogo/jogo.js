class Jogo{
    constructor(){
        this.pecasDoJogo = Array()

        for(let x = 0; x<=6 ;x++){
            for(let y = x; y<=6;y++){
                const peca = new Peca(x,y)
                this.pecasDoJogo.push(peca)
            }
        }
    }
}