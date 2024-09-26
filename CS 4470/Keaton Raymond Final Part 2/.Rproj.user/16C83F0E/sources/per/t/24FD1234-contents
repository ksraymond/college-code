library(ggplot2)
library(lme4)

#define PNG to save file to
png("Figures/lifeExpectancy.png", width=8, height=8, units="in", res=108)

#run LMM analyses for slope and intercept/a general summary
ranYearSlope = lmer(Year ~ Country + (1 + Lifeexpectancy|Country), data = lifeDataTenCountries)
ranYearSummary = lmer(Year ~ Country + (1|Lifeexpectancy), data = lifeDataTenCountries)

#print output of the summary to a file
sink(file = "LMEROutputs/expectancyRandomSummary.txt")
summary(ranYearSummary)
sink(file = NULL)

#print output of slope to a file
sink(file = "LMEROutputs/expectancyRandomSlope.txt")
summary(ranYearSlope)
sink(file = NULL)

#generate the plot
lifeExpectancyChart = ggplot(lifeDataTenCountries, aes(x = Lifeexpectancy, y = Year, color = Country)) + #define plot params
  geom_point() + #scatterplot
  geom_smooth(method = "lm", se = FALSE, inherit.aes = FALSE, aes(x = Lifeexpectancy, y = Year)) + #define the overall trend line, will explain more in report but this is to show how useless it is with this kind of data
  geom_line(data = cbind(lifeDataTenCountries, pred = predict(ranYearSlope)), aes(y = pred), linewidth = 1) #define the trend lines from the calculated random slopes

print(lifeExpectancyChart)
dev.off()