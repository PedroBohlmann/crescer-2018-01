using Crescer.PetStore.Api.Model.Enum;

namespace Crescer.PetStore.Api.Model
{
    public class Usuario
    {
        public int Id{get;set;}

        public string Login{get;set;}

        public string PrimeiroNome{get;set;}

        public string UltimoNome{get;set;}

        public string Email{get;set;}
        
        public string Senha{private get;set;}

        public string PegaSenha(){
            return this.Senha;
        }        
        public string Telefone{get;set;}

        public StatusUsuario StatusUsuario{get;set;}
    }
}