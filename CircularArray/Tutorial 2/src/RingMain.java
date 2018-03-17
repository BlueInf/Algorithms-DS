import java.util.Iterator;

public class RingMain {

    public static void main(String[] args){

        Ring<Integer> ring = new CircularArrayRing<Integer>(3);

        System.out.println("Size is = "+ring.size());
        ring.add(1);
        System.out.println("Size is = "+ring.size());

        ring.add(2);
        System.out.println("Size is = "+ring.size());

        ring.add(3);
        //System.out.println("Size is = "+ring.size());

        ring.add(4);
        //System.out.println("Size is = "+ring.size());

        ring.add(5);



        Iterator<Integer> it=ring.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }



    }
}
