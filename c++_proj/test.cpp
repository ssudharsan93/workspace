#include <iostream>
#include <map>
#include <vector>
#include <cstring>
#include <iomanip>
#include <cmath>

using namespace std;

void pointerSwap( double *ptr1, double *ptr2, double *ptr3 );
string reverseString( string str_input );

struct PlaneTicket {
    
    string airport_departure_code = string(3, 'x');
    int hour_of_departure;
    int minute_of_departure;
    char departure_terminal;
    int departure_gate;
    string airport_arrival_code = string(3, 'x');
    int hour_of_arrival;
    int minute_of_arrival;
    int row_number;
    char seat;

};

int main() {
    
    int x[4][4] = {
        { 16, 3, 2, 13 },
        { 5, 10, 11, 8 },
        { 9, 6, 7, 12 },
        { 4, 15, 14, 1 },
    };

    cout << "---         ---" << endl;
    cout << "|  " << right << x[0][0] << " " << right << x[0][1] << " " << right << x[0][2] << " " << right << x[0][3] << " " << "  |" << endl; 
    cout << "|  " << right << x[1][0] << " " << right << x[1][1] << " " << right << x[1][2] << " " << right << x[1][3] << " " << "  |" << endl; 
    cout << "|  " << right << x[2][0] << " " << right << x[2][1] << " " << right << x[2][2] << " " << right << x[2][3] << "  " << "  |" << endl; 
    cout << "|  " << right << x[3][0] << " " << right << x[3][1] << " " << right << x[3][2] << " " << right << x[3][3] << " " << "  |" << endl; 
    cout << "---         ---" << endl;

    double *ptr1, *ptr2, *ptr3;
    double d1 = 100.25, d2 = 74.37, d3 = 343.99; 

    ptr1 = &d1;
    ptr2 = &d2;
    ptr3 = &d3;

    cout << "1 : " << *(ptr1) << "\t2 : " << *(ptr2) << "\t3 : " << *(ptr3) << endl;
    
    pointerSwap(ptr1, ptr2, ptr3);

    cout << "1 : " << *(ptr1) << "\t2 : " << *(ptr2) << "\t3 : " << *(ptr3) << endl;

    string str1 = "apple";
    string str2 = "banana";  

    str1 = reverseString("apple");  
    cout << str1 << endl;

    vector<int> myVector{ 0, 1, 2 };
    
    myVector.clear();

    cout<< myVector.size() << endl;

    return -1;
}

void pointerSwap( double *ptr1, double *ptr2, double *ptr3 ) {
	
	double temp;

	temp = *(ptr1);
	*(ptr1) = *(ptr2);
	*(ptr2) = *(ptr3);
	*(ptr3) = temp;

}

string reverseString( string str_input ) {

	int str_length = str_input.length();
	int temp = 0;
	int i = 0;
	int j = str_length - 1;

	string str_input2(str_input);

	while ( i < j ) {
	    
	    temp = str_input[i];
	    str_input[i] = str_input[j];
	    str_input[j] = temp;
	    i++;
	    j--;
	    
	}

        cout << str_input2 << endl;	

	for ( int m = 0; m < floor( (double) str_length/2 ); m++ ) {
	    
	    temp = str_input2[m];
	    str_input2[m] = str_input2[str_length - 1 - m];
	    str_input2[str_length - 1 - m] = temp;
	
	}

        cout << str_input2 << endl;	

	return str_input;

}
