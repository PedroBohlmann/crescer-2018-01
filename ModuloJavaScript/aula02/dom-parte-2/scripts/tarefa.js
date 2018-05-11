class Tarefa{
    constructor(texto){
        this.texto = texto
        this.id = this._criarId()
    }

    estaValida(){
        return this.texto.trim().length>0
    }

    _criarId() {
        function s4() {
          return Math.floor((1 + Math.random()) * 0x10000)
            .toString(16)
            .substring(1);
        }
        return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
    }
}

export default Tarefa
