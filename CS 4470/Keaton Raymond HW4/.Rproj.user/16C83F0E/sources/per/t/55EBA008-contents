#Keaton Raymond
#CS 4470

#import libraries
library(ggplot2)
library(dplyr)
library(tidyr)
library(gridExtra) #needed for grid.arrange()

#create a table that has the outlet_size and the counts for each outlet_size, useNA counts the NA values as an outlet_size
outletTable = table(joinedDataFrame$Outlet_Size, useNA = "ifany")
outletFrame = as.data.frame(outletTable) #convert the table to a data frame

#change the column names
colnames(outletFrame) = c("Outlet_Size", "Count")

#change the datatype of the values in the dataframe to characters
outletFrame = sapply(outletFrame, as.character)

#change the value of the NA Outlet_Size to a space so that it's label doesn't appear on the chart
outletFrame[is.na(outletFrame)] = " "

#change the outletFrame back to a dataframe
outletFrame = as.data.frame(outletFrame)

#create the plot
#plot the outletframe with x as the outlet size and y as the count
#change the color of the bars to coral
#theme() changes the angle of the x axis labels
#geom_label() adds the count labels on each bar, with vjust changing the height of the label, and fill adds the white background behind the text
#scale_x_discrete() changes the order of the bars so that NA is at the beginning not the end
outletPlot = ggplot(outletFrame, aes(x=Outlet_Size, y=Count)) + 
  geom_bar(stat = "identity", fill="coral") + 
  theme(axis.text.x = element_text(angle=45, vjust=1, hjust=1)) +
  geom_label(aes(label=Count), vjust=0.5, fill="white") +
  scale_x_discrete(limits=c(" ", "High", "Medium", "Small"))

#create a table that has the item fat content and the counts
fatTable = table(joinedDataFrame$Item_Fat_Content)
fatFrame = as.data.frame(fatTable) #convert the table to a data frame

#change the names of the columns
colnames(fatFrame) = c("Item_Fat_Content", "Count")

#create the plot
#plot the fat content frame with x as the item fat content and y as the count
#change the color of the bars to coral
#theme() changes the angle of the x axis labels
#geom_label() adds the count labels on each bar, with vjust changing the height of the label, and fill adds the white background behind the text
fatPlot = ggplot(fatFrame, aes(x=Item_Fat_Content, y=Count)) + 
  geom_bar(stat = "identity", fill="coral") + 
  theme(axis.text.x = element_text(angle=45, vjust=1, hjust=1)) +
  geom_label(aes(label=Count), vjust=0.5, fill="white")

#define the png to save the graphs to
png("Figures/question1GraphC.png", width=13, height=9, units="in", res=108)

#create the single image with both grids
#nrow=1 says to put both grids on the same row, by default it puts them on their own rows so they are arranged vertically instead of horizontally
grid.arrange(outletPlot, fatPlot, nrow = 1)
dev.off()