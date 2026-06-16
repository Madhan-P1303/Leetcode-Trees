class Solution {
    public String processStr(String s) {
        int n=s.length();
        String res="";
        String new1="";
        String new2="";
        for(char c:s.toCharArray()){
            if(c=='#'){
                res+=res;
            }
            else if(c=='%'){
                for(int i=res.length()-1;i>=0;i--){
                    new1 +=res.charAt(i);
                }
                res=new1;
                new1="";
            }else if(c=='*'){
               for(int i=0;i<res.length()-1;i++){
                new2+=res.charAt(i);
               }
               res=new2;
               new2="";
            }
            else{
                res+=c;
            }
        }
        return res;
    }
}