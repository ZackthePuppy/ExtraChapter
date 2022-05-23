public class Process {
    private String single;

    /**
     * @return String return the word
     */
    public String getWord() {
        return single;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        single = "";
        for (int x= word.length(); x>0; x-- ){
            single += Character.toString(word.charAt(x-1));
            
        }
    }

}
