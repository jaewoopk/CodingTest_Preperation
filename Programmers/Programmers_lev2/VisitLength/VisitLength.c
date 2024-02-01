#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

bool isInner(int x, int y);

typedef struct s_point {
    int x;
    int y;
}Point;

bool board[11][11][4];

bool isInner(int x, int y) {
    return x >= 0 && y >= 0 && x <= 10 && y <= 10;
}
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* dirs) {
    int start, end, answer = 0;
    Point* point = (Point*)malloc(sizeof(Point));
    point->x = 5;
    point->y = 5;

    for (int i = 0; i < strlen(dirs); i++) {
        int x = point->x;
        int y = point->y;
        bool possible = true;
        switch (dirs[i]) {
        case 'U' :
            if (isInner(point->x, point->y + 1)) {
                point->y += 1;
                start = 0;
                end = 1;
                break;
            }
            possible = false;
            break;
        case 'D' :
            if (isInner(point->x, point->y - 1)) {
                point->y -= 1;
                start = 1;
                end = 0;
                break;
            }
            possible = false;
            break;
        case 'L' :
            if (isInner(point->x - 1, point->y)) {
                point->x -= 1;
                start = 2;
                end = 3;
                break;
            }
            possible = false;
            break;
        case 'R' :
            if (isInner(point->x + 1, point->y)) {
                point->x += 1;
                start = 3;
                end = 2;
                break;
            }
            possible = false;
            break;
        }
        if (possible && !board[x][y][start] || !board[point->x][point->y][end]) {
            board[x][y][start] = true;
            board[point->x][point->y][end] = true;
            answer++;
        }
        //printf("x -> %d y -> %d // %d\n",point->x, point->y, answer);
    }
    free(point);
    return answer;
}