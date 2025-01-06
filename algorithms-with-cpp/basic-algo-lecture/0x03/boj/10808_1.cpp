// http://boj.kr/ece8236c02cf46aba9933f28e358b51c
#include <bits/stdc++.h>
using namespace std;

// 문자열 `s`를 한 번만 순회하며 각 문자의 빈도수를 `freq` 배열에 저장하기 때문에, 문자열의 길이가 NNN일 때 O(N)의 시간 복잡도를 가진다.
// `freq` 배열의 출력 부분은 26번 순회하지만, 이는 상수이므로 O(1)로 간주할 수 있다.
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string s;
    cin >> s;
    for (char a = 'a'; a <= 'z'; a++) {
        int cnt = 0;
        for (const auto c: s)
            if (a == c) cnt++;
        cout << cnt << ' ';
    }
}