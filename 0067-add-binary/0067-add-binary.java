class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result= new StringBuilder();
        int n1 =a.length() -1;
        int n2 = b.length() -1; 
        int carry = 0;
        while (n1>=0 || n2>=0 || carry !=0 ){
            int sum =carry ;
            if (n1 >= 0){
                sum += a.charAt(n1)- '0';
                n1--;
            }
            if(n2 >=0 ){
                sum += b.charAt(n2)- '0';
                n2--;
            }
            result.append(sum%2);
            carry =sum/2;
        }
        return result.reverse().toString();
    }
}