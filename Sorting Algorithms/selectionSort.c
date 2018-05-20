#include <stdio.h>


// Selection sort find the least element iteratively
// Swaps the smallest element with its correct position
void selectSort(int arr[],int n){

	// Int min keeps the index of the min position
	int min;

	for(int i=0;i<n-1;i++){
		min=i;
		for(int j=i+1;j<n;j++){
			if(arr[min]>arr[j]) min=j;
		}
		arr[i]=arr[i]+arr[min];
		arr[min]=arr[i]-arr[min];
		arr[i]=arr[i]-arr[min];
		printf("%i\n",arr[i] );

	}

	for(int k=0;k<n;k++) printf("%i ",arr[k]);
}

int main(void){


	int arr[5]={90,80,70,2,33};
	selectSort(arr,5);


	return 0;
}