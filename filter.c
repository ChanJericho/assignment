#include "filter.h"
#include <math.h>

int roundUp(float num)
{	
	int result = 0;
	if(num >= 255)
		return 255;
	
	else if(fmodf(num*10,10) >= 5)
	{
		result = num + 1;
		return result;
	}
	
	else{
		result = num;
		return result;
	}	
}

// Convert image to sepia
void sepia(int height, int width, RGBTRIPLE image[height][width])
{
	int i,j,red,green,blue;
	for(i = 0; i < height; i++)
		for(j =0; j < width; j++)
		{
			red = roundUp((0.393 * image[i][j].rgbtRed) + (0.769 * image[i][j].rgbtGreen) + (0.189 * image[i][j].rgbtBlue));
			green = roundUp((0.349 * image[i][j].rgbtRed) + (0.686 * image[i][j].rgbtGreen) + (0.168 * image[i][j].rgbtBlue));
			blue = roundUp((0.272 * image[i][j].rgbtRed) + (0.534 * image[i][j].rgbtGreen) + (0.131 * image[i][j].rgbtBlue));
			
			image[i][j].rgbtRed = red;
			image[i][j].rgbtGreen = green;
			image[i][j].rgbtBlue = blue;
		}
	return;
}

// Reflect image horizontally
void reflect(int height, int width, RGBTRIPLE image[height][width])
{
	int i,j,k,tempRed, tempGreen, tempBlue;

	for(i = 0; i < height; i++)
		for(j = 0, k = width - 1; j < ((width/2)); j++, k--)
		{
			tempRed = image[i][j].rgbtRed;
			tempGreen = image[i][j].rgbtGreen;
			tempBlue = image[i][j].rgbtBlue;
			
			image[i][j].rgbtRed = image[i][k].rgbtRed;
			image[i][j].rgbtGreen = image[i][k].rgbtGreen;
			image[i][j].rgbtBlue = image[i][k].rgbtBlue;
			
			image[i][k].rgbtRed = tempRed;
			image[i][k].rgbtGreen = tempGreen;
			image[i][k].rgbtBlue = tempBlue;
		}

    return;
}
