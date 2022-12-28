package Wigdo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class MauriceBlackburnJobList
{
    private ArrayList<String> arr1;

    public MauriceBlackburnJobList() {
        arr1 = new ArrayList<>();
        getJobList();
    }
    public void getJobList () {
        final String url = "https://careers.pageuppeople.com/736/cw/en/filter/?search-keyword=&job-mail-subscribe-privacy=agree";
        try {
            final Document docObj = Jsoup.connect(url).get();

            Elements elementObj = docObj.select("*");

            for (Element row : elementObj.select("tr:nth-child(2n+1)")) {

                if (row.parent().attributes().hashCode() == 1679553498)
                {
                    System.out.println(row.select(".job-link").text());
                }

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main (String [] args)
    {
        MauriceBlackburnJobList newTest = new MauriceBlackburnJobList();
    }

}

