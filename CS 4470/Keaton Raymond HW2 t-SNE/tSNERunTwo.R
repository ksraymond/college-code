#Keaton Raymond
#CS 4470

library(Rtsne)
library(ggplot2)

#---------------------
#Remove Some Columns
#---------------------

#remove disease columns
codDataRunTwo = select(codData, -c("Deaths - Alzheimer's disease and other dementias - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Parkinson's disease - Sex: Both - Age: All Ages (Number)",
                             "Deaths - HIV/AIDS - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Meningitis - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Neoplasms - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Tuberculosis - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Diarrheal diseases - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Cardiovascular diseases - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Chronic kidney disease - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Chronic respiratory diseases - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Cirrhosis and other chronic liver diseases - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Digestive diseases - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Diabetes mellitus - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Acute hepatitis - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Lower respiratory infections - Sex: Both - Age: All Ages (Number)"))

#---------------------
#Run Two Output One
#---------------------

#create and normalize matrix
codMatrixRunTwo = as.matrix(codDataRunTwo[,3:15])
normalizedMatrix = normalize_input(codMatrixRunTwo)

#run t-SNE analysis
tsneOutput = Rtsne(normalizedMatrix, check_duplicates = FALSE)

#convert t-SNE analysis to dataframe
tsneDF = data.frame(x = tsneOutput$Y[,1], y = tsneOutput$Y[,2], col=codDataRunTwo$Continent)

#plot t-SNE analysis and save as a PNG
png("figures/tsneNoDiseaseOutputOne.png")
myPlot = ggplot(tsneDF, label=NA_Sales) + geom_point(aes(x=x, y=y, color=col))
print(myPlot)
dev.off()

#---------------------
#Run Two Output Two
#---------------------

#run t-SNE analysis
tsneOutput = Rtsne(normalizedMatrix, check_duplicates = FALSE)

#convert t-SNE analysis to dataframe
tsneDF = data.frame(x = tsneOutput$Y[,1], y = tsneOutput$Y[,2], col=codDataRunTwo$Continent)

#plot t-SNE analysis and save as a PNG
png("figures/tsneNoDiseaseOutputTwo.png")
myPlot = ggplot(tsneDF, label=NA_Sales) + geom_point(aes(x=x, y=y, color=col))
print(myPlot)
dev.off()

#---------------------
#Run Two Output Three
#---------------------

#run t-SNE analysis
tsneOutput = Rtsne(normalizedMatrix, check_duplicates = FALSE)

#convert t-SNE analysis to dataframe
tsneDF = data.frame(x = tsneOutput$Y[,1], y = tsneOutput$Y[,2], col=codDataRunTwo$Continent)

#plot t-SNE analysis and save as a PNG
png("figures/tsneNoDiseaseOutputThree.png")
myPlot = ggplot(tsneDF, label=NA_Sales) + geom_point(aes(x=x, y=y, color=col))
print(myPlot)
dev.off()