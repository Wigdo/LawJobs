package Wigdo;

public class Collator {

    Collator ()
    {
        allensJobCollator();
        mauriceBlackburnCollate();
       // HWLECollate();
    }

    public void allensJobCollator()

    {
        AllensJobList allensObj = new AllensJobList();
    }

    public void mauriceBlackburnCollate ()
    {
        MauriceBlackburnJobList mbJobObj = new MauriceBlackburnJobList();

        for (int i=0;i < mbJobObj.getLocationArraySize(); i++)
        {
            System.out.println(mbJobObj.getJobAtIndex(i));
            System.out.println(mbJobObj.getLocationAtIndex(i));
        }
    }

    public void HWLECollate()
    {
        HWLEJobList jobList = new HWLEJobList();
        jobList.collateJobList();
    }

    public static void main (String[] args)
    {
        Collator collateObj = new Collator();
    }

}
