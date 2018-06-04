namespace PetStore.Dominio.Entidades
{
    public class Categoria
    {
        private Categoria() { }

        public Categoria(string nome)
        {
            this.Nome = nome;
        }

        public int Id { get; set; }

        public string Nome { get; private set; }
    }
}