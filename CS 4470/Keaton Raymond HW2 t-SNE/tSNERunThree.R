#Keaton Raymond
#CS 4470

library(Rtsne)
library(ggplot2)

#---------------------
#Remove Some More Columns
#---------------------

#remove columns related to violence, external causes, or self caused
codDataRunThree = select(codData, -c("Deaths - Fire, heat, and hot substances - Sex: Both - Age: All Ages (Number)",
                                     "Deaths - Drowning - Sex: Both - Age: All Ages (Number)",
                                     "Deaths - Interpersonal violence - Sex: Both - Age: All Ages (Number)",
                                     "Deaths - Road injuries - Sex: Both - Age: All Ages (Number)",
                                     "Deaths - Self-harm - Sex: Both - Age: All Ages (Number)",
                                     "Deaths - Poisonings - Sex: Both - Age: All Ages (Number)",
                                     "Deaths - Alcohol use disorders - Sex: Both - Age: All Ages (Number)",
                                     "Deaths - Drug use disorders - Sex: Both - Age: All Ages (Number)",
                                     "Deaths - Environmental heat and cold exposure - Sex: Both - Age: All Ages (Number)"))

#---------------------
#Run Three Output One
#---------------------

#create and normalize matrix
codMatrixRunThree = as.matrix(codDataRunThree[,3:21])
normalizedMatrix = normalize_input(codMatrixRunThree)

#run t-SNE analysis
tsneOutput = Rtsne(normalizedMatrix, check_duplicates = FALSE)

#convert t-SNE analysis to dataframe
tsneDF = data.frame(x = tsneOutput$Y[,1], y = tsneOutput$Y[,2], col=codDataRunThree$Continent)

#plot t-SNE analysis and save as a PNG
png("figures/tsneNoViolenceOutputOne.png")
myPlot = ggplot(tsneDF, label=NA_Sales) + geom_point(aes(x=x, y=y, color=col))
print(myPlot)
dev.off()

#---------------------
#Run Three Output Two
#---------------------

#run t-SNE analysis
tsneOutput = Rtsne(normalizedMatrix, check_duplicates = FALSE)

#convert t-SNE analysis to dataframe
tsneDF = data.frame(x = tsneOutput$Y[,1], y = tsneOutput$Y[,2], col=codDataRunThree$Continent)

#plot t-SNE analysis and save as a PNG
png("figures/tsneNoViolenceOutputTwo.png")
myPlot = ggplot(tsneDF, label=NA_Sales) + geom_point(aes(x=x, y=y, color=col))
print(myPlot)
dev.off()

#---------------------
#Run Three Output Three
#---------------------

#run t-SNE analysis
tsneOutput = Rtsne(normalizedMatrix, check_duplicates = FALSE)

#convert t-SNE analysis to dataframe
tsneDF = data.frame(x = tsneOutput$Y[,1], y = tsneOutput$Y[,2], col=codDataRunThree$Continent)

#plot t-SNE analysis and save as a PNG
png("figures/tsneNoViolenceOutputThree.png")
myPlot = ggplot(tsneDF, label=NA_Sales) + geom_point(aes(x=x, y=y, color=col))
print(myPlot)
dev.off()