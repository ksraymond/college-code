#Keaton Raymond
#CS 4470

library(readr) #used to read in the files

#import train/test data
trainDataCSV = read_csv("data/Train.csv")
testDataCSV = read_csv("data/Test.csv")

#add the outlet sales column to the test data dataframe and set to NA
#needed so that we can use rbind below
testDataCSV$Item_Outlet_Sales = NA

#combine the two datasets
joinedDataFrame = rbind(trainDataCSV,testDataCSV)