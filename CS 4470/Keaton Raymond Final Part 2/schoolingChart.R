library(ggplot2)
library(lme4)

#define png for final chart
png("Figures/schooling.png", width=8, height=8, units="in", res=108)

#run LMM analyses for slope and intercept/a general summary
ranSchoolSlope = lmer(Lifeexpectancy ~ Country + (1 + Schooling|Country), data = schoolingDataTenCountries)
ranSchoolSummary = lmer(Lifeexpectancy ~ Country + (1|Schooling), data = schoolingDataTenCountries)

#print output of the summary to a file
sink(file = "LMEROutputs/schoolingRandomSummary.txt")
summary(ranSchoolSummary)
sink(file = NULL)

#print output of slope to a file
sink(file = "LMEROutputs/SchoolingRandomSlope.txt")
summary(ranSchoolSlope)
sink(file = NULL)

#generate the plot
schoolingChart = ggplot(schoolingDataTenCountries, aes(x = Schooling, y = Lifeexpectancy, color = Country)) + #plot parameters
  geom_point() + #scatterplot
  geom_smooth(method = "lm", se = FALSE, inherit.aes = FALSE, aes(x = Schooling, y = Lifeexpectancy)) + #define overall trend line
  geom_line(data = cbind(schoolingDataTenCountries, pred = predict(ranSchoolSlope)), aes(y = pred), linewidth = 1) #define individual trend lines for each country grouping

print(schoolingChart)
dev.off()