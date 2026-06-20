
import java.util.ArrayList;
import java.util.List;

public class requesthandlersys {
    private List<skrequest> requests;
    public requesthandlersys(){
        requests = new ArrayList<>();
    }

    public void  sendrequest(skrequest req){
        requests.add(req);
    }

    public List<skrequest> getrequests(){
        return requests;
    }

    public List<skrequest> getrequestsforuser(String usernm){
        List<skrequest> userRequests = new ArrayList<>();
        for(skrequest request : requests){
            if (request.getreqreciever().equals(usernm)) {
                userRequests.add(request);
            }
        }
        return userRequests;
    }

    public void acceptreq(int reqID){
        for(skrequest request:requests){
            if (request.getreqid()==reqID) {
                request.setstatus("ACCEPTED");
            }
        }
    }

    public void rejectreq(int reqID){
        for(skrequest request:requests){
            if (request.getreqid()==reqID) {
                request.setstatus("REJECTED");
            }
        }
    }
}
