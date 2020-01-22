
import java.io.IOException;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class GooglePlayVersionNameParser {
    public static String parse(String packageName) throws IOException {
        String version = null;
        Document doc = Jsoup.connect("https://play.google.com/store/apps/details?id=" + packageName + "&hl=en").timeout(30000).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6").referrer("http://www.google.com").get();

        Elements infoDivs = doc.select("div.hAyfc");
        Iterator infoDivsIterator = infoDivs.iterator();

        Element contentDiv;
        Element titleDiv;
        Elements verionDivs;
        Iterator verionDivsIterator;
        String title;
        while(infoDivsIterator.hasNext()) {
            contentDiv = (Element)infoDivsIterator.next();
            titleDiv = contentDiv.select("div.BgcNfc").first();
            verionDivs = contentDiv.select("span.htlgb");
            verionDivsIterator = verionDivs.iterator();
            title = null;
            if (titleDiv != null) {
                title = titleDiv.ownText();
            }

            if (title != null && title.equals("Current Version")) {
                while(verionDivsIterator.hasNext()) {
                    Element verionDiv = (Element)verionDivsIterator.next();
                    version = verionDiv.ownText();
                    if (!version.isEmpty()) break;
                }
                break;
            }
        }
        return version;
    }
}