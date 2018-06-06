using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

namespace Infra.Migrations
{
    public partial class InitialMigration : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "ClasseDeVoo",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    Descricao = table.Column<string>(maxLength: 50, nullable: false),
                    ValorFixo = table.Column<double>(nullable: false),
                    ValorMilha = table.Column<double>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_ClasseDeVoo", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Local",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    Cidade = table.Column<string>(maxLength: 50, nullable: false),
                    Aeroporto = table.Column<string>(maxLength: 50, nullable: false),
                    Latitude = table.Column<double>(nullable: false),
                    Longitude = table.Column<double>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Local", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Opcional",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    Nome = table.Column<string>(maxLength: 50, nullable: false),
                    Descricao = table.Column<string>(maxLength: 50, nullable: false),
                    ValorPorcentagem = table.Column<double>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Opcional", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Trecho",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    OrigemId = table.Column<int>(nullable: true),
                    DestinoId = table.Column<int>(nullable: true),
                    DistanciaTotal = table.Column<double>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Trecho", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Trecho_Local_DestinoId",
                        column: x => x.DestinoId,
                        principalTable: "Local",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                    table.ForeignKey(
                        name: "FK_Trecho_Local_OrigemId",
                        column: x => x.OrigemId,
                        principalTable: "Local",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "Reserva",
                columns: table => new
                {
                    ClasseDeVooId = table.Column<int>(nullable: false),
                    TrechoId = table.Column<int>(nullable: false),
                    ValorTotal = table.Column<double>(nullable: false),
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Reserva", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Reserva_ClasseDeVoo_ClasseDeVooId",
                        column: x => x.ClasseDeVooId,
                        principalTable: "ClasseDeVoo",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Reserva_Trecho_TrechoId",
                        column: x => x.TrechoId,
                        principalTable: "Trecho",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateTable(
                name: "OpcionalReserva",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn),
                    OpcionalId = table.Column<int>(nullable: false),
                    ReservaId = table.Column<int>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_OpcionalReserva", x => x.Id);
                    table.ForeignKey(
                        name: "FK_OpcionalReserva_Opcional_OpcionalId",
                        column: x => x.OpcionalId,
                        principalTable: "Opcional",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_OpcionalReserva_Reserva_ReservaId",
                        column: x => x.ReservaId,
                        principalTable: "Reserva",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_OpcionalReserva_OpcionalId",
                table: "OpcionalReserva",
                column: "OpcionalId");

            migrationBuilder.CreateIndex(
                name: "IX_OpcionalReserva_ReservaId",
                table: "OpcionalReserva",
                column: "ReservaId");

            migrationBuilder.CreateIndex(
                name: "IX_Reserva_ClasseDeVooId",
                table: "Reserva",
                column: "ClasseDeVooId");

            migrationBuilder.CreateIndex(
                name: "IX_Reserva_TrechoId",
                table: "Reserva",
                column: "TrechoId");

            migrationBuilder.CreateIndex(
                name: "IX_Trecho_DestinoId",
                table: "Trecho",
                column: "DestinoId");

            migrationBuilder.CreateIndex(
                name: "IX_Trecho_OrigemId",
                table: "Trecho",
                column: "OrigemId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "OpcionalReserva");

            migrationBuilder.DropTable(
                name: "Opcional");

            migrationBuilder.DropTable(
                name: "Reserva");

            migrationBuilder.DropTable(
                name: "ClasseDeVoo");

            migrationBuilder.DropTable(
                name: "Trecho");

            migrationBuilder.DropTable(
                name: "Local");
        }
    }
}
