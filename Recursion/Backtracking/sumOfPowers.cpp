#include <math.h>
#include <iostream>
#include <algorithm>
using namespace std;

// Our function
// Finds the ways that a number can be calculate by the power of unique numbers
int findPowerSum(int totalSum, int power, int num)
{
	
    // We subtract the power of the current num from the totalSum
    int value = (totalSum - pow(num, power));
    

    // Base case if we cannot get the totalSum
    if(value < 0) return 0;

    // Else if, we can 
    else if(value == 0) return 1;

    // Else , we either take the first number or not
    else return findPowerSum(value , power, num + 1) +
    			findPowerSum(totalSum, power, num+1);
}

int main() { 
    int total;
    int power;
    cin >> total;
    cin >> power;
    cout << findPowerSum(total, power, 1);
    return 0;
}


