class Solution {
    public double angleClock(int hour, int minutes) {
        double res=0;
        double hours =(30*hour)+(0.5*minutes);
        double min = 6*minutes;
        res=Math.abs(hours-min);

        return Math.min(res,360-res);
    }
}