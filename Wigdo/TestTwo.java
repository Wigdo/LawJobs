package Wigdo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TestTwo
{

    public static void main (String [] args)
    {
        final String url = "https://careers.pageuppeople.com/736/cw/en/filter/?search-keyword=&location=open%20australia%20wide&location=victoria&job-mail-subscribe-privacy=agree";

        try{
            final Document docObj = Jsoup.connect(url).get();

            for (Element row : docObj.select("tbody#search-results-content"))
            {
                    System.out.println(row.select(".job-link").text());
            }

            for (Element row : docObj.select("tbody#search-results-content"))
            {
                System.out.println(row.select(".location").text());
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
