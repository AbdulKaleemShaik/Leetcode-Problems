public  PriorityQueue<Integer> q = new PriorityQueue<>(); 
int k;

public KthLargestt(int k, int[] nums) {

    this.k = k;
    for (int i : nums) {
        q.offer(i);
    }

    while (q.size() > k)
        q.poll();

}

public int add(int val) {

    q.add(val);
    while (q.size() > k)
        q.poll();
    return q.peek();

} 
