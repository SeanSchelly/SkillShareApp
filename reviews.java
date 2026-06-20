public class reviews {
    private int revID;
    private String reviewauthor;
    private String reviewtarget;
    private int userrating;
    private String usercomment;

    public reviews(int revID, String reviewauthor, String reviewtarget, int userrating, String usercomment){
        this.revID=revID;
        this.reviewauthor=reviewauthor;
        this.reviewtarget=reviewtarget;
        this.userrating=userrating;
        this.usercomment=usercomment;
    }

    public int getrevID(){
        return revID;
    }

    public String getreviewauthor(){
        return reviewauthor;
    }

    public String getreviewtarget(){
        return reviewtarget;
    }

    public int getuserrating(){
        return userrating;
    }

    public String getusercomment(){
        return usercomment;
    }

    public void setuserrating(int userrating){
        this.userrating=userrating;
    }

    public void setusercomment(String usercomment){
        this.usercomment=usercomment;
    }

     @Override
    public String toString(){
        return "Reviewer: "+ reviewauthor+ ", Reviewee: "+ reviewtarget+", Rating: "+userrating+", Comment: "+ usercomment+", Review id: "+revID;
    }
}
