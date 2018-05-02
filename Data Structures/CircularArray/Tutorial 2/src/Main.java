public class Main {

    public static void main(String[] args){

        CircularArrayQueue myNewQueue=new CircularArrayQueue(4);

        System.out.println("\nThe number of items is "+myNewQueue.noItems());

        myNewQueue.enqueue(1);
        myNewQueue.enqueue(2);
        myNewQueue.enqueue(3);
        System.out.println("\nThe number of items is "+myNewQueue.noItems());
       // myNewQueue.enqueue(7);

        System.out.println("Capacity left = "+myNewQueue.getCapacityLeft());
        //System.out.print(myNewQueue.dequeue()+" ");
        //System.out.print(myNewQueue.dequeue()+" ");

        myNewQueue.enqueue(4);
        myNewQueue.dequeue();
        myNewQueue.enqueue(5);
        System.out.println("\nThe number of items is "+myNewQueue.noItems());
        myNewQueue.enqueue(6);

        System.out.println("Last element "+myNewQueue.dequeue()+" ");
        System.out.println("Last element "+myNewQueue.dequeue()+" ");
        System.out.println("Last element "+myNewQueue.dequeue()+" ");
        System.out.println("Last element "+myNewQueue.dequeue()+" ");
        System.out.println("Last element "+myNewQueue.dequeue()+" ");

        if(myNewQueue.isEmpty()) System.out.print("IT IS EMPTY");
        else System.out.println("IT is not");

        System.out.print("\nThe number of items is "+myNewQueue.noItems());
        //System.out.print(myNewQueue.dequeue()+" ");


    }
}
