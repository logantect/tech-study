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

void printResult(int arr[], int N) {
    cout << func2(arr, N) << "\n";
}

int main(void) {
    int arr1[3] = {1, 52, 48};
    int arr2[2] = {50, 42};
    int arr3[4] = {4, 13, 63, 87};
    int arr4[5] = {1, 23, 53, 77, 60};

    printResult(arr1, 3); // 예상 출력: 1
    printResult(arr2, 2); // 예상 출력: 0
    printResult(arr3, 4); // 예상 출력: 1
    printResult(arr4, 5); // 예상 출력: 1
}
