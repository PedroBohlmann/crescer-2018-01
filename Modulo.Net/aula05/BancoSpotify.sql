CREATE TABLE Album (
    AlbumId INT IDENTITY(1,1) NOT NULL,
    Nome VARCHAR(50) NOT NULL,
)

ALTER TABLE dbo.Album ADD constraint PK_Album PRIMARY KEY (AlbumId)


CREATE TABLE Musica (
    MusicaId   INT IDENTITY(1,1) NOT NULL,
    Nome       VARCHAR(15) NOT NULL,
    Duracao    DECIMAL(4,2) NOT NULL,
    AlbumId    INTEGER NOT NULL
)

ALTER TABLE dbo.Musica ADD constraint PK_Musica PRIMARY KEY (MusicaId)

ALTER TABLE Musica
    ADD CONSTRAINT FK_Album FOREIGN KEY ( AlbumId )
        REFERENCES Album ( AlbumId )