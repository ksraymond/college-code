#Keaton Raymond
#CS 4470

library(readr)
library(dplyr)
library(tidyr)

#import cause of death and continent/country CSVs
codDataCSV = read_csv("data/20220327 annual-number-of-deaths-by-cause.csv")
continentsCountries = read_csv("data/continents-according-to-our-world-in-data.csv")

#remove code and year from the continentsCountries dataframe, not necessary for my use
continentsCountries = select(continentsCountries, -c("Code", "Year"))
continentsCountries = unique(continentsCountries) #make sure no duplicates

#merge the two datasets so that I can sort on continent as opposed to country
#which has too many unique values
codData = merge(codDataCSV, continentsCountries, by = "Entity")

#remove some causes of death that have too many blanks, this way I can run the t-SNE properly
#explanation for why in the report
codData = select(codData, -c("Terrorism (deaths)", "Code", 
                             "Deaths - Malaria - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Exposure to forces of nature - Sex: Both - Age: All Ages (Number)",
                             "Deaths - Conflict and terrorism - Sex: Both - Age: All Ages (Number)"))

#remove rows with blank cells to run t-SNE properly
codData = codData %>% drop_na()