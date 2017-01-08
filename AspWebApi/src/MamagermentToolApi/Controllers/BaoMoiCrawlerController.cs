using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MamagermentToolApi.Services;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;

// For more information on enabling Web API for empty projects, visit http://go.microsoft.com/fwlink/?LinkID=397860

namespace MamagermentToolApi.Controllers
{
    [Route("api/[controller]")]
    public class BaoMoiCrawlerController : Controller
    {
        BaoMoiCrawlerServices services = new BaoMoiCrawlerServices();
        // GET api/BaoMoiCrawler/GetFeed/{page}
        [HttpGet("GetFeed/{page}")]
        public string GetFeed(string page)
        {
            string result;
            result = services.GetFeed(page);
            return result;
        }

        [HttpGet("GetFeed")]
        public string GetFeed(int page)
        {
            string result;
            result = services.GetFeed(Convert.ToString(page));
            return result;
        }

        // GET api/BaoMoiCrawler/GetFeedDetail/{feedUrl}
        [HttpPost("GetFeedDetail")]
        public string GetFeedDetail(string feedUrl)
        {
            string result;
            result = services.GetFeedDetail(feedUrl);
            return result;
        }

    }
}
