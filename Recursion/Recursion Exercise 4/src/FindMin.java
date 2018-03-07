public class FindMin {

    static int[] arr = {24,52,74,9,34,23,64,34};

    public static void main(String[] args){
        FindMin m = new FindMin();
        System.out.println("Minimum is :" + m.findMin(arr,0));
        System.out.println("Maximum is :" + m.findMax(arr,arr.length-1));
    }

    /**
     * Recursive findMin in an array
     * @param arr
     * @param n
     * @return
     */
    public int findMin(int[] arr,int n){

        if(n==arr.length-1) return arr[n];
        if(arr[n]<findMin(arr,n+1)) return arr[n];
        else return findMin(arr,n+1);


    }

    /**
     * Recursive findMax in an array
     * @param arr
     * @param n
     * @return
     */
    public int findMax(int[] arr,int n){
        if(n==0) return arr[n];
        if(arr[n]>findMax(arr,n-1)) return arr[n];
        else return findMax(arr,n-1);
    }

}
