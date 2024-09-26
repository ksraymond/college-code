library(readr)
# import data from a comma delimited file
data(Salaries, package="carData")
Salaries <- read_csv("salaries.csv")

# import data from a tab delimited file
Salaries_txt <- read_tsv("salaries.txt")
library(readxl)

# import data from an Excel workbook
Salaries_xlsx <- read_excel("salaries.xlsx", sheet=1)
Salaries_xlsx2 <- read_excel("salaries.xlsx", sheet=2)
Salaries_xlsx3 <- read_excel("salaries.xlsx")
library(haven)

# import data from Stata
Salaries_dta <- read_dta("salaries.dta")

# import data from SPSS
Salaries_spss <- read_sav("salaries.sav")

# import data from SAS
Salaries_sas7bdat <- read_sas("salaries.sas7bdat")
library(dplyr)

# keep the variables name, height, and gender
newdata <- select(starwars, name, height, gender)

# keep the variables name and all variables 
# between mass and species inclusive
newdata2 <- select(starwars, name, mass:species)

# keep all variables except birth_year and gender
newdata <- select(starwars, -birth_year, -gender)
library(dplyr)

# select females
newdata_female <- filter(starwars, 
                  gender == "female")

# select females that are from Alderaan
newdata <- filter(starwars, 
                  gender == "female" & 
                    homeworld == "Alderaan")

# select females that are from Alderaan
newdata <- filter(starwars, 
                  birth_year > 100 & 
                    mass > 70)


# select individuals that are from 
# Alderaan, Coruscant, or Endor
newdata <- filter(starwars, 
                  homeworld == "Alderaan" | 
                    homeworld == "Coruscant" | 
                    homeworld == "Endor")

# this can be written more succinctly as
newdata2 <- filter(starwars, 
                  homeworld %in% c("Alderaan", "Coruscant", "Endor"))
library(dplyr)

# convert height in centimeters to inches, 
# and mass in kilograms to pounds
newdata <- mutate(starwars, 
                  height = height * 0.394,
                  mass   = mass   * 2.205)
library(dplyr)

# if height is greater than 180 then heightcat = "tall", 
# otherwise heightcat = "short"

newdata <- mutate(starwars, 
                  heightcat = ifelse(height > 180, 
                                     "tall", 
                                     "short"))
                  
# convert any eye color that is not black, blue or brown, to other
newdata <- mutate(starwars, 
                  eye_color = ifelse(eye_color %in% c("black", "blue", "brown"),
                                     eye_color,
                                     "other"))
                                    
# set heights greater than 200 or less than 75 to missing
newdata <- mutate(starwars, 
                  height = ifelse(height < 75 | height > 200,
                                  NA,
                                  height))
                  
library(dplyr)

# calculate mean height and mass
newdata <- summarize(starwars, 
                     mean_ht = mean(height, na.rm=TRUE), 
                     mean_mass = mean(mass, na.rm=TRUE))
newdata
# calculate mean height and weight by gender
newdata <- group_by(starwars, gender)
newdata <- summarize(newdata, 
                     mean_ht = mean(height, na.rm=TRUE), 
                     mean_wt = mean(mass, na.rm=TRUE))
newdata

library(dplyr)

# calculate the mean height for women by species
newdata <- filter(starwars,gender == "female")
newdata <- group_by(newdata, species)
newdata <- summarize(newdata, 
                     mean_ht = mean(height, na.rm = TRUE))

# this can be written as
newdata2 <- starwars %>%
  filter(gender == "female") %>%
  group_by(species) %>%
  summarize(mean_ht = mean(height, na.rm = TRUE))

library(tidyr)
id=c('01','02','03')
name=c("Bill","Bob","Mary")
sex=c("Male","Male","Female")
age=c(22,25,18)
income=c(55000,75000,90000)
wide_data=data.frame(id,name,sex,age,income);
long_data <- gather(wide_data,key="variable", value="value", sex:income)

library(tidyr)
wide_data2 <- spread(long_data, variable, value)

data(msleep, package="ggplot2")

# what is the proportion of missing data for each variable?
pctmiss <- colSums(is.na(msleep))/nrow(msleep)
round(pctmiss, 2)

# Create a dataset containing genus, vore, and conservation.
# Delete any rows containing missing data.
newdata <- select(msleep, genus, vore, conservation)
newdata <- na.omit(newdata)
# Impute missing values using the 5 nearest neighbors
library(VIM)
newdata <- kNN(msleep, k=5)
########### How about PCA? #############
# the materials used in this section is provided by Gareth James 
#for his book "An Introduction to Statistical Learning"
install.packages("tidyverse")
library(tidyverse)  # data manipulation and visualization
library(gridExtra)  # plot arrangement

data("USArrests")
head(USArrests, 10)
# compute variance of each variable
apply(USArrests, 2, var)
##     Murder    Assault   UrbanPop       Rape 
##   18.97047 6945.16571  209.51878   87.72916
# create new data frame with centered variables
scaled_df <- apply(USArrests, 2, scale)
head(scaled_df)

