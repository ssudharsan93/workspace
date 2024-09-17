#include <iostream>
#include <map>
#include <vector>
#include <string>

using namespace std;

int main() {
   cout << "Hello, world!" << endl;
   map<int, int> mymap1;
   string a = "Hello", b = "World";
   vector<string> myVector = {a, b};

   mymap1[24] = 8;
   mymap1[3] = 2;

   cout << "The value at index 24 of my map is : " << mymap1[24] << endl;
   cout << "The value at index 3 of my map is : " << mymap1[3] << endl;

   return 0;
}
