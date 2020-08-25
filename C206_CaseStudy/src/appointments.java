

public class appointments {
	
	private int dateid;
	private int day;
    private int month;
    private int year;
   

    
    public appointments (int dateid ,int day , int  month , int year ) {
    	this.dateid = dateid ;
    	this.day = day;
        this.month = month; 
        this.year = year ;
    }
  
	public int getdateid()
    {
        return dateid;
    }

    public void setdateid(int dateid)
    {
        this.dateid = dateid;
    }
    
    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    
    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }
    
    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getDate() {
    	String output = dateid + ":" + day + "/" + month + "/" + year + "\n";
    	return output;
    }
	
   
}