# Calculate eigenvalues & eigenvectors
arrests.cov <- cov(scaled_df)
arrests.eigen <- eigen(arrests.cov)
str(arrests.eigen)
# Extract the loadings
(phi <- arrests.eigen$vectors[,1:2])
phi <- -phi
row.names(phi) <- c("Murder", "Assault", "UrbanPop", "Rape")
colnames(phi) <- c("PC1", "PC2")
phi
# Calculate Principal Components scores
PC1 <- as.matrix(scaled_df) %*% phi[,1]
PC2 <- as.matrix(scaled_df) %*% phi[,2]

# Create data frame with Principal Components scores
PC <- data.frame(State = row.names(USArrests), PC1, PC2)
head(PC)

# Plot Principal Components for each State
ggplot(PC, aes(PC1, PC2)) + 
  modelr::geom_ref_line(h = 0) +
  modelr::geom_ref_line(v = 0) +
  geom_text(aes(label = State), size = 3) +
  xlab("First Principal Component") + 
  ylab("Second Principal Component") + 
  ggtitle("First Two Principal Components of USArrests Data")
PVE <- arrests.eigen$values / sum(arrests.eigen$values)
round(PVE, 2)
## [1] 0.62 0.25 0.09 0.04

# PVE (aka scree) plot
PVEplot <- qplot(c(1:4), PVE) + 
  geom_line() + 
  xlab("Principal Component") + 
  ylab("PVE") +
  ggtitle("Scree Plot") +
  ylim(0, 1)

# Cumulative PVE plot
cumPVE <- qplot(c(1:4), cumsum(PVE)) + 
  geom_line() + 
  xlab("Principal Component") + 
  ylab(NULL) + 
  ggtitle("Cumulative Scree Plot") +
  ylim(0,1)

grid.arrange(PVEplot, cumPVE, ncol = 2)

pca_result <- prcomp(USArrests, scale = TRUE)
names(pca_result)
## [1] "sdev"     "rotation" "center"   "scale"    "x"

# means
pca_result$center
##   Murder  Assault UrbanPop     Rape 
##    7.788  170.760   65.540   21.232

# standard deviations
pca_result$scale
##    Murder   Assault  UrbanPop      Rape 
##  4.355510 83.337661 14.474763  9.366385

pca_result$rotation
##                 PC1        PC2        PC3         PC4
## Murder   -0.5358995  0.4181809 -0.3412327  0.64922780
## Assault  -0.5831836  0.1879856 -0.2681484 -0.74340748
## UrbanPop -0.2781909 -0.8728062 -0.3780158  0.13387773
## Rape     -0.5434321 -0.1673186  0.8177779  0.08902432

pca_result$rotation <- -pca_result$rotation
pca_result$rotation
##                PC1        PC2        PC3         PC4
## Murder   0.5358995 -0.4181809  0.3412327 -0.64922780
## Assault  0.5831836 -0.1879856  0.2681484  0.74340748
## UrbanPop 0.2781909  0.8728062  0.3780158 -0.13387773
## Rape     0.5434321  0.1673186 -0.8177779 -0.08902432

pca_result$x <- - pca_result$x
head(pca_result$x)
##                   PC1        PC2         PC3          PC4
## Alabama     0.9756604 -1.1220012  0.43980366 -0.154696581
## Alaska      1.9305379 -1.0624269 -2.01950027  0.434175454
## Arizona     1.7454429  0.7384595 -0.05423025  0.826264240
## Arkansas   -0.1399989 -1.1085423 -0.11342217  0.180973554
## California  2.4986128  1.5274267 -0.59254100  0.338559240
## Colorado    1.4993407  0.9776297 -1.08400162 -0.001450164
biplot(pca_result, scale = 0, choices = 3:4)
biplot(pca_result, scale = 0)

pca_result$sdev

## [1] 1.5748783 0.9948694 0.5971291 0.4164494
(VE <- pca_result$sdev^2)
## [1] 2.4802416 0.9897652 0.3565632 0.1734301
PVE <- VE / sum(VE)
round(PVE, 2)
## [1] 0.62 0.25 0.09 0.04
####################################33
data(uspopage, package="gcookbook")

data(esoph)
object.size(esoph)
#Download BRFSS as XPT file and unzip to a local file
#URL: http://www.cdc.gov/brfss/annual_data/2013/files/LLCP2013XPT.ZIP
remove.packages(Hmisc)
installed.packages("Hmisc")
library(Hmisc)
brfss <- sasxport.get("LLCP2013.XPT")
brfss1=c(brfss,brfss)
brfss2=merge.data.frame(brfss,brfss,by=brfss$x.state)
brfss3=rbind(brfss,brfss)
brfss4=cbind(brfss,brfss)

dim(brfss)
object.size(brfss)
