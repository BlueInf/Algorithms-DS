#include <iostream>
#include <fstream>
#include <iterator>
#include <vector>
#include <algorithm>
#include <iostream>
#include <stdio.h>
#include <time.h>
#define CLOCKS_PER_MS (CLOCKS_PER_SEC/1000)

using namespace std;
struct timespec start,finish;
int main(int argc, char *argv[])
{
  int N;
    
  
  sscanf(argv[1], "%d", &N);
  vector<double> data(N);
  for(unsigned int i=0; i<N; i++) {
    data[i] = rand()/(RAND_MAX+1.0);
  }
  
  double elapsed;
 
  clock_gettime(CLOCK_MONOTONIC,&start);
  sort(data.begin(), data.end());
  clock_gettime(CLOCK_MONOTONIC,&finish);
  
  elapsed=(finish.tv_sec - start.tv_sec);
  elapsed +=(finish.tv_nsec-start.tv_nsec)/1000000000.0;
  //printf ("Your calculations took %.2lf seconds to run.\n", dif );
  //copy(data.begin(), data.end(), ostream_iterator<double>(cout,"\n"));
  cout<<elapsed;
}