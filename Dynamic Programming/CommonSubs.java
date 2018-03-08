import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class CommonSubs {




    static int[][] longestCommonSubsequence(int[] a, int[] b) {
        // Complete this function
        int[][] calcMatr= new int[b.length + 1][a.length + 1];

        for (int i = 1; i <calcMatr.length; i++) {
            for (int j = 1; j < calcMatr[0].length; j++) {

              //  System.out.print("A is "+ a[j-1]+" B IS "+b[i-1]+'\n');
                if (a[j-1] == b[i-1]) {

                    calcMatr[i][j] = calcMatr[i - 1][j - 1] + 1;
                } else {

                    calcMatr[i][j] = Math.max(calcMatr[i - 1][j], calcMatr[i][j - 1]);
                }
            }
        }
        return calcMatr;
    }




    static int[] backtrack(int[][] arr,int a[],int b[]) {

        int i=arr[0].length-1;
        int j=arr.length-1;

        Stack stack=new Stack<Integer>();

       // System.out.print(i+" "+j);


        while(i>0 && j>0){

           // System.out.print(i+" "+j);
            if(a[i-1]==b[j-1]){

            stack.push(b[j-1]);
          //  System.out.print(b[j-1]+" ");
                i--;
                j--;


            }
            else if(arr[j][i-1]>arr[j-1][i]) i--;
            else j--;



        }

        int[] result=new int[stack.size()];
        int index=0;
        while(!stack.empty()){

            result[index++]=(Integer)stack.pop();
           // index++;

        }

        return result;


       /* if(number==arr[i][j-1]) backtrack(arr,arr[i][j-1],a,b);
        else if(number==arr[i-1][j-1]) backtrack(arr,arr[i-1][j],a,b);
        else if(number>arr[i][j-1]&&number>arr[j-1][i]) backtrack(arr,arr[i-1][j-1],a,b);
        else if(number>arr[i][j-1]&&number>arr[j-1][i]&&arr[i-1][j-1]==0) return ;
        */

        //System.out.print()


    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        int a[] = new int[n];
        int b[] = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }


        for (int j = 0; j < m; j++) {
            b[j] = s.nextInt();
        }

        // for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
        //for (int i = 0; i < m; i++) System.out.print(b[i] + " ");

        int[][] matrix = longestCommonSubsequence(a, b);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
            //   System.out.print(matrix[i][j] + " ");
            }
           // System.out.println();
        }

        int result[]=backtrack(matrix,a,b);

        for(int i=0;i<result.length;i++) System.out.print(result[i]+" ");




    }
}
