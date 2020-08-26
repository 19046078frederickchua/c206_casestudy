
public class appointments {
	
	private int dateid;
	private int day;
    private int month;
    private int year;
    private String time;
    private String notes;
    
   

    
    public appointments (int dateid , int day , int  month , int year ,  String time) {
    	this.dateid = dateid ;
    	this.day = day;
        this.month = month; 
        this.year = year ;
        this.time = time;
        this.notes = null;
    }
  
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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


	public void setDateid(int dateid) {
		this.dateid = dateid;
	}

	

	public String getDate() {
    	String output = dateid + ":" + day + "/" + month + "/" + year + "\n";
    	return output;
    }
	
   
}







