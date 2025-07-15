class Solution {
    public boolean isValid(String word) {
        int chcnt = 0;
        int digcnt = 0;
        int vowcnt = 0;
        int conscnt = 0;
        for(int i=0;i<word.length();i++){
            if(!Character.isLetterOrDigit(word.charAt(i))){
                return false;
            }
            // if(Character.isLetter(word.charAt(i))){
            //     chcnt++;
            // }
            if(isVowel(word.charAt(i))){
                vowcnt++;
            }
            if(Character.isLetter(word.charAt(i)) && !isVowel(word.charAt(i))){
                conscnt++;
            }
        }
        if(word.length()>=3 && vowcnt>=1 && conscnt>=1){
            return true;
        }
        return false;
    }
    public boolean isVowel(char ch){
            ch = Character.toLowerCase(ch);
            if(ch == 'a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                return true;
            }
            return false;
    }
}