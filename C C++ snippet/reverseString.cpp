#include <iostream>

inline void swap(char* a, char* b) {
    *a = *a ^ *b;
    *b = *a ^ *b;
    *a = *a ^ *b;
}
void reversOne(char* s) {
    if (*(s + 1) == '\0')
        return;
    reversOne(s + 1);
    swap(s, s + 1);
}
void reversAll(char* s) {
    if ((*s == '\0'))
        return;
    while (*(s + 1) != '\0') {
        reversOne(s);
        s++;
    }
}


int main()
{
    std::cout << "Hello World!\n";

    char str[] = "a";
    char* pStr = str;
    reversAll(pStr);

    std::cout << "Hello World - End!\n";
}