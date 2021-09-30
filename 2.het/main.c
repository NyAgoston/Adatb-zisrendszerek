#include <stdio.h>
#include <stdlib.h>

int main()
{
    pelda_3_felvisz();
    pelda_3_olvas();
    return 0;
}
struct Auto {
    char rendszam[6];
    char tipus[20];
    double ar;
};

void pelda_3_felvisz(){
    struct Auto autok[3];
    FILE *fdata;
    int i;
    for(i = 0; i < 3; i++){
        printf("Rendzsam: ");
        scanf("%s", &autok[i].rendszam);
        printf("Tipus: ");
        scanf("%s",&autok[i].tipus);
        printf("Ar: ");
        scanf("%lf",&autok[i].ar);
    }

    fdata = fopen("Autok.dat", "wb");
    for(i = 0; i < 3; i++){
        fwrite(&(autok[i]), sizeof(struct Auto), 1, fdata);
    }
    fclose(fdata);

    return 0;

}

void pelda_3_olvas(int pos){
    FILE *fdata;
    fdata = fopen("Autok.dat","rb");
    struct Auto keresett;

    if(fdata == NULL){
        printf("File hiba....\n");
        return;
    }
    fseek(fdata, ((pos-1)*sizeof(struct Auto)),0);
    fread(&keresett, sizeof(struct Auto), 1, fdata);
    printf("Rendszam: %s\n", keresett.rendszam);
    printf("Tipus: %s\n",keresett.tipus);
    printf("Ar: %lf\n",keresett.ar);
    fclose(fdata);

    return 0;
}
