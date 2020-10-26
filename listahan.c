#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct{
    char name[80];
    char lastName[40];
    char firstName[40];
    int age;
}Person;

const char* lowerCase(char* str){
	
	int i;

	for(i = 0; i < strlen(str); i++)
	{
		if(str[i] >= 'A' && str[i] <= 'Z')
			str[i] += 32;	
	}
	
	return str;
}

void merge(Person a[], int l, int m, int r){
    int n1=m-l+1;
    int n2=r-m;
    int i, j;
    Person L[n1];
    Person R[n2];
    
    for (i=0; i<n1; i++){
        L[i]=a[l+i];
    }
    for(j=0; j<n2; j++){
        R[j]=a[m+1+j];
    }
    
    i=0;
    j=0;
    int k=l;
    while((i<n1)&&(j<n2)){
        if (strcmp(lowerCase(L[i].name), lowerCase(R[j].name))<0)
		{
        	a[k]=L[i];
        	i++;
        }
		else
		{
            a[k]=R[j];
            j++;
        }
        k++;
    }
    while(i<n1){
        a[k]=L[i];
        i++;
        k++;
    }
    while(j<n2){
        a[k]=R[j];
        j++;
        k++;
    }
}

void mergeSort(Person a[], int l, int r){
    if(l<r){
        int m=l+(r-l)/2;
        mergeSort(a, l, m);
        mergeSort(a, m+1, r);
        merge(a, l, m, r);
    }
}

void displayPerson(Person* p, int number){
    
	int i;
	
	for(i=0; i<number; i++){
        printf("%s %s, Age: ", p[i].firstName, p[i].lastName);
        printf("%d \n", p[i].age);
    }
}


int main(){

    int i, number = -999;
    char *ptr;
    char buf[100];
    
    printf("Enter number of students: ");
    scanf("%d", &number);
    printf("\n");
    
    if(number == -999)
    {
    	system("@cls||clear");
		Person q[100];
	
		fgets(buf, 100, stdin);

	    for(i = 0; (fgets(buf, 100, stdin)); i++)
	    {
	    	ptr = strtok(buf, ",");
	    	strcpy(q[i].name, ptr);
	    	strcpy(q[i].lastName, ptr);
	    	
			ptr = strtok(NULL, ",");
			strcat(strcat(q[i].name, " "),ptr);
			strcpy(q[i].firstName, ptr);
			
			ptr = strtok(NULL, "");
			q[i].age = atoi(ptr);
		}
	    mergeSort(q, 0, i-1);
	    displayPerson(q, i);
	}
    
   	else
   	{
		Person p[number];
		getchar(); 
		for(i=0; i<number; i++){
		   
		    printf("Enter student %d's Last Name,First Name,Age: ", i+1);
		    
			fgets(buf, 100, stdin);
		    ptr = strtok(buf, ",");
	    	strcpy(p[i].name, ptr);
	    	strcpy(p[i].lastName, ptr);
	    	
			ptr = strtok(NULL, ",");
			strcat(strcat(p[i].name, " "),ptr);
			strcpy(p[i].firstName, ptr);
			
			ptr = strtok(NULL, "");
			p[i].age = atoi(ptr);
		}
	    printf("\n");
	    mergeSort(p, 0, number-1);
	    displayPerson(p, number);
	}
    
    
    return 0;
}
