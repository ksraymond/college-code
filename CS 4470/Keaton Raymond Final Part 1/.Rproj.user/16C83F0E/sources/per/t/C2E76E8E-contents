##Keaton Raymond
#CS 4470-001

#load libraries
library(ggplot2)
library(ggpol)

#png for the final figure
png("Figures/barChart.png", width=8, height=9, units="in", res=108)

#create the age structure dataframe with the "age" and the data from 2010
menAgeStructureFrame = data.frame(col1 = c(1:nrow(menData)), col2 = menData$"2010")
#rename the columns of the age structure dataframe
colnames(menAgeStructureFrame) = c("Age", "AgeStructure")

#same as above but for women
womenAgeStructureFrame = data.frame(col1 = c(1:nrow(womenData)), col2 = womenData$"2010")
colnames(womenAgeStructureFrame) = c("Age", "AgeStructure")

#add a "gender" column to each to differentiate
menAgeStructureFrame$Gender = "Men"
womenAgeStructureFrame$Gender = "Women"

#add a "color" column to be able to change the colors for each of the age groups
menAgeStructureFrame$Color = NA
menAgeStructureFrame$Color[c(1:15)] = "lightgray"
menAgeStructureFrame$Color[c(16:65)] = "darkgray"
menAgeStructureFrame$Color[c(66:nrow(menAgeStructureFrame))] = "coral"

#same as above but for women
womenAgeStructureFrame$Color = NA
womenAgeStructureFrame$Color[c(1:15)] = "lightgray"
womenAgeStructureFrame$Color[c(16:65)] = "darkgray"
womenAgeStructureFrame$Color[c(66:nrow(menAgeStructureFrame))] = "coral"

#flip the sign of the "men" values so that it faces the other direction
menAgeStructureFrame$AgeStructure = menAgeStructureFrame$AgeStructure*-1

#put the dataframes into one to create the chart
chartFrame = rbind(menAgeStructureFrame, womenAgeStructureFrame)

#create the chart
finalChart = ggplot(chartFrame, aes(x = Age, y = AgeStructure, fill = Color)) + #set chart params
  geom_bar(stat = "identity", show.legend = FALSE, width = 1) + #bar chart with no legend and thicker bars
  facet_share(~Gender, dir = "h", scales = "free", reverse_num = TRUE) + #built 2 panels with a shared axis, reverse_num makes it so that the axis for men isnt negative
  coord_flip() + #turn the plot sideways
  scale_y_continuous(breaks = seq(-600, 600, by = 200), expand = c(0,0)) + #set the y axis ticks
  scale_x_continuous(breaks = seq(10, 90, by=10)) + #set the x axis ticks
  labs(y="", x="working age", title = "Age structure of the population in Germany in 2010", 
       subtitle = "Values in thousands per year of age") + #set labels for axes and title/subtitle
  theme_classic() + #removes the grid background
  theme(axis.ticks.x = element_blank(), #remove x axis ticks
        axis.line.x = element_blank(), #remove x axis line 
        axis.text.x = element_text(vjust = 12), #move x axis text up
        axis.ticks.y = element_line(linewidth = 0),  #remove y axis ticks
        axis.text.y = element_text(size = 15), #make y axis labels larger
        strip.background = element_blank(), #remove background from "Men" and "Women" title
        strip.text.x = element_text(size = 15, color = "gray", face = "bold", vjust = -1), #change text for "Men" and "Women" titles
        plot.title = element_text(size = 18, hjust = -0.3), #change the size and placement of title
        plot.subtitle = element_text(size = 10, face = "italic", hjust = -0.1)) + #change size and placement of subtitle
  annotate("rect", xmin = 16, xmax = 66, ymin = -Inf, ymax = Inf, fill = "gray", alpha = 0.5) + #add the transparent gray box
  scale_fill_manual(values = c("lightgray" = "lightgray", "darkgray" = "darkgray", "coral" = "coral")) #set the colors to the proper values

#print the chart to the png
print(finalChart)
dev.off()