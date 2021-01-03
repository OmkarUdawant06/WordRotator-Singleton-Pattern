package wordPlay.handler;

public class WordRotator {
    private String wrd;

    private WordRotator(String wrd) {
        super();
        this.wrd = wrd;
    }

    /**
     * Rotate word according to its index value*/
    public String revString(int index){
        boolean flag = false;
        if(wrd.contains(".")) {
            wrd = wrd.substring(0,wrd.length()-1);
            flag = true;
        }
        for (int i = 0; i < index; i++) {
            char temporaryBuffer = wrd.charAt(wrd.length() - 1);
            wrd = temporaryBuffer + wrd;
            wrd = wrd.substring(0, wrd.length() - 1);
        }

        /* After everything is done return the String
         */
        if(flag)
            return wrd + ".";
        else
            return wrd;
    }
}
