class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] c = new int[n];
        if(A[0]==B[0]){
            c[0]=1;
        }else{
            c[0]=0;
        }
        for(int i=1;i<n;i++){
            int count=0;
             for(int j=0;j<=i;j++){
                for(int k=0;k<=i;k++){
                    if(A[j]==B[k]){
                        count++;

                    }
                }
             }
             c[i]=count;
        }
          return c;
    }
}