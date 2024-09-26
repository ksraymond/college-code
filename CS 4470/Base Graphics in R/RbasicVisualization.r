data1=data.frame(V1=c(1,2,2,3),V2=c(2,3,2,1),V3=c(3,2,2,3))
data2=data.frame(V1=c("Peter","Paul","Paul","Marie"),V2=c(2,3,2,1),V3=c(3,2,2,3))
plot(data1,cex=2)
plot(data2,cex=2)
plot(data2$V1)

library(lattice)
xyplot(data2$V2 ~ data2$V1, cex=2)
library(ggplot2)
qplot(data2$V1)

#library(maptools)
#data3 <- readShapeSpatial("data/london/greater_london_const_region.shp")
#plot(data3)
#########
par(bg="lightyellow")
bar=c(1,4,3,4)
line=bar/2
bp=barplot(bar)
lines(line, col="red")
lines(bp, line, col="blue")


par(mfcol=c(1, 2))
plot(1:10)
plot(1:10, axes=FALSE)
axis(1)
axis(2)
box(lty="solid")

plot(1:10)
lines(10:1)
points(c(7,8,9),c(4,5,6) ,pch=4, col="red")


plot(1:10, lwd=3)
# and
par(lwd=3)
plot(1:10)
# will yield the same results. The parameter lwd stands for "line width". There are
# parameters that are only used in specific graphic functions, but cannot be set up via
# par(). This is why
plot(1:10, type="l")
# creates a line diagram, but
par(type="l")
plot(1:10)

par(bg="chartreuse4")
plot(1:10,cex=3)
plot(1:10,bg="chartreuse4",pch=21,cex=3)


nf <- layout(matrix(c(2,0,1,3),2,2,byrow=TRUE), c(3,1), c(1,3), TRUE)
x <- pmin(3, pmax(-3, stats::rnorm(50)))
y <- pmin(3, pmax(-3, stats::rnorm(50)))
xhist <- hist(x, breaks=seq(-3,3,0.5), plot=FALSE)
yhist <- hist(y, breaks=seq(-3,3,0.5), plot=FALSE)
top <- max(c(xhist$counts, yhist$counts))
par(mai=c(1,1,0.2,0.2))
plot(x, y, xlim=c(-3,3), ylim=c(-3,3), xlab="", ylab="")
par(mai=c(0,1,0.2,0.2))
barplot(xhist$counts, axes=FALSE, ylim=c(0, top), space=0)
par(mai=c(1,0,0.2,0.2))
barplot(yhist$counts, axes=FALSE, xlim=c(0, top), space=0, horiz=TRUE)

layout(matrix(data=c(1,2,3,4,5),nrow=1,ncol=5),
       widths=c(2,1,1,1,1),heights=c(1,1))
par(mai=c(0.5,1,0.5,0),omi=c(0.25,0.25,0.25,0.25))
x<-rnorm(50)
y<-rnorm(50)
plot(x,y,axes=F,col=1,xlim=c(-3,3),ylim=c(-3,3),
     xlab="",ylab="y-axis-\nlabel")
axis(1)
axis(2)
box(lty='solid',col='darkgrey')
par(mai=c(0.5,0,0.5,0))
for (i in 2:5)
{
  x<-rnorm(50)
  y<-rnorm(50)
  plot(x,y,axes=F,col=i,xlim=c(-3,3),ylim=c(-3,3),xlab="")
  if (i %% 2 == 0) {axis(3)} else {axis(1)}
  box(lty='solid',col='darkgrey')
}

x<-c(4,3,1)
y<-c(3,5,2)
cairo_pdf("myfile.pdf", width=8, height=5)
par(mfcol=c(1,2))
barplot(x)
barplot(y)
mtext(side=3,"hello World", outer=F,adj=1)
dev.off()

################ Bar Chart #################

pdf_file<-"barcharts_simple.pdf"
cairo_pdf(bg="gray98",pdf_file,width=9,height=6.5)
par(omi=c(0.65,0.25,0.75,0.75),mai=c(0.3,2,0.35,0),mgp=c(3,3,0),
    family="Lato Light", las=1)
