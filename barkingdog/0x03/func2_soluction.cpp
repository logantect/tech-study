#include <bits/stdc++.h>
using namespace std;

int func2(int arr[], int N) {
    int occur[101] = {};
    for (int i = 0; i < N; i++) {
        if (occur[100 - arr[i]] == 1) {
            return 1;
        }
        occur[arr[i]] = 1;
    }
    return 0;
}

int main(void) {
    int arr1[3] = {1, 52, 48};
    int arr2[2] = {50, 42};
    int arr3[4] = {4, 13, 63, 87};

    cout << func2(arr1, 3); cout << "\n";   // 1
    cout << func2(arr2, 2); cout << "\n";   // 0
    cout << func2(arr3, 4);                 // 1
}
