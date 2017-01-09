using ApiWeather.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Web;
using System.Web.Mvc;

namespace ApiWeather.Controllers
{
    public class WeatherCController : Controller
    {
        // GET: WeatherC
        sqldbweatherEntities db = new sqldbweatherEntities();
        public ActionResult Index()
        {
            List<TWeather> wth = db.TWeathers.ToList();
            return View(wth);
        }
        public ActionResult GetJson(string name, string coutry)
        {
            using (WebClient wc = new WebClient())
            {
                wc.Encoding = Encoding.UTF8;
                string json = wc.DownloadString(("http://api.openweathermap.org/data/2.5/weather?q=" + name + "," + coutry + "&appid=8e62cff8b7014d4615914d8b0c743c7e"));
                WeatherClass wthC = new WeatherClass(json);
                return View(wthC);
            }
        }
    }
}