package com.example.quiz;

public class truefalse {
     private int mquestion;
   private boolean manswer;

public truefalse(int questionid,boolean trueorfalse){
    mquestion=questionid;
    manswer=trueorfalse;
}

    public int getMquestion() {
        return mquestion;
    }

    public void setMquestion(int mquestion) {
        this.mquestion = mquestion;
    }

    public boolean isManswer() {
        return manswer;
    }

    public void setManswer(boolean manswer) {
        this.manswer = manswer;
    }
}