using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Helpers;

namespace ApiWeather.Models
{
    public class WeatherClass
    {
        public WeatherClass(string json)
        {
            JObject jObject = JObject.Parse(json);
            name = (string)jObject["name"];
            description = (string)jObject["weather"][0]["description"];
            wind = (string)jObject["wind"]["speed"];
            tempmax = (string)jObject["main"]["temp_min"];
            tempmin = (string)jObject["main"]["temp_max"];
            icon = (string)jObject["weather"][0]["icon"];
            JToken jcoord = jObject["coord"];
            coords = (string)jcoord["lat"] + "," +(string)jcoord["lon"];
        }
        public string name;
        public string description;
        public string wind;
        public string tempmin;
        public string tempmax;
        public string icon;
        public string coords;
    }
}