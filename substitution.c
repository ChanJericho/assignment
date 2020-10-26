#include <stdio.h>
#include <string.h>

int main(int argc, char* argv[]) {
	
	char plaintext[200] = "";
	char ciphertext[200] = "";
	char key[27];
	int i, j, check = 1;
	
	if (argc == 2) //checks if there are only two arguments
	{
		strcpy(key, argv[1]); //copies the command line argument into the key
		
		for(i = 0; i < strlen(key) - 1; i++)   //checks if the key is valid
		{
			if(key[i] < 'A' || key[i] > 'z')
				check = 0;
				
			else if(key[i] > 'Z' && key[i] < 'a')
				check = 0;

			else
				for(j = i + 1; j < strlen(key); j++)
					if(key[i] == key[j] || key[i] == key[j] - 32 || key[i] == key[j] + 32)
						check = 0;
		}
		
		if(key[25] < 'A' || key[25] > 'z')
			check = 0;
				
		else if(key[25] > 'Z' && key[25] < 'a')
			check = 0;
		
		if(strlen(key) == 26 && check)
		{
			printf("plaintext: ");
			fgets(plaintext, 201, stdin);
			if(plaintext[strlen(plaintext) - 1] == '\n')
				plaintext[strlen(plaintext) - 1] = '\0';
			
			for(i = 0; i < strlen(plaintext); i++) //ciphers the normal text
			{
			for(j = 0; j < 26; j++)
			if(plaintext[i] == 'A' + j || plaintext[i] == 'a' + j)
			{
				if(plaintext[i] <= 'Z')
				{
					if(key[j] <= 'Z')
						ciphertext[i] = key[j];
						
					else
						ciphertext[i] = key[j] - 32;
						
					j += 30;
				}
			
				else if(plaintext[i] >= 'a') 
				{
					if(key[j] >= 'a')
						ciphertext[i] = key[j];
					
					else
						ciphertext[i] = key[j] + 32;
		
					j += 30;
				}
			}
		
			if(j == 26)
				ciphertext[i] = plaintext[i];
			}
			
			printf("ciphertext: %s\n", ciphertext);
		}
		
		else if(strlen(key) != 26) //error message when the key does not have 26 characters
		{
			printf("Key must contain 26 characters\n");
			return 1;
		}
		
		else if(check == 0) //error message when the key is invalid
		{
			printf("Invalid key\n");
			return 1;
		}
	}
	
	else
	{
		if(argc == 1)
			printf("Usage: substitution key\n"); //error message when there are no arguments
		
		else
			printf("Usage: substitution\n"); //error message when there are more than one arguments
		
		return 1;
	}
	
	
	return 0;
}
