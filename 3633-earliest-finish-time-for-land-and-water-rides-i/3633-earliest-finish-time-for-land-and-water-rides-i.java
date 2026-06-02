class Solution {
    public int earliestFinishTime(int[] landS, int[] landD, int[] waterS, int[] waterD) {
        int n=landS.length;
        int m=waterS.length;
       int res =Integer.MAX_VALUE;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            int ls=landS[i]+landD[i];
            int maxl =Math.max(ls,waterS[j]);
            int f1 = maxl+waterD[j];

            int ws=waterS[j]+waterD[j];
            int max2=Math.max(ws,landS[i]);
            int f2= max2 + landD[i];

            res=Math.min(res,Math.min(f1,f2));
        }
    }
    return res;
    }
}