#Keaton Raymond
#CS 4470

#import library
library(RColorBrewer) #used for getting the color palette for the slices

#define the output PNG
#the first argument defines the filepath of the png file
#the width and height define the dimensions of the PNG file itself
#units defines the units that the width and height are in, in this case inches
#resolution defines the ppi resolution of the image, I chose 108 because that is the ppi of a 27 inch 1440p monitor, which is what I am creating this on
png("figures/outputSpie.png", width=13, height=9, units="in", res=108)

#"par" is a function that allows you to set parameters of the plot
#define the inner (mai) and outer (omi) margins of the plot in inches
par(omi=c(0, 0.25, 0.75, 0.25), mai=c(0.25, 0.25, 0.25, 0.25))

plot.new() #define a new plot to create the chart on
colorVector=rep(NA, numRows) #define an empty color vector for the number of rows needed, the rep function is explained below

#define the list of colors for the different slices
#"numRows" denotes the length needed for the list, i.e. the number of colors needed, "Set3" is the name of the palette chosen
#I chose "Set3" because it looks more similar to the given graph after testing a few of the palettes that had enough colors available
colors=brewer.pal(numRows, "Set3")
for (i in 1:numRows) #iterate through each of the rows in the dataframe
{
  par(new=TRUE) #new=TRUE makes it so that the graph keeps all slices as opposed to overwriting the whole plot with the newest slice
  
  #format the label
  #the format() function convert the total to be in units of millions with 1 decimal point
  formattedTotal=paste(Disease, ": ", format(Total60/1000000, digits=1), " Mio. $") #create the formatted total label for the chart
  if (Acosts60[i]==max(Acosts60)) #if statement making sure that each slice only has 1 label
    description=formattedTotal
  else
    description=NA
  
  #create the color vector
  r=col2rgb(colors[i])[1] #get the red value from the current color
  g=col2rgb(colors[i])[2] #get the green value from the current color
  b=col2rgb(colors[i])[3] #get the blue value from the current color
  colorVector[i]=rgb(r, g, b, alpha=150, maxColorValue=255) #create the color vector for the outer slice with "alpha" being the transparency so that you can view the inner slice
  
  #create the 2 slices for each value
  #Patients60 is the vector that R creates the slice from
  #border=NA means that the slice won't have a black outline/border
  #radius tells R how large to make the slice, this is how we are able to have varying sizes of slices that make it a spie chart
  #col=colorVector changes the color of the slice to be the color chosen from the palette above
  #labels=description sets the label for the slice to be the formatted label from above
  #cex adjusts "character expansion" i.e. font size
  pie(Patients60, border=NA, radius=sqrt(Acosts60[i]/pi)/70,col=colorVector,
      labels=description, cex=1.5) #create outer slice, cex is the text scaling factor, i.e. the font size
  par(new=TRUE) #needed to create inner slice without overwriting the entire plot
  colorVector[i]=rgb(r, g, b, maxColorValue=255) #change the color vector to have 100% opacity for inner slice but with the same RGB values
  #create the inner slice with all of the same parameters as above except with no label because the slice is already labeled and a different value for calculating the radius
  pie(Patients60, border=NA, radius=sqrt(Pcosts60[i]/pi)/70, col=colorVector, labels=NA)
  colorVector=rep(NA, numRows) #reset the color vector, "rep" replicates NA numRows times as the values for colorVector
}

#print the two text lines onto the graph. The graph title and the explanation of the graph
#the first argument is the text to print
#side=3 says to print to side 3 which is the top
#line says what line to print on, starting at 0 and counting out, so since I am printing at the top of the paper, a negative value moves the line down
#adj aligns it to the right
#cex adjusts "character expansion" i.e. font size
#outer uses outer margins
mtext("The Cost of Getting Sick", side=3, line=0, adj=0, cex=3.5, outer=TRUE)
mtext("The Medical Expenditure Panel Survey. Age: 60, Total Costs:  41.4 Mio. US $",
      side=3, line=-2, adj=0, cex=1.75, outer=TRUE)

dev.off()
