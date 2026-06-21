class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n=costs.length;
        Arrays.sort(costs);
        int sum=0;
           int count=0;
        for(int i=0;i<n;i++){
            sum+=costs[i];
            if(sum>coins){
                sum=sum-costs[i];
                break;
            }
            count++;

        }
        return count;
    }
}