# Import data and prepare chart
library(gdata)
#ipsos<-read.xls("ipsos.xlsx", encoding="latin1")
ipsos<-read.csv("ipsos.csv")
sort.ipsos<-ipsos[order(ipsos$Percent) ,]
attach(sort.ipsos)
# Create chart
x<-barplot(Percent,names.arg=F,horiz=T,border=NA,xlim=c(0,100),col="grey", cex.names=0.85,axes=F)
# Label chart
for (i in 1:length(Country))
{
  if (Country[i] %in% c("Germany","Brazil"))
  {myFont<-"Lato Black"} else {myFont<-"Lato Light"}
  text(-8,x[i],Country[i],xpd=T,adj=1,cex=0.85,family=myFont)
  text(-3.5,x[i],Percent[i],xpd=T,adj=1,cex=0.85,family=myFont)
}
# Other elements
rect(0,-0.5,20,28,col=rgb(191,239,255,80,maxColorValue=255),border=NA)
rect(20,-0.5,40,28,col=rgb(191,239,255,120,maxColorValue=255),border=NA)
rect(40,-0.5,60,28,col=rgb(191,239,255,80,maxColorValue=255),border=NA)
rect(60,-0.5,80,28,col=rgb(191,239,255,120,maxColorValue=255),border=NA)
rect(80,-0.5,100,28,col=rgb(191,239,255,80,maxColorValue=255),border=NA)
myValue2<-c(0,0,0,0,27,0,0,0,0,0,0,0,0,84,0,0)
myColour2<-rgb(255,0,210,maxColorValue=255)
x2<-barplot(myValue2,names.arg=F,horiz=T,border=NA,xlim=c(0,100),col=myColour2,cex.names=0.85,axes=F,add=T)
arrows(45,-0.5,45,20.5,lwd=1.5,length=0,xpd=T,col="skyblue3")
arrows(45,-0.5,45,-0.75,lwd=3,length=0,xpd=T)
arrows(45,20.5,45,20.75,lwd=3,length=0,xpd=T)
text(41,20.5,"Average",adj=1,xpd=T,cex=0.65,font=3)
text(44,20.5,"45",adj=1,xpd=T,cex=0.65,family="Lato",font=4)
text(100,20.5,"All values in percent",adj=1,xpd=T,cex=0.65,font=3)
mtext(c(0,20,40,60,80,100),at=c(0,20,40,60,80,100),1,line=0,cex=0.80)
# Titling
mtext("'I Definitely Believe in God or a Supreme Being'",3,line=1.3,adj=0,cex=1.2,family="Lato Black",outer=T)
mtext("was said in 2010 in:",3,line=-0.4,adj=0,cex=0.9,outer=T)
mtext("Source: www.ipsos-na.com, Design: Stefan Fichtel, ixtract",1,line=1,adj=1.0,cex=0.65,outer=T,font=3)
dev.off()

##### Column Chart #############
pdf_file<-"columncharts_labels_tworows.pdf"
cairo_pdf(bg="grey98", pdf_file,width=7,height=5)
#install.packages("plotrix")
library(plotrix)
library(gdata)
par(mai=c(0.95,0.5,0.0,0.5),omi=c(0,0.5,1.0,0),fg=par("bg"),family="Lato Light",las=1)
# Import data and prepare chart
links<-read.xls("listserv_discussion_traffic.xlsx",sheet=2, encoding="latin1", perl ='C:/Strawberry/perl/bin/perl5.32.1.exe')
attach(links)
sort.links<-links[order(-Number) ,]
myNames<-sort.links$Software
myNumber<-sort.links$Number
py<-c(0,500,1000,1500,2000,2500,3000,3500)
fpy<-format(py,big.mark=",")
# Create chart and other elements
barp(myNumber,cex.axis=0.75,names.arg=myNames,border=NA,col="grey",staxx=T,ylim=c(0,4000),height.at=py,height.lab=fpy)
par(col="black")
staxlab(1,1:length(myNames),myNames,nlines=2,top.line=0.55,font=3,cex=0.75)
abline(h=c(500,1000,1500,2000,2500,3000,3500),col=par("bg"),lwd=3)
# Titling
mtext("Number of links to homepages of statistical software",3,line=2,adj=0,cex=1.4,family="Lato Black",outer=T)
mtext("Source: r4stats.com/popularity",1,line=3,adj=1.0,cex=0.65,font=3)
dev.off()


