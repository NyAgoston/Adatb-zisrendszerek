#include <stdio.h>
#include <stdlib.h>

int main()
{
    char filenev1[40];
    char filenev2[40];
    printf("Melyik filet szeretne olvasni: \n");
    scanf("%s",filenev1);
    printf("Hova szeretne masolni a filet: \n");
    scanf("%s",filenev2);
    pelda_2(filenev1, filenev2);

    return 0;
}
void pelda_2(char *fnev1, char *fnev2){
    FILE *fp1, *fp2;
    int pos;
    char ch;
    if((fp1 = fopen(fnev1,"r")) == NULL){
        printf("\nNem lehet megnyitni a filet!");
        return 0;
    }
    printf("\nFile megnyitasa masolasra.... \n");

    fp2 = fopen(fnev2, "a");
    fseek(fp1, 0L, SEEK_END);
    pos = ftell(fp1);
    fseek(fp1, 0L, SEEK_SET);
    while (pos--){
        ch = fgetc(fp1);
        fputc(ch, fp2);
    }
    fclose(fp1);
    fclose(fp2);

    printf("Sikeres masolas!");

    return 0;
}
