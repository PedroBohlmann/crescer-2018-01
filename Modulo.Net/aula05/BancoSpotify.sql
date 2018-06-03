-- Album
CREATE TABLE Album (
    AlbumId INT IDENTITY(1,1) NOT NULL,
    Nome VARCHAR(50) NOT NULL,
)

ALTER TABLE dbo.Album ADD constraint PK_Album PRIMARY KEY (AlbumId)

-- Musica
CREATE TABLE Musica (
    MusicaId   INT IDENTITY(1,1) NOT NULL,
    Nome       VARCHAR(15) NOT NULL,
    Duracao    DECIMAL(4,2) NOT NULL,
    AlbumId    INTEGER NOT NULL
)

ALTER TABLE dbo.Musica ADD constraint PK_Musica PRIMARY KEY (MusicaId)

ALTER TABLE Musica
    ADD CONSTRAINT FK_Album FOREIGN KEY ( AlbumId )
        REFERENCES Album ( AlbumId ) ON DELETE CASCADE

-- Usuario 
CREATE TABLE Usuario (
    UsuarioId INT IDENTITY(1,1) NOT NULL,
    Nome VARCHAR(50) NOT NULL,
)

ALTER TABLE dbo.Usuario ADD constraint PK_Usuario PRIMARY KEY (UsuarioId)

-- Avaliacao 
CREATE TABLE Avaliacao (
    AvaliacaoId INT IDENTITY(1,1) NOT NULL,
    Nota int NOT NULL,
	UsuarioId int NOT NULL,
	MusicaId int NOT NULL
)

ALTER TABLE dbo.Avaliacao ADD constraint PK_Avaliacao PRIMARY KEY (AvaliacaoId)

ALTER TABLE Avaliacao ADD FOREIGN KEY (UsuarioId) REFERENCES Usuario(UsuarioID) ON DELETE CASCADE;

ALTER TABLE Avaliacao ADD FOREIGN KEY (MusicaId) REFERENCES Musica(MusicaId) ON DELETE CASCADE;
