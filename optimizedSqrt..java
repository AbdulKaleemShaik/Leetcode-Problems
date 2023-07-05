class squarere {
    public static void main(String[] args) {
        System.out.printf("%.3f",squre(36));
    }
    static double squre(int n){
        int f=0;int e=n;
        double root=0.0;
        while(f<=e){
            int mid=f+(e-f)/2;
            if(mid*mid==n){
                return mid;
            }
            if(mid*mid>n){
                e=mid-1;
            }
            else{
                f=mid+1;
            }
        }
        double incr=0.1;
        for (int i = 0; i < 3; i++) {
            while(root*root<n){
                System.out.println(root);
                root+=incr;
            }
            root-=incr;
            incr/=10;
        }
        return root;
    }
}
