
import java.util.ArrayList;
import java.util.List;

public class reviewservicesys {
    private List<reviews> review;

    public reviewservicesys(){
        review =new ArrayList<>();
    }

    public void Addrev(reviews rev){
        review.add(rev);
    }

    public List<reviews> getrev(){
        return review;
    }

    public double getavgrating(String usernm){
        int tot=0;
        int num=0;

        for(reviews rev:review){
            if(rev.getreviewtarget().equals(usernm)){
                tot+=rev.getuserrating();
                num++;
            }
        }

        if (num==0) {
            return 0;
        }

        return (double) tot/num;
    }
}
