import Tarefa from './tarefa'
import ListaDeTarefas from './lista-de-tarefas'
const ENTER_KEY_CODE=13

class Formulario{

    constructor(){
        this.listaDeTarefasVinculada = null
        this._configurar()
    }

    vincularListaDeTarefas(lista){
        this.listaDeTarefasVinculada = lista
    }

    _configurar(){
        txtNotas.addEventListener('keydown', event=>{
            if(event.keyCode=== ENTER_KEY_CODE){
                this._adicionarTarefa(txtNotas.value)
            }
        })
    }

    _adicionarTarefa(textoTarefa){
        const tarefaModel = new Tarefa(textoTarefa)
        if(tarefaModel.estaValida()){
            this._esconderMensagem()
            this.listaDeTarefasVinculada.adicionarTarefa()
            txtNotas.value = ''
        }
        else{
            this._mostrarMensagem('Tarefa invalida.')
        }
    }

    _validarTarefa(tarefa){

    }

    _mostrarMensagem(mensagem){

    }

    _esconderMensagem(){

    }
    
}

export default Formulario