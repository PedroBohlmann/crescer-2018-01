using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dominio.Contratos;
using Dominio.Servicos;
using Infra;
using Infra.Repository;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Rewrite;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Options;
using Microsoft.IdentityModel.Tokens;
using Swashbuckle.AspNetCore.Swagger;

namespace Api
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme)
                .AddJwtBearer(options =>
                {
                    options.TokenValidationParameters = new TokenValidationParameters
                    {
                        ValidateAudience = false,
                        ValidateIssuer = false,
                        ValidateLifetime = true,
                        ValidateIssuerSigningKey = true,
                        IssuerSigningKey = new SymmetricSecurityKey
                            (Encoding.UTF8.GetBytes(Configuration["SecuritySettings:SigningKey"]))
                    };
                });

            services.Configure<SecuritySettings>(options => Configuration.GetSection("SecuritySettings").Bind(options));


            services.AddMvc();

            services.AddSwaggerGen(c =>
            {
                c.SwaggerDoc("v1", new Info { Title = "Aerolito lines", Version = "v1" });
                c.AddSecurityDefinition("Bearer", new ApiKeyScheme
                {
                    Description = "JWT Authorization header using the Bearer scheme. Example: \"Authorization: Bearer {token}\"",
                    Name = "Authorization",
                    In = "header",
                    Type = "apiKey"
                });
                c.AddSecurityRequirement(new Dictionary<string, IEnumerable<string>>
                {
                    { "Bearer", new string[] { } }
                });
            });

            var connectionString = Configuration.GetConnectionString("TccDB");

            services.AddDbContext<VooContext>(options => options.UseSqlServer(connectionString));

            services.AddScoped<VooContext, VooContext>();
            services.AddScoped<IReservaRepository, ReservaRepository>();
            services.AddScoped<ILocalRepository, LocalRepository>();
            services.AddScoped<ITrechoRepository, TrechoRepository>();
            services.AddScoped<IOpcionalRepository, OpcionalRepository>();
            services.AddScoped<IClasseDeVooRepository, ClasseDeVooRepository>();
            services.AddScoped<IUsuarioRepository, UsuarioRepository>();


            services.AddScoped<OpcionalService, OpcionalService>();
            services.AddScoped<LocalService, LocalService>();
            services.AddScoped<ReservaService, ReservaService>();
            services.AddScoped<ClasseDeVooService, ClasseDeVooService>();
            services.AddScoped<TrechoService, TrechoService>();
            services.AddScoped<UsuarioService, UsuarioService>();

            services.AddCors();
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            app.UseCors(builder => builder.WithOrigins("http://localhost:3000").AllowAnyMethod().AllowAnyHeader());

            // Diz que a aplicação utiliza os atributos de [Authorize]
            app.UseAuthentication();

            app.UseSwagger();

            app.UseSwaggerUI(c =>
            {
                c.SwaggerEndpoint("/swagger/v1/swagger.json", "Aerolito lines");
            });

            app.UseMvc();

            app.UseRewriter(new RewriteOptions().AddRedirect("^$", "swagger"));
        }
    }
}
