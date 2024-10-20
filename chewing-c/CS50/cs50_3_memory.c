#include <stdio.h>

int main(void) {
    int n = 50;
    printf("%p\n", &n);     // 16 진법으로 표현되 메모리 주소
    printf("%i\n", *&n);    // 주소에 해당 하는 값 n의 주소를 얻고 그 주소에 해당하는 값을 가져와서 출력
}
