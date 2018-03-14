#include <iostream>

using namespace std;

// Towers of Hanoi Function
void towersHanoi(int n,char from,char to,char aux)
{
    // If we have 1 disk we move it from the fromTower to the toTower
    if(n==1){
        cout<<"From tower : "<<from<<" to tower : "<<to<<endl;
        return;
    }
    //Otherwise, we move the n-1 disks to the auxiliary Tower
    towersHanoi(n-1,from,aux,to);
    
    cout<<"From tower : "<<from<<" to tower : "<<to<<endl;
    
    // Then, those n-1 disks we move them from the auxilary Tower to the toTower
    towersHanoi(n-1,aux,to,from);
}

int main()
{
    
    
    towersHanoi(3,'a','c','b');

    return 0;
}
