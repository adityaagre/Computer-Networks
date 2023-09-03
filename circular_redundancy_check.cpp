// Remember iostream namespace std
#include <iostream>
using namespace std;

int main()
{

    cout << "Enter number of bits in dataword" << endl;
    int s_data;
    cin >> s_data;

    // Declaring an array to store dataword

    int data[20];

    // taking input

    for (int i = 0; i < s_data; i++)
    {
        cin >> data[i];
    }

    cout << "Enter number of bits in divisor" << endl;
    int s_divisor;
    cin >> s_divisor;

    // Declaring an array to store divisor

    int divisor[20];

    // taking input

    for (int i = 0; i < s_divisor; i++)
    {
        cin >> divisor[i];
    }

    // printing both

    cout << "dataword" << endl;
    for (int i = 0; i < s_data; i++)
    {
        cout << data[i];
    }

    cout << endl
         << "divisor" << endl;
    for (int i = 0; i < s_divisor; i++)
    {
        cout << divisor[i];
    }

    // no of crc bits = no of divisor bits -1

    int s_crc = s_divisor - 1;

    // declaring crc array
    int crc[s_crc];
    for (int i = 0; i < s_crc; i++)
    {
        crc[i] = 0;
    }

    // adding crc to dataword

    for (int i = 0; i < s_crc; i++) // Very important step **
    {
        int initial_index = s_data; // Very important step
        data[initial_index + i] = crc[i];
    }

    // displaying entire codeword
    cout << endl
         << "Initial codeword" << endl;
    for (int i = 0; i < s_crc + s_data; i++)
    {
        cout << data[i];
    }

    // most important part
    // to find value of crc bits using xor division

    // creating a copy of codeword
    int temp[s_crc + s_data];
    for (int i = 0; i < s_crc + s_data; i++)
    {
        temp[i] = data[i];
    }




    int ptr1 = 0;
    int ptr2 = s_divisor - 1;

    
    while (ptr2 < s_data + s_crc)
    {


        

        for (int k = 0; k <= s_divisor-1; k++)
        {
            
            
            int ans = 1;

            

            if (temp[k + ptr1] == divisor[k])
            {

                ans = 0;
            }

            temp[k+ptr1] = ans;
            
            
        }

     

        if (temp[ptr1] == 0)
        {
            

            ptr1++;
            ptr2++;
        }

        
        
        
    
        
        


    }

    cout << endl
         << "final codeword" << endl;
    for (int i = 0; i < s_crc + s_data; i++)
    {
        cout << temp[i];
    }

    return 0;
    // remember to return 0
}