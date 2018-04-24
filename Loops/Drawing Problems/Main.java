import java.util.Scanner;


/** Draws a martini */

public class Main {

    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();
        drawFirstLine(n);
        drawSecondPart(n);
        drawThirdPart(n);

    }


    public static void drawFirstLine(int n){

        System.out.print("'&$");
        for(int i=0;i<8*n-1;i++) System.out.print("'");
        System.out.println();

    }

    public static void drawSecondPart(int n){

        int j=2;
        for(int i=0;i<n-1;i++){

            for(int k=0;k<j;k++){

                System.out.print("'");
            }
            j++;

            System.out.print("\\");

            for(int k=0;k<8*n-j+2;k++) System.out.print("'");



            System.out.println();
        }
        for(int m=0;m<8*n+1;m++){

            if(m%2==0) System.out.print("^");
            else System.out.print("*");

        }
        System.out.print("'");
        System.out.println();
    }

    public static void drawThirdPart(int n){

        int k=0;

        for (int i = 0; i < n-1; i++) {

            for(int j=0;j<k;j++) System.out.print("'");
            System.out.print("\\\\");

            for(int h=0;h<n;h++) System.out.print(" ");
            System.out.print("\\");

            int written=n+3+k;

            //for(int j=2+k+5;j<8*n-k-1;j++) System.out.print(" ");
            for(int j=written;j<8*n-k-1;j++) System.out.print(" ");
            System.out.print("//");
            for(int m=0;m<=k;m++)System.out.print("'");

            System.out.println();
            k++;

        }

        for (int i = 0; i <k; i++) {
            System.out.print("'");
        }
        System.out.print("\\");

        for (int i = 0; i <n+1 ; i++) {
            System.out.print("~");
        }


        for (int i = k+n+2; i <8*n-k ; i++){
            System.out.print("~");
        }

        System.out.print("/");
        for (int i = 0; i <n ; i++) {
            System.out.print("'");
        }

        System.out.println();
        k++;


        for (int i = 0; i <n-2; i++) {

            for(int j=0;j<n+i;j++) System.out.print("'");
            System.out.print("\\");
            for(int j=n+i+1;j<8*n-k;j++) System.out.print(" ");

            System.out.print("/");

            for (int j = 0; j <k+1 ; j++) System.out.print("'");

            System.out.println();
            k++;
        }

        for(int i=0;i<k;i++) System.out.print("'");
        System.out.print("\\");
        for(int i=k+1;i<8*n-k;i++) System.out.print("_");
        System.out.print("/");

        for (int j = 0; j <k+1 ; j++) System.out.print("'");
        System.out.println();
        k++;

        for(int i=0;i<k;i++) System.out.print("'");
        System.out.print("\\");
        for(int i=k+1;i<8*n-k;i++) System.out.print(".");
        System.out.print("/");

        for (int j = 0; j <k+1 ; j++) System.out.print("'");
        System.out.println();
        k++;

        for(int i=0;i<n+n-2;i++){

            for(int j=0;j<k;j++) System.out.print("'");
            System.out.print("\\");

            for(int m=k+1;m<8*n-k;m++) System.out.print(" ");
            System.out.print("/");

            for (int j = 0; j <k+1 ; j++) System.out.print("'");

            System.out.println();
            k++;

        }

        for(int j=0;j<k;j++) System.out.print("'");
        System.out.print("\\");

        for(int m=k+1;m<8*n-k;m++) System.out.print("_");
        System.out.print("/");

        for (int j = 0; j <k+1 ; j++) System.out.print("'");

        System.out.println();
        k++;


        for(int i=0;i<2*n+1;i++){

            for(int j=0;j<k;j++) System.out.print("'");
            System.out.print("|||");
            for(int j=0;j<k+1;j++) System.out.print("'");
            System.out.println();

        }

        for(int i=0;i<8*n+1;i++) System.out.print("_");
        System.out.print("'");
        System.out.println();

        System.out.print("'");
        for(int i=0;i<8*n-1;i++) System.out.print("-");
        System.out.print("''");


    }


}


