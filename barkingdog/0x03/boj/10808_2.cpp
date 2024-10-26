// http://boj.kr/ece8236c02cf46aba9933f28e358b51c
#include <bits/stdc++.h>
using namespace std;

// 1번과 마찬가지로 O(N) 하지만 알파벳 a 부터 z까지 루프 돌지 않아도 된다.
int freq[26];

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string s;
    cin >> s;
    for (auto const c: s) {
        freq[c - 'a']++;
    }
    for (int i = 0; i < 26; i++)
        cout << freq[i] << ' ';
}
