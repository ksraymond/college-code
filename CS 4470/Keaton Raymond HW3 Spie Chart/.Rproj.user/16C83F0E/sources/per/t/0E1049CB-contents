#Keaton Raymond
#CS 4470

#import libraries
library("readxl") #used to read the excel file
library(dplyr) #used to drop the unnecessary columns

medicalCosts=read_excel("data/Healthcare_costs.xlsx") #read in the excel file
medicalCosts = select(medicalCosts, -c(7:11)) #drop unnecessary columns
attach(medicalCosts) #attach() makes it so that you can access the variables of the dataframe directly
numRows=nrow(medicalCosts) #create a variable that keeps track of the number of rows