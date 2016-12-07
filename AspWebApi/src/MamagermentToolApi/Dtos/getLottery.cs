using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MamagermentToolApi.Dtos
{
    public class getLottery
    {
        public string title { get; set; }
        public string description { get; set; }
        public string link { get; set; }
        public string pubDate { get; set; }
    }
}
