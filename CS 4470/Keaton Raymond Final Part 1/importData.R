#Keaton Raymond
#CS 4470-001

library(readxl)

#read in the world energy data excel sheet
worldEnergyData = read_excel("Data/worldenergymix.xlsx")

#reorder columns to be in same order as assignment
worldEnergyData = worldEnergyData[,c(1, 3, 2, 6, 5, 4)]

#create a blank list for the "year" column names
yearList = c()
year = 1949 #the start year

#for loop creating the year name list
for (i in seq(1, 111, by=1))
{
  yearList[i] = year
  year = year+1
}

#import the men and women data with the column names equal to the year list
#header = FALSE makes the function read all of the data in the text files as values as opposed to reading the first as the header value
#check.names = FALSE makes it so that R doesn't insert an X before the year for the col name. i.e. 1950 vs. X1950
menData = read.csv("Data/men.txt", col.names = yearList, header = FALSE, check.names = FALSE)
womenData = read.csv("Data/women.txt", col.names = yearList, header = FALSE, check.names = FALSE)