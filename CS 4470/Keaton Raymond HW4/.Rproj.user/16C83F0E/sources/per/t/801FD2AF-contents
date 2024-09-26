#Keaton Raymond
#CS 4470

#import libraries
library(ggplot2)
library(dplyr) #not sure if needed
library("data.table")

#creates a table that contains the item type and the count for that item type
typeTable = table(joinedDataFrame$Item_Type)

#convert the table created above into a data frame so I can use ggplot
typeFrame = as.data.frame(typeTable)

#change the column names
colnames(typeFrame) = c("Item_Type", "Count")

#reorder the rows based in ascending order so that the legend is in proper order
setorder(typeFrame, cols="Count")

#define the file to save the image to
png("Figures/question1GraphB.png", width=10, height=9, units="in", res=108)

#creating the plot
#ggplot() create the plot from the typeFrame dataframe, the x axis is the item_type, y axis is the count, and fill defines the color
#geom_bar() says that this is a bar chart, stat="identity" is needed for the bar chart to group properly
#xlab("") removes the default label for the x axis
#theme() changes the x axis labels to be at a 45 degree angle and changes the vertical and horizontal justification so that it is below the graph not overlapping
#scale_fill_discrete() is used to change the legend from the default of only item_type to be item_type: count
typePlot = ggplot(typeFrame, aes(x=Item_Type, y=Count, fill=Item_Type)) + 
  geom_bar(stat = "identity") + 
  ggtitle("Item_Type") + 
  xlab("") + 
  theme(axis.text.x = element_text(angle=45, vjust=1, hjust=1)) +
  scale_fill_discrete(labels=paste(typeFrame$Item_Type, typeFrame$Count, sep=": "))
print(typePlot)
dev.off()