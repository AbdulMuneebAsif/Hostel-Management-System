package SuperClasses;

import Classes.Complain;

public class SuperComplainData {

    private static Complain[] complain=new Complain[99999];
    private static int ComplainCounter=0;
    private static int EditComplainIndex=0;

    public static void setEditComplainIndex(int Index)
    {
        EditComplainIndex=Index;
    }
    public static int getEditComplainIndex()
    {
        return EditComplainIndex;
    }


    public static void AddComplain()
    {
        ComplainCounter+=1;
    }
    public static void DeleteComplain()
    {
        ComplainCounter-=1;
    }
    public static int getComplainCounter()
    {
        return ComplainCounter;
    }

    public static String getComplainName(int Index)
    {
        return complain[Index].getName();
    }
    public static void setComplainName(String Name,int Index)
    {
         complain[Index].setName(Name);
    }

    public static String getComplainStatus(int Index)
    {
        return complain[Index].getStatus();
    }
    public static void setComplainStatus(String Status,int Index)
    {
         complain[Index].setStatus(Status);
    }

    public static String getComplainRegistrationDate(int Index)
    {
        return complain[Index].getRegistrationDate();
    }
    public static void setComplainRegistrationDate(String Date,int Index)
    {
         complain[Index].setRegistrationDate(Date);
    }

    public static String getComplainCloseDate(int Index)
    {
        return complain[Index].getCloseDate();
    }
    public static void setComplainCloseDate(String Date,int Index)
    {
         complain[Index].setCloseDate(Date);
    }

    public static String getComplainDetails(int Index)
    {
        return complain[Index].getDetails();
    }
    public static void setComplainDetails(String Details,int Index)
    {
        complain[Index].setDetails(Details);
    }

    public static void DeleteComplainData(int Index)
    {
        complain[Index].setName("");
        complain[Index].setStatus("");
        complain[Index].setRegistrationDate("");
        complain[Index].setCloseDate("");
        complain[Index].setDetails("");
        for(int i=Index;i<ComplainCounter;i++) {
            complain[i].setName(getComplainName(i+1));
            complain[i].setStatus(getComplainStatus(i+1));
            complain[i].setRegistrationDate(getComplainRegistrationDate(i+1));
            complain[i].setCloseDate(getComplainCloseDate(i+1));
            complain[i].setDetails(getComplainDetails(i+1));
        }

        DeleteComplain();
    }
    public static void ComplainFill()
    {
        for(int i=0;i<99999;i++) {
            complain[i]=new Complain();

            complain[i].setName("");
            complain[i].setStatus("");
            complain[i].setRegistrationDate("");
            complain[i].setCloseDate("");
            complain[i].setDetails("");
        }
    }


}
