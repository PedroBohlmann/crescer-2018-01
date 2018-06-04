namespace PetStore.Dominio.Entidades
{
    public class UsuarioPet
    {
        private UsuarioPet() { }

        public UsuarioPet(Usuario usuario, Pet pet)
        {
            this.Usuario = usuario;
            this.Pet = pet;
        }

        public int Id { get; set; }

        public Usuario Usuario { get; private set; }

        public Pet Pet { get; private set; }
    }
}