using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(ConvertCurrency_GetJSon.Startup))]
namespace ConvertCurrency_GetJSon
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
