#Keaton Raymond
#CS 4470-001

#explanation of differences between my plots and the ones given:
#I tried creating radar charts four different ways.
#first I tried fmsb, however I was unable to change the shape of the overall chart to be circular.
#then I tried to use polar coordinates using ggplot2, but that had its own issues with not closing the polygons for example
#then I tried ggiraphExtra, but was unable to create an even remotely accurate chart
#finally I settled on ggradar, which isn't perfect but as close as I could get.
#the opacity is different because no matter what I tried I was unable to put the red polygon on top of the gray one, 
#   so I settled on changing the opacity.
#I was unable to add more grid lines
#the scaling was difficult as I was just sort of making an educated guess
#the graphs look a little bit different scaling wise because in my charts there is a small circle that it considers to be 0, 
#   but it looks like the given charts use a point as zero.
#I am not sure what exactly the gray polygon is in the given graphs, it looks like it is some sort of a constant, 
#   but I assumed that it is just the graph for "world" which would make the most sense and is what I decided to do, 
#   even though it doesn't look exactly the same.
#overall, while my graphs do look different, working with the information that we were given, 
#   I believe that I did a pretty good job recreating the charts.

#load libraries
library(ggplot2)
library(dplyr)
library(gridExtra)
library(grid)

#these two lines used to install the ggradar package, if that is needed, uncomment and run
#library(devtools) #needed to use install_github
#install_github("ricardo-bion/ggradar", dependencies = TRUE) #used to install ggradar

library("ggradar")

#png for the figures
png("Figures/radarChart.png", width=15, height=11, units="in", res=108) 

#color vector for the 2 colors on the radar chart
colors = c("red", "gray")

#explanation of function:
#ggradar() is from the ggradar library and it allows me to create radar plot
#worldEnergyData[c(1,2),] tells the function to use the first and second rows of the data frame
#grid.min sets the minimum line for the chart
#grid.mid sets the 50% line for the chart
#grid.max sets the outside line for the chart
#plot.legend toggles if the plot has a legend
#group.colors sets the colors to be the 2 defined above
#fill fills the polygons with the color vs. just an outline
#fill.alpha sets the opacity of the fill
#group.point.size sets the size of the points to 0 so there are no points, only lines
#grid.label.size sets the size of the grid line labels to 0 so they do not appear
#ggtitle() changes the title of the plot
#theme() sets the theme of the title to be centered, size 20 font, and bold
#create the radar chart for oecd
oecdChart = ggradar(worldEnergyData[c(1,2),], grid.min = 0, grid.mid = 37.5, 
                    grid.max = 75, plot.legend = FALSE, 
                    group.colours = colors, fill = TRUE, fill.alpha = 0.6,
                    group.point.size = 0, grid.label.size = 0) + 
            ggtitle("OECD") +
            theme(plot.title = element_text(hjust = 0.5, vjust = 0, size = 20, face = 'bold'))

#create the radar plot for asia
asiaChart = ggradar(worldEnergyData[c(1,3),], grid.min = 0, grid.mid = 37.5, 
                    grid.max = 75, plot.legend = FALSE, 
                    group.colours = colors, fill = TRUE, fill.alpha = 0.6,
                    group.point.size = 0, grid.label.size = 0) + 
            ggtitle("Asia") +
            theme(plot.title = element_text(hjust = 0.5, vjust = 0, size = 20, face = 'bold'))

#create the radar plot for the transition countries
transitionChart = ggradar(worldEnergyData[c(1,4),], grid.min = 0, grid.mid = 37.5, 
                    grid.max = 75, plot.legend = FALSE, 
                    group.colours = colors, fill = TRUE, fill.alpha = 0.6,
                    group.point.size = 0, grid.label.size = 0) + 
            ggtitle("Transition Countries") +
            theme(plot.title = element_text(hjust = 0.5, vjust = 0, size = 20, face = 'bold'))

#create the radar plot for africa
africaChart = ggradar(worldEnergyData[c(1,5),], grid.min = 0, grid.mid = 37.5, 
                    grid.max = 75, plot.legend = FALSE, 
                    group.colours = colors, fill = TRUE, fill.alpha = 0.6,
                    group.point.size = 0, grid.label.size = 0) + 
            ggtitle("Africa") +
            theme(plot.title = element_text(hjust = 0.5, vjust = 0, size = 20, face = 'bold'))

#create the radar plot for the middle east
middleEastChart = ggradar(worldEnergyData[c(1,6),], grid.min = 0, grid.mid = 37.5, 
                    grid.max = 75, plot.legend = FALSE, 
                    group.colours = colors, fill = TRUE, fill.alpha = 0.6,
                    group.point.size = 0, grid.label.size = 0) + 
            ggtitle("Middle East") +
            theme(plot.title = element_text(hjust = 0.5, vjust = 0, size = 20, face = 'bold'))

#create the radar plot for latin america
latinChart = ggradar(worldEnergyData[c(1,7),], grid.min = 0, grid.mid = 37.5, 
                    grid.max = 75, plot.legend = FALSE, 
                    group.colours = colors, fill = TRUE, fill.alpha = 0.6,
                    group.point.size = 0, grid.label.size = 0) + 
            ggtitle("Lantin America") +
            theme(plot.title = element_text(hjust = 0.5, vjust = 0, size = 20, face = 'bold'))

#create the two text objects for the title and subtitle, title in bold and subtitle in italic, and left justified
gridTitle = textGrob("World energy mix", gp=gpar(fontsize=30, font=2), hjust=0, x=0)
gridSubtitle = textGrob("Shares of different energy types in total energy use", gp=gpar(fontsize=15, font=3), hjust=0, x=0)

#arrange the 6 charts onto their own grid
charts = grid.arrange(oecdChart, transitionChart, middleEastChart, asiaChart, africaChart, latinChart, nrow = 2)

#arrange the title, subtitle, and grids onto the image
grid.arrange(gridTitle, gridSubtitle, charts, 
             heights = unit.c(grobHeight(gridTitle) + 1.2*(unit(0.5, "line")), grobHeight(gridSubtitle) + unit(0.5, "line"), unit(1, "null")))

dev.off()