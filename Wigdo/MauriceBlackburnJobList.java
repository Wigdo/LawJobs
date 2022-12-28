package Wigdo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class MauriceBlackburnJobList
{
    private ArrayList<String> jobArray;
    private ArrayList<String> locationArray;

    public MauriceBlackburnJobList() {
        jobArray = new ArrayList<>();
        locationArray = new ArrayList<>();
        collateJobList();
    }
    public void collateJobList () {
        final String url = "https://careers.pageuppeople.com/736/cw/en/filter/?search-keyword=&job-mail-subscribe-privacy=agree";
        try {
            final Document docObj = Jsoup.connect(url).get();

            Elements elementObj = docObj.select("*");

            for (Element row : elementObj.select("tr:nth-child(2n+1)")) {

                if (row.parent().attributes().hashCode() == 1679553498)
                {
                    jobArray.add(row.select(".job-link").text());
                    locationArray.add(row.select(".location").text());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayJobs ()
    {
        int i=0;
        for (i=0; i < jobArray.size(); i++)
        {
            System.out.println(jobArray.get(i));
        }
    }

    public void displayJobLocations ()
    {
        int i =0;
        for (i=0; i < locationArray.size(); i++)
        {
            System.out.println(locationArray.get(i));
        }
    }

    public String getJobAtIndex (int index)
    {
        if (jobArray.size() >= index)
        {
            return jobArray.get(index);
        }
        else
        {
            return null;
        }
    }

    public String getLocationAtIndex (int index)
    {
        if (locationArray.size() >= index)
        {
            return locationArray.get(index);
        }
        else
        {
            return null;
        }
    }

    public int getJobArraySize()
    {
        return jobArray.size();
    }

    public int getLocationArraySize()
    {
        return locationArray.size();
    }

}

