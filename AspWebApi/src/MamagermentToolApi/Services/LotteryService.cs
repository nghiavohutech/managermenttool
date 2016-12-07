using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using MamagermentToolApi.Dtos;
using MamagermentToolApi.Utils;
using Newtonsoft.Json;
using System.Xml.Linq;
using System.Xml.XPath;
using System.Net.Http;
using System.IO;

namespace MamagermentToolApi.Services
{
    public class LotteryService
    {
        public string GetLot(string mien)
        {
            string result;
            string page = "http://xskt.com.vn/rss-feed/" + mien + ".rss";
            List<getLottery> listItems = new List<getLottery>();
            var client = new HttpClient();
            var stream = client.GetStreamAsync(page).Result;
            XPathDocument doc = new XPathDocument(stream);
            XPathNavigator navigator = doc.CreateNavigator();
            XPathNodeIterator nodes = navigator.Select("//item");
            while (nodes.MoveNext())
            {
                XPathNavigator node = nodes.Current;
                listItems.Add(new getLottery
                {
                    description = node.SelectSingleNode("description").Value,
                    link = node.SelectSingleNode("link").Value,
                    pubDate = node.SelectSingleNode("pubDate").Value,
                    title = node.SelectSingleNode("title").Value
                });
            }
            result = JsonConvert.SerializeObject(listItems);
            return result;
        }
    }
}
