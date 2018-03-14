#include <iostream>

using namespace std;

double computePower(double number,int power){

    if(power==0) return 1;
    if(power==1) return number;
    if(power==2) return number*number;
    if(power%2==0.) return computePower(computePower(number,power/2),2);
    else if(power%2==1.0) return number*(computePower(number,(power-1)));
}
    
  
double power(double number,int powerNumber){
    return powerNumber <0 ? computePower(1.0/number,-powerNumber) : computePower(number,powerNumber);
}

 
int main()
{
    cout<<power(3,5);
    return 0;
}
