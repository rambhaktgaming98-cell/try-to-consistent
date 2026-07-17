class Solution {
    public int strStr(String haystack, String needle) {
     for (int i=0;i<=haystack.length()-needle.length();i++)
     {
        String chunk=haystack.substring(i,i+ needle.length());
        
        if(chunk.equals(needle)){
        return haystack.indexOf(needle);
        }
     }return -1;
    } 
}