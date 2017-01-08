using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MamagermentToolApi.Utils
{
    public class Constant
    {
        public static string baoMoiFeedUrl = "http://m.baomoi.com/trang[page].epi";
        public static string baoMoiHost = "http://m.baomoi.com";
        public static string replaceUrlBaoMoi = "[page]";
        public static string patternFeedBaoMoi = "<a.href=\"(.*.epi)\".title=\"(.*)\">\\s\\S.*\\s\\Simg.data-src=\"(.*)\".src.*\\s\\S.*\\s\\S.*\\s\\S.*\\s\\S.*\\s\\S.*\\s\\S.*\\s\\S.*\\s\\Sspan>(.*)<.*\\s\\S.*=\"(.*)\"><.*>\\s\\S.*[i>]\\s\\S*\\s\\S.*\\s(.*)";
        public static string patternReplaceDetailHeader = "<div.id=\"advMasthead\">[\\s\\S]*<div.class=\"site-wrap\">";
        public static string replaceDetailStringHeader = "<div class=\"main \"> <div class=\"site-wrap\">";
        public static string patternReplaceDetailFooter = "<footer.id=\"site-footer\">[\\s\\S]*<\\/footer>";
        public static string patternReplaceDetailSuggestFeeds = "<aside>[\\s\\S]*<\\/aside>";
        public static string patternReplaceDetailScript = "if..!isBot.&&.!isCached.&&.isDesktop[\\s\\S]*checkDesktopRedirect..;";
        public static string patternReplaceHomeButton = "<div.class=\"go-home\">[\\s\\S]*<\\/span>[\\s\\S].*";
        public static string patternReplaceBottomBar = "<div.class=\"pswp\"[\\s\\S]*<\\/div>";
    }
}
