#Keaton Raymond
#CS 4470

#import libraries
library(ggplot2)
library(cowplot) #needed for plot_grid()

#create a dataframe and remove all of the rows with na value for item_weight then remove all NA item outlet sales
weightFrame = joinedDataFrame[!(is.na(joinedDataFrame$Item_Weight)), ]
weightFrame = weightFrame[!(is.na(weightFrame$Item_Outlet_Sales)), ]

#create the plot with x as item weight, y as item outlet sales
#geom_point means that each variable presents a point on the plot
#color changes the color of each point
#alpha changes the opacity of the dot
weightPlot = ggplot(weightFrame, aes(x=Item_Weight, y=Item_Outlet_Sales)) + geom_point(color="steelblue1", alpha=0.5)

#same as above but for item visibility
visibilityFrame = joinedDataFrame[!(is.na(joinedDataFrame$Item_Visibility)), ]
visibilityFrame = visibilityFrame[!(is.na(visibilityFrame$Item_Outlet_Sales)), ]

#same as above but with visibility and item outlet sales
visibilityPlot = ggplot(visibilityFrame, aes(x=Item_Visibility, y=Item_Outlet_Sales)) + geom_point(color="steelblue1", alpha=0.5)

#same as above but for item mrp
mrpFrame = joinedDataFrame[!(is.na(joinedDataFrame$Item_MRP)), ]
mrpFrame = mrpFrame[!(is.na(mrpFrame$Item_Outlet_Sales)), ]

#same as above but with mrp and item outlet sales
mrpPlot = ggplot(mrpFrame, aes(x=Item_MRP, y=Item_Outlet_Sales)) + geom_point(color="steelblue1", alpha=0.5)

#change the dimensions and resolution to not have square plot
png("Figures/question1GraphD.png", width=13, height=9, units="in", res=108)

#put the bottom two plots together as one plot object
#without this you can't have the one wide plot on the top and two on the bottom
bottomRow = plot_grid(visibilityPlot, mrpPlot)

#put the top plot and bottom row created above on one plot 
#defining that it only has one column so that it puts the first on top of the bottom row
plot_grid(weightPlot, bottomRow, ncol=1)
dev.off()