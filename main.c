#include <stdio.h>
#include <stdlib.h>

int main()
{
    pelda_1();
    return 0;
}

void pelda_1(){
    char filenev[40];
    FILE *fp;
    char ch;

    printf("File nev: ");

    scanf("%s",filenev);
    fp = fopen(filenev,"w");
    printf("File megnyitva, mi az uzenet:\n");

    while((ch = getchar()) != '#'){
        putc(ch, fp);
    }
    fclose(fp);

    fp = fopen(filenev,"r");

    while((ch = getc(fp)) != EOF){
        printf("%c",toupper(ch));
    }

    fclose(fp);
    return 0;
}
