#Keaton Raymond
#CS 4470

library(Rtsne)
library(ggplot2)

#---------------------
#Run One Output One
#---------------------

#create and normalize matrix
codMatrix = as.matrix(codData[,3:30])
normalizedMatrix = normalize_input(codMatrix)

#run t-SNE analysis
tsneOutput = Rtsne(normalizedMatrix, check_duplicates = FALSE)

#convert t-SNE analysis to dataframe
tsneDF = data.frame(x = tsneOutput$Y[,1], y = tsneOutput$Y[,2], col=codData$Continent)

#plot t-SNE analysis and save as a PNG
png("figures/tsneBaseDataOutputOne.png")
myPlot = ggplot(tsneDF, label=NA_Sales) + geom_point(aes(x=x, y=y, color=col))
print(myPlot)
dev.off()

#---------------------
#Run One Output Two
#---------------------

#run t-SNE analysis
tsneOutput = Rtsne(normalizedMatrix, check_duplicates = FALSE)

#convert t-SNE analysis to dataframe
tsneDF = data.frame(x = tsneOutput$Y[,1], y = tsneOutput$Y[,2], col=codData$Continent)

#plot t-SNE analysis and save as a PNG
png("figures/tsneBaseDataOutputTwo.png")
myPlot = ggplot(tsneDF, label=NA_Sales) + geom_point(aes(x=x, y=y, color=col))
print(myPlot)
dev.off()

#---------------------
#Run One Output Three
#---------------------

#run t-SNE analysis
tsneOutput = Rtsne(normalizedMatrix, check_duplicates = FALSE)

#convert t-SNE analysis to dataframe
tsneDF = data.frame(x = tsneOutput$Y[,1], y = tsneOutput$Y[,2], col=codData$Continent)

#plot t-SNE analysis and save as a PNG
png("figures/tsneBaseDataOutputThree.png")
myPlot = ggplot(tsneDF, label=NA_Sales) + geom_point(aes(x=x, y=y, color=col))
print(myPlot)
dev.off()