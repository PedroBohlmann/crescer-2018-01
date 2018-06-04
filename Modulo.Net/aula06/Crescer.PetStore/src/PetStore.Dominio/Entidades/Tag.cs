namespace PetStore.Dominio.Entidades
{
    public class Tag
    {
        private Tag() { }

        public Tag(string descricao)
        {
            this.Descricao = descricao;
        }
        
        public int Id { get; set; }

        public string Descricao { get; private set; }
    }
}