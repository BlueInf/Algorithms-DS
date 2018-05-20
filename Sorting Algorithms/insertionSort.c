
#include <stdio.h>


/** Insertion Sort Algorithm */
void insertionSort(int arr[],n){

	// Insert the arr[i] element in the correct position
	for(int i=1;i<n;i++){

		int j=i-1;
		int key=arr[i];

		// Keep a sorted subsequence array on the left
		while(j>=0 && arr[j]>key){
			arr[j+1]=arr[j];
			j--;
		}
		arr[j+1]=key;
	}

	// Print the array
	for(int k=0;k<n;k++) printf("%i",arr[k]);
}

int main(void){


	int arr[5]={5,1,3,4,10};
	insertionSort(arr,5);

	return 0;
}