pdf_file<-"columncharts_shares_1x4.pdf"
cairo_pdf(bg="grey98", pdf_file,width=11,height=7)
par(cex=0.9,omi=c(0.75,0.5,1.25,0.5),mai=c(0.5,1,0.75,1),mgp=c(3,2,0),family="Lato Light",las=1)
# Import data
source("scripts/inc_data_dfg.r", encoding="latin1")
# Create charts and other elements
barplot(x,col=c(myC1a,myC1a,myC2a,myC2a,myC3a,myC3a,myC4a,myC4a),beside=T,border=NA,axes=F,names.arg=c("","","",""))
barplot(2*y,col=c(myC1a,myC1b,myC2a,myC2b,myC3b,myC3b,myC4a,myC4b),beside=T,border=NA,axes=F,add=T,names.arg=labelling,cex.names=1.25)
z<-1
for (i in 1:4)
{
  text(z+0.25,x[1,i]/2,format(round(x[1,i],1),nsmall=1),adj=0)
  text(z+1.25,y[2,i],format(round(y[2,i],1),nsmall=1),adj=0,col="white")
  text(z+0.65,x[1,i]+50,paste(format(round(100*y[2,i]/x[1,i],1),nsmall=1),"%",sep=" "),adj=0,cex=1.5,xpd=T)
  z<-z+3
}
# Titling
mtext("DFG grants in 2010",3,line=4,adj=0,family="Lato Black",outer=T,cex=2)
mtext("Individual grants by science sector, values in million Euro. Percent value: approval quota",3,line=1,adj=0,cex=1.35,font=3,outer=T)
mtext("Source: DFG Information Cards, www.dfg.de",1,line=2,adj=1.0,cex=1.1,font=3,outer=T)
dev.off()

### Pie Charts #######
pdf_file<-"piecharts_simple.pdf"
cairo_pdf(bg="grey98", pdf_file,width=11,height=11)
par(omi=c(2,0.5,1,0.25),mai=c(0,1.25,0.5,0.5),family="Lato Light",las=1)
library(RColorBrewer)
# Create chart
pie.myData<-c(5.8,27.0,0.2,21.1,12.8,33.1)
energytypes<-c("Nuclear energy:","Coal**:","Others***:","Gas:","Renewable\nenergies****:","Oil:")
names(pie.myData)<-paste(energytypes,pie.myData,"%",sep=" ")
pie(pie.myData,col=brewer.pal(length(pie.myData),"Reds"),border=0,cex=1.75,radius=0.9,init.angle=90)
# Titling
mtext("Global energy mix (including sea and air transport)",3,line=2,adj=0,family="Lato Black",outer=T,cex=2.5)
mtext("Shares of energy sources in the primary energy supply*inpercent, 2008",3,line=-0.75,adj=0,cex=1.65,font=3,outer=T)
mtext("* Primary energy sources=primary energy production+imports-exports+/-stock changes",1,line=2,adj=0,cex=1.05,outer=T)
mtext("** Including peat",1,line=3,adj=0,cex=1.05,outer=T)
mtext("*** Bio matter,biodegradable waste (excluding industrialwaste),water power,geothermal energy,solar,wind,and &
marine power.",1,line=4.8,adj=0,cex=1.05,outer=T)
mtext("**** Industrial waste and flammable waste that can serve as energy sources and are non-biodegradable",1,line=6,adj=0,cex=1.05,outer=T)
mtext("Source: German Federal Agency for Civic Education: keyword 'Enegiemix' [energy mix], www.bpb.de [website in &
German]",1,line=8,adj=1,cex=1.25,font=3,outer=T)
dev.off()

