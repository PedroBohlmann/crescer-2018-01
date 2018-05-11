import Formulario from './scripts/formulario'
import ListaDeTarefas from './scripts/lista-de-tarefas'

const formulario = new Formulario()
const listaDeTarefas = new ListaDeTarefas()

formulario.vincularListaDeTarefas(listaDeTarefas)

// const ENTER_KEY_CODE = 13
// function txtNotasOnKeyDown(event){
//     if(event.keyCode===ENTER_KEY_CODE){
//         if(validarTxtNotas()){
//             criarNota()
//             txtNotas.value = ''
//         }
//     }
// }

// function criarNota(){
//     const id = guid()
//     const li = document.createElement('li')
//     const checkbox = document.createElement('input')
//     checkbox.setAttribute('type','checkbox')
//     checkbox.setAttribute('id',id)
    
//     const label = document.createElement('label')
//     label.innerHTML = txtNotas.value
//     label.setAttribute('for', id)

//     li.appendChild(checkbox)
//     li.appendChild(label)
//     ulNotasCriadas.appendChild(li)
// }

// function validarTxtNotas(){
//     //metodo tio da sukita
//     // const elTxtNotas = document.getElementById('txtNotas')
//     if(txtNotas.value.trim().length===0){
//         mostrarMesagem('campo obrigatorio')
//         return false
//     }
//     esconderMensagem()
//     return true
// }

// function mostrarMesagem(mensagem){
//     const elAlerta = document.getElementsByClassName('alerta')[0]
//     const elTextoAlerta = document.getElementsByClassName('texto-alerta')[0]

//     elAlerta.classList.remove('invisivel')
//     elTextoAlerta.innerHTML = mensagem
// }

// function esconderMensagem(){
//     const elAlerta = document.getElementsByClassName('alerta')[0]
//     if(!elAlerta.classList.contains('invisivel')){
//         elAlerta.classList.add('invisivel')
//     }
// }

// function guid() {
//     function s4() {
//       return Math.floor((1 + Math.random()) * 0x10000)
//         .toString(16)
//         .substring(1);
//     }
//     return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
//   }