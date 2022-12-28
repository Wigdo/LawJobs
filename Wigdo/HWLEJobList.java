package Wigdo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class HWLEJobList {

    public HWLEJobList() {
        collateJobList();
    }
    public void collateJobList () {
        final String url = "https://hwlebsworth.com.au/careers/";
        try {
            final Document docObj = Jsoup.connect(url).get();

            Elements elementObj = docObj.select("*");

            for (Element row : elementObj.select("a[href]")) {
                System.out.println(row.attributes());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
