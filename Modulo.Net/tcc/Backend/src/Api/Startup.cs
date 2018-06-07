using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Dominio.Contratos;
using Dominio.Servicos;
using Infra;
using Infra.Repository;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Options;
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
            services.AddMvc();

            services.AddMvc();

            services.AddSwaggerGen(c =>
            {
                c.SwaggerDoc("v1", new Info { Title = "Aerolito lines", Version = "v1" });
            });

            var connectionString = Configuration.GetConnectionString("TccDB");

            services.AddDbContext<VooContext>(options => options.UseSqlServer(connectionString));

            services.AddScoped<VooContext,VooContext>();
            services.AddScoped<IReservaRepository,ReservaRepository>();
            services.AddScoped<ILocalRepository,LocalRepository>();
            services.AddScoped<ITrechoRepository,TrechoRepository>();
            services.AddScoped<IOpcionalRepository,OpcionalRepository>();
            services.AddScoped<IClasseDeVooRepository,ClasseDeVooRepository>();
            
            services.AddScoped<OpcionalService,OpcionalService>();
            services.AddScoped<LocalService,LocalService>();
            services.AddScoped<ReservaService,ReservaService>();
            services.AddScoped<ClasseDeVooService,ClasseDeVooService>();
            services.AddScoped<TrechoService,TrechoService>();
            
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            app.UseSwagger();

            app.UseSwaggerUI(c =>
            {
                c.SwaggerEndpoint("/swagger/v1/swagger.json", "Aerolito lines");
            });

            app.UseMvc();
        }
    }
}
