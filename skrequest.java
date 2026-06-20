public class skrequest {
    private String reqsender;
    private String reqreciever;
    private String reqstatus;
    private int reqid;
    private String skillreq;

    public skrequest(String reqsender,String reqreciever, String reqstatus, int reqid, String skillreq){
        this.reqsender=reqsender;
        this.reqreciever=reqreciever;
        this.reqstatus=reqstatus;
        this.reqid=reqid;
        this.skillreq=skillreq;

    }

    public int getreqid(){
        return reqid;
    }

    public String getreqsender(){
        return reqsender;
    }

    public String getreqreciever(){
        return reqreciever;
    }
    
    public String getskill(){
        return skillreq;
    }

    public String getstatus(){
        return reqstatus;
    }

    public void setreqsender(String reqsender){
        this.reqsender=reqsender;
    }

    public void setreqreciever(String reqreciever){
        this.reqreciever=reqreciever;
    }

    public void setskill(String skillreq){
        this.skillreq=skillreq;
    }

    public void setstatus(String reqstatus){
        this.reqstatus=reqstatus;
    }

    @Override
    public String toString(){
        return "Sender: "+ reqsender+ ", Reciever: "+ reqreciever+", Status: "+reqstatus+", Request id: "+reqid+ ", Skill: "+skillreq;
    }
}
