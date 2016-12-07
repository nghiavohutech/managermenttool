using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using MamagermentToolApi.Services;
using MamagermentToolApi.Dtos;

// For more information on enabling Web API for empty projects, visit http://go.microsoft.com/fwlink/?LinkID=397860

namespace MamagermentToolApi.Controllers
{
    [Route("api/[controller]")]
    public class LotteryController : Controller
    {
        LotteryService service = new LotteryService();
        [HttpGet("{mien}")]
        public string GetFeed(string mien)
        {
            string result;
            result = service.GetLot(mien);
            return result;
        }
    }
}
