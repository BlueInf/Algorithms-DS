#include <stdio.h>
#include <iostream>
#include <vector>

using namespace std;


/**
 * Recursion: Krasimir Marinov
 * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target?
 * Backtracking
 * */
bool groupSum(int start, vector<int> nums, int target) {
    
    // We have reached the end of the vector
    if(start>=nums.size()){
        
        // We have reached our target
        if(target==0) return true;
        
        // We have not
        else return false;
        
    }
    
    // We include the current number or not
    return groupSum(start+1,nums,target-nums[start]) || groupSum(start+1,nums,target);
    
}

int main()
{
    
    int x[5] = {1, 2, 3,4,6};
    std::vector<int> v(x, x + sizeof x / sizeof x[0]);
    
    // Check if we could make 10 out of the array x
    if(groupSum(0,v,10)==true ) cout<<"The sum could be made";
    else cout<<"The sum could not be made";
    
    return 0;
}

