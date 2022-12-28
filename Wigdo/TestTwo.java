package Wigdo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class TestTwo
{
        private ArrayList<String> arr1;


    public TestTwo() {
        arr1 = new ArrayList<>();
        mauriceBlackburnJobs();
    }
        public void mauriceBlackburnJobs () {
            final String url = "https://careers.pageuppeople.com/736/cw/en/filter/?search-keyword=&job-mail-subscribe-privacy=agree";
            try {
                final Document docObj = Jsoup.connect(url).get();

                Elements elementObj = docObj.select("*");

                for (Element row : elementObj.select("tr:nth-child(2n+1)")) {

                    if (row.parent().attributes().hashCode() == 1679553498)
                    {
                        System.out.println(row.select(".job-link").text());
                        arr1.add(row.select(".job-link").text());
                    }

                }
                System.out.println("\nthe First Job is: "  + arr1.get(0));

            }
             catch (Exception e) {
                e.printStackTrace();
            }
        }
    public static void main (String [] args)
        {
        TestTwo newTest = new TestTwo();
        }

}
