public class BSduplicates{
	


	public static void main(String[] args){

System.out.println("Hello");
			int[] arr={0,1,2,2,2,2,2,3,4,5};
			int first=findFirst(arr,2,0,arr.length-1)+1;
			int last=findLast(arr,2,0,arr.length-1);
			int occurences=findOccurences(arr,2);
			System.out.println("The first found element is at position "+first);
			System.out.println("The last found element is at position "+last);
			System.out.println("The occurences are "+occurences);

	}





	public static int findFirst(int[] arr,int n,int start,int last){

		int foundAt=-1;
		int mid;
		while(start<=last){
			mid=(start+last)/2;
			if(arr[mid]>n){

				last=mid-1;

			}
			else if(arr[mid]<n){
				start=mid+1;
			}else{

				last=mid-1;
				foundAt=last;

			}
		}
			return foundAt;
	}	

	public static int findLast(int[] arr,int n,int start,int last){

		int foundAt=-1;
		int mid;
		while(start<=last){
			mid=(start+last)/2;
			if(arr[mid]>n){

				last=mid-1;

			}
			else if(arr[mid]<n){
				start=mid+1;
			}else{

				foundAt=mid;
				start=mid+1;
				

			}
		}
			return foundAt;
	}	


	public static int findOccurences(int[] arr,int number){

		int start=findFirst(arr,number,0,arr.length-1);
		int last=findLast(arr,number,0,arr.length-1);
		return last-start;



	}

	



}