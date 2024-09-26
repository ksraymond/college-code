#Keaton Raymond
#CS 4470-001

library(tidyverse)

lifeData = read.csv("Data/lifeExpectancy.csv")

#Afghanistan
#Bahamas
#Canada
#UnitedStatesofAmerica
#Panama

#changed canada to developed because for some reason it was set to "Developing" and according to my research canada was a developed country well before 2000
lifeData[lifeData$Country == "Canada",]$Status = "Developed"

lifeDataTenCountries = lifeData[lifeData$Country %in% c("Afghanistan", "Serbia", "Canada", "UnitedStatesofAmerica", "Guatemala", "Australia", "Belgium", "Germany", "Pakistan", "Nigeria"),]

#manually filter out outliers that are significantly outside of the expected value for that year, more explanation in report for why
lifeDataTenCountries = lifeDataTenCountries[!(lifeDataTenCountries$Country == "Canada" & (lifeDataTenCountries$Year == "2006" | lifeDataTenCountries$Year == "2007" | lifeDataTenCountries$Year == "2008")),]
lifeDataTenCountries = lifeDataTenCountries[!(lifeDataTenCountries$Country == "Guatemala" & (lifeDataTenCountries$Year == "2006" | lifeDataTenCountries$Year == "2007" | lifeDataTenCountries$Year == "2008" | lifeDataTenCountries$Year == "2009" | lifeDataTenCountries$Year == "2010")),]
lifeDataTenCountries = lifeDataTenCountries[!(lifeDataTenCountries$Country == "Australia" & (lifeDataTenCountries$Year == "2003" | lifeDataTenCountries$Year == "2004")),]
lifeDataTenCountries = lifeDataTenCountries[!(lifeDataTenCountries$Country == "Belgium" & (lifeDataTenCountries$Year == "2011" | lifeDataTenCountries$Year == "2012" | lifeDataTenCountries$Year == "2013" | lifeDataTenCountries$Year == "2014")),]
lifeDataTenCountries = lifeDataTenCountries[!(lifeDataTenCountries$Country == "Germany" & (lifeDataTenCountries$Year == "2011" | lifeDataTenCountries$Year == "2012" | lifeDataTenCountries$Year == "2013" | lifeDataTenCountries$Year == "2014")),]
lifeDataTenCountries = lifeDataTenCountries[!(lifeDataTenCountries$Country == "Nigeria" & (lifeDataTenCountries$Year == "2007" | lifeDataTenCountries$Year == "2008")),]

#remove the USA which doesn't have schooling info and replace it with the Netherlands
schoolingDataTenCountries = lifeDataTenCountries[!(lifeDataTenCountries$Country == "UnitedStatesofAmerica"),]
schoolingDataTenCountries = rbind(schoolingDataTenCountries, lifeData[lifeData$Country == "Netherlands",])

schoolingDataTenCountries = schoolingDataTenCountries[!(schoolingDataTenCountries$Country == "Netherlands" & (schoolingDataTenCountries$Year == "2007" | schoolingDataTenCountries$Year == "2008" | schoolingDataTenCountries$Year == "2009" | schoolingDataTenCountries$Year == "2010")),]
