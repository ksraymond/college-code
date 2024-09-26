#Keaton Raymond
#CS 4470

#import libraries
library(ggplot2)
library(gridExtra) #needed for grid.arrange()

#drop all rows from the joined data frame where the item_weight is NA
weightFrame = joinedDataFrame[!(is.na(joinedDataFrame$Item_Weight)), ]

#create a histogram for the weightFrame where x is the item_weight
#col=I("black") makes the outline of each bar black, and fill changes the color of the bar itself
weightPlot = ggplot(weightFrame, aes(x=Item_Weight)) + geom_histogram(col=I("black"), fill="grey")

#drop all rows from the joined data frame where the item_visibility is NA
visibilityFrame = joinedDataFrame[!(is.na(joinedDataFrame$Item_Visibility)), ]

#create a histogram where x is the item_visibility
visibilityPlot = ggplot(visibilityFrame, aes(x=Item_Visibility)) + geom_histogram(col=I("black"), fill="grey")

#drop all. rows from the joined data frame where the item_mrp is NA
mrpFrame = joinedDataFrame[!(is.na(joinedDataFrame$Item_MRP)), ]

#create a histogram where x is the item_MRP
#this plot doesn't have the outline like the above two, only the fill
#binwidth changes the width of the histogram bars, which changes the range for which a row is counted for that bar's count
mrpPlot = ggplot(mrpFrame, aes(x=Item_MRP)) + geom_histogram(fill="grey", binwidth = 0.5)

#change the dimensions and resolution to not have square plots
#just used the same dimensions and resolution as in the last assignment
png("Figures/question1GraphA.png", width=13, height=9, units="in", res=108)

#arrange the three plots in one image
#nrow=2 changes the number of rows, by default this is one meaning all of the plots are next to each other
grid.arrange(weightPlot, visibilityPlot, mrpPlot, nrow = 2)
dev.off()