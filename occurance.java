class occurance{
    public static void main(String[] args) {
        int n = 1322562298;
        int oc = 0;
        
        System.out.print(recursive(n,oc, 2,0));
    }
    private static int recursive(int n,int oc, int tar, int cnt){
        if(n==0) return cnt;

        int unit=n%10;
        if(unit==tar) cnt++;
        return recursive(n/10, oc, tar, cnt);
    }
}