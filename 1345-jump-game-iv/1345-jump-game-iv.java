class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n==1){
            return 0;
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);
        }
         boolean[] visited = new boolean[n];
         Queue<Integer>  queue = new LinkedList<>();
         queue.offer(0);
         visited[0]=true;
         int res=0;
         while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int curr = queue.poll();
                if(curr==n-1){
                    return res;
                }

                if(curr+1<n&&!visited[curr+1]){
                    visited[curr+1]=true;
                    queue.offer(curr+1);
                }
                if(curr-1>=0&&!visited[curr-1]){
                    visited[curr-1]=true;
                    queue.offer(curr-1);
                }
                if(map.containsKey(arr[curr])){
                for(int num:map.get(arr[curr])){
                    if(!visited[num]){
                        visited[num]=true;
                        queue.offer(num);
                    }
                }
                map.remove(arr[curr]);
                }

            }
            res++;
         }
           return -1;
 
    }
}
