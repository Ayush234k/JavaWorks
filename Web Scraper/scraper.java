import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class scraper {

    public static void main(String[] args) {
        String url = "https://www.example.com"; 

        try {
            Document document = Jsoup.connect(url).get();

            Elements headlines = document.select("h1");
            for (Element headline : headlines) {
                System.out.println(headline.text());
            }

            Elements links = document.select("a[href]");
            for (Element link : links) {
                System.out.println(link.attr("abs:href")); 
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}