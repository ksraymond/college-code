# https://stat.ethz.ch/pipermail/r-devel/2003-March/026043.html
# http://www.adamgberger.com/3ps/R/src/library/stats/R/ftable.R
#  File src/library/stats/R/ftable.R
#  Part of the R package,http://www.R-project.org
#
#  This program is free software; you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation; either version 2 of the License,or
#  (at your option) any later version.
#
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#
#  A copy of the GNU General Public License is available at
#  http://www.r-project.org/Licenses/

ftable<-function(x,...) UseMethod("ftable")

ftable.default<-function(...,exclude=c(NA,NaN),
                           row.vars=NULL,col.vars=NULL,pcnt=c("n","row","column","total","gtotal")) {
    args<-list(...)
    if (length(args) == 0L)
        stop("nothing to tabulate")
    x<-args[[1L]]
    if(is.list(x))
        x<-table(x,exclude=exclude)
    else if(inherits(x,"ftable")) {
        x<-as.table(x)
    }
    else if(!(is.array(x) && (length(dim(x)) > 1L))) {
        x<-table(...,exclude=exclude)
    }
    dn<-dimnames(x)
    dx<-dim(x)
    n<-length(dx)
    if(!is.null(row.vars)) {
        if(is.character(row.vars)) {
            i<-pmatch(row.vars,names(dn))
            if(any(is.na(i)))
                stop("incorrect specification for 'row.vars'")
            row.vars<-i
        } else if(any((row.vars < 1) | (row.vars > n)))
            stop("incorrect specification for 'row.vars'")
    }
    if(!is.null(col.vars)) {
        if(is.character(col.vars)) {
            i<-pmatch(col.vars,names(dn))
            if(any(is.na(i)))
             stop("incorrect specification for 'col.vars'")
            col.vars<-i
        } else if(any((col.vars < 1) | (col.vars > n)))
            stop("incorrect specification for 'col.vars'")
    }
    i<-1 : n
    if(!is.null(row.vars) && !is.null(col.vars)) {
        all.vars<-sort(c(row.vars,col.vars))
        if (length(all.vars) < n) {
            x<-apply(x,all.vars,sum)
            row.vars<-match(row.vars,all.vars)
            col.vars<-match(col.vars,all.vars)
            dn<-dn[all.vars]
            dx<-dx[all.vars]
        }
    }
    else if(!is.null(row.vars))
        col.vars<-i[-row.vars]
    else if(!is.null(col.vars))
        row.vars<-i[-col.vars]
    else {
        row.vars<-1 : (n-1)
        col.vars<-n
    }

pcnt<-match.arg(pcnt)
if (pcnt!="n") {
    if (pcnt=="row")    {mrg2drop<-col.vars[length(col.vars)]}
    if (pcnt=="column") {mrg2drop<-row.vars[length(row.vars)]}
    if (pcnt=="total") 
{mrg2drop<-c(col.vars[length(col.vars)],row.vars[length(row.vars)])}
    if (pcnt=="gtotal") {mrg2drop<-0}
    x<-prop.table(x,i[-mrg2drop])*100
}

    y<-aperm(x,c(rev(row.vars),rev(col.vars)))
    dim(y)<-c(prod(dx[row.vars]),prod(dx[col.vars]))
    attr(y,"row.vars")<-dn[row.vars]
    attr(y,"col.vars")<-dn[col.vars]
    class(y)<-"ftable"
    y
}

ftable.formula<-function(formula,data=NULL,subset,na.action,...)
{
    if(missing(formula) || !inherits(formula,"formula"))
        stop("'formula' missing or incorrect")
    if(length(formula) != 3L)
        stop("'formula' must have both left and right hand sides")
    ## need to cope with '.' in formula
    tt<-if(is.data.frame(data)) terms(formula,data=data)
    else terms(formula,allowDotAsName=T)
    if(any(attr(tt,"order") > 1))
        stop("interactions are not allowed")
    ## here we do NOT want '.' expanded
    rvars<-attr(terms(formula[-2L],allowDotAsName=T),"term.labels")
    cvars<-attr(terms(formula[-3L],allowDotAsName=T),"term.labels")
    rhs.has.dot<-any(rvars == ".")
    lhs.has.dot<-any(cvars == ".")
    if(lhs.has.dot && rhs.has.dot)
        stop("'formula' has '.' in both left and right hand side")
    m<-match.call(expand.dots =F)
    edata<-eval(m$data,parent.frame())
    if(inherits(edata,"ftable")
       || inherits(edata,"table")
       || length(dim(edata)) > 2L) {
        if(inherits(edata,"ftable")) {
            data<-as.table(data)
        }
        varnames<-names(dimnames(data))
        if(rhs.has.dot)
            rvars<-NULL
        else {
            i<-pmatch(rvars,varnames)
            if(any(is.na(i)))
                stop("incorrect variable names in rhs of formula")
            rvars<-i
        }
        if(lhs.has.dot)
            cvars<-NULL
        else {
            i<-pmatch(cvars,varnames)
            if(any(is.na(i)))
                stop("incorrect variable names in lhs of formula")
            cvars<-i
        }
        #ftable(data,row.vars=rvars,col.vars=cvars)
        ftable(data,row.vars=rvars,col.vars=cvars,...)
    }
    else {
        if(is.matrix(edata))
            m$data<-as.data.frame(data)
        m$...<-NULL
        if(!is.null(data) && is.environment(data)) {
            varnames<-names(data)
            if(rhs.has.dot)
                rvars<-seq_along(varnames)[-cvars]
            if(lhs.has.dot)
                cvars<-seq_along(varnames)[-rvars]
        }
        else {
            if(lhs.has.dot || rhs.has.dot)
                stop("cannot use dots in formula with given data")
        }
        m$formula<-as.formula(paste("~",
                                   paste(c(rvars,cvars),
                                         collapse="+")),
                                env=environment(formula))
        m[[1L]]<-as.name("model.frame")
        mf<-eval(m,parent.frame())
        ftable(mf,row.vars=rvars,col.vars=cvars,...)
    }
}

as.table.ftable<-function(x,...)
{
    if(!inherits(x,"ftable"))
        stop("'x' must be an \"ftable\" object")
    xrv<-rev(attr(x,"row.vars"))
    xcv<-rev(attr(x,"col.vars"))
    x<-array(data=c(x),
               dim=c(sapply(xrv,length),
                       sapply(xcv,length)),
               dimnames=c(xrv,xcv))
    nrv<-length(xrv)
    ncv<-length(xcv)
    x<-aperm(x,c(rev(seq_len(nrv)),rev(seq_len(ncv) + nrv)))
    class(x)<-"table"
    x
}

format.ftable<-function(x,quote =T,digits=getOption("digits"),...)
{
    if(!inherits(x,"ftable"))
        stop("'x' must be an \"ftable\" object")
    charQuote<-function(s)
        if(quote) paste("\"",s,"\"",sep="") else s
    makeLabels<-function(lst) {
        lens<-sapply(lst,length)
        cplensU<-c(1,cumprod(lens))
        cplensD<-rev(c(1,cumprod(rev(lens))))
        y<-NULL
        for (i in rev(seq_along(lst))) {
            ind<-1 + seq.int(from=0,to=lens[i] - 1) * cplensD[i + 1]
            tmp<-character(length=cplensD[i])
            tmp[ind]<-charQuote(lst[[i]])
            y<-cbind(rep(tmp,times=cplensU[i]),y)
        }
        y
    }
    makeNames<-function(x) {
        nmx<-names(x)
        if(is.null(nmx))
            nmx<-rep("",length.out=length(x))
        nmx
    }

    xrv<-attr(x,"row.vars")
    xcv<-attr(x,"col.vars")
    LABS<-cbind(rbind(matrix("",nrow=length(xcv),ncol=length(xrv)),
                        charQuote(makeNames(xrv)),
                        makeLabels(xrv)),
                  c(charQuote(makeNames(xcv)),
                    rep("",times=nrow(x) + 1)))
    DATA<-rbind(if(length(xcv)) t(makeLabels(xcv)),
                  rep("",times=ncol(x)),
                  format(unclass(x),digits=digits))
    cbind(apply(LABS,2L,format,justify="left"),
	  apply(DATA,2L,format,justify="right"))
}

write.ftable<-function(x,file="",quote =T,append =F,
			 digits=getOption("digits"))
{
    r<-format.ftable(x,quote=quote,digits=digits)
    cat(t(r),file=file,append=append,
	sep=c(rep(" ",ncol(r) - 1),"\n"))
    invisible(x)
}

print.ftable<-function(x,digits=getOption("digits"),...)
    write.ftable(x,quote =F,digits=digits)

read.ftable<-function(file,sep="",quote="\"",row.var.names,
                        col.vars,skip=0)
{
    if(is.character(file)) {
        file<-file(file,"r")
        on.exit(close(file))
    }
    if(!inherits(file,"connection"))
        stop("'file' must be a character string or connection")
    if(!isSeekable(file)) {
        ## We really need something seekable,see below.  If it is not,
        ## the best we can do is write everything to a tempfile.
        tmpf<-tempfile()
        cat(readLines(file),file=tmpf,sep="\n")
        file<-file(tmpf,"r")
        on.exit({close(file);unlink(tmpf)},add=T)
    }

    z<-utils::count.fields(file,sep,quote,skip)
    n.row.vars<-z[max(which(z == max(z)))] - z[length(z)] + 1

    seek(file,where=0)
    if(skip > 0) readLines(file,skip)
    lines<-readLines(file)
    seek(file,where=0)
    if(skip > 0) readLines(file,skip)

    i<-which(z == n.row.vars)
    ## For an ftable,we have
    ##                     cv.1.nm cv.1.l1 .........
    ##                     cv.2.nm cv.2.l1 .........
    ## rv.1.nm ... rv.k.nm
    ## rv.1.l1 ... rv.k.l1         ...     ...
    ##
    ## so there is exactly one line which does not start with a space
    ## and has n.row.vars fields (and it cannot be the first one).
    j<-i[grep("^[^[:space:]]",lines[i])]
    if((length(j) == 1L) && (j > 1)) {
        ## An ftable: we can figure things out ourselves.
        n.col.vars<-j - 1
        col.vars<-vector("list",length=n.col.vars)
        n<-c(1,z[1 : n.col.vars] - 1)
        for(k in seq.int(from=1,to=n.col.vars)) {
            s<-scan(file,what="",sep=sep,quote=quote,
                      nlines=1,quiet =T)
            col.vars[[k]]<-s[-1L]
            names(col.vars)[k]<-s[1L]
        }
        row.vars<-vector("list",length=n.row.vars)
        names(row.vars)<-scan(file,what="",sep=sep,quote =
                                quote,nlines=1,quiet =T)
        z<-z[-(1 : (n.col.vars + 1))]
    }
    else {
        ## This is not really an ftable.
        if((z[1L] == 1) && z[2L] == max(z)) {
            ## Case A.  File looks like
            ##
            ##                                cvar.nam
            ## rvar.1.nam   ... rvar.k.nam    cvar.lev.1 ... cvar.lev.l
            ## rvar.1.lev.1 ... rvar.k.lev.1  ...        ... ...
            ##
            n.col.vars<-1
            col.vars<-vector("list",length=n.col.vars)
            s<-scan(file,what="",sep=sep,quote=quote,
                      nlines=2,quiet =T)
            names(col.vars)<-s[1L]
            s<-s[-1L]
            row.vars<-vector("list",length=n.row.vars)
            i<-1 : n.row.vars
            names(row.vars)<-s[i]
            col.vars[[1L]]<-s[-i]
            z<-z[-(1 : 2)]
        }
        else {
            ## Case B.
            ## We cannot determine the names and levels of the column
            ## variables,and also not the names of the row variables.
            if(missing(row.var.names)) {
                ## 'row.var.names' should be a character vector (or
                ## factor) with the names of the row variables.
                stop("'row.var.names' missing")
            }
            n.row.vars<-length(row.var.names)
            row.vars<-vector("list",length=n.row.vars)
            names(row.vars)<-as.character(row.var.names)
            if(missing(col.vars) || !is.list(col.vars)) {
                ## 'col.vars' should be a list.
                stop("'col.vars' missing or incorrect")
            }
            col.vars<-lapply(col.vars,as.character)
            n.col.vars<-length(col.vars)
            if(is.null(names(col.vars)))
                names(col.vars)<-
                    paste("Factor",seq_along(col.vars),sep=".")
            else {
                nam<-names(col.vars)
                ind<-which(!nzchar(nam))
                names(col.vars)[ind]<-
                    paste("Factor",ind,sep=".")
            }
        }
    }

    p<-1
    n<-integer(n.row.vars)
    for(k in seq.int(from=1,to=n.row.vars)) {
        n[k]<-sum(z >= max(z) - k + 1) / p
        p<-p * n[k]
    }
    is.row.lab<-rep(rep(c(TRUE,FALSE),length(z)),
                      c(rbind(z - min(z) + 1,min(z) - 1)))
    s<-scan(file,what="",sep=sep,quote=quote,quiet =T)
    values<-as.numeric(s[!is.row.lab])
    tmp<-s[is.row.lab]
    len<-length(tmp)
    for(k in seq.int(from=1,to=n.row.vars)) {
        i<-seq.int(from=1,to=len,by=len / n[k])
        row.vars[[k]]<-unique(tmp[i])
        tmp<-tmp[seq.int(from=2,to=len / n[k])]
        len<-length(tmp)
    }
    values<-matrix(values,
                     nrow=prod(sapply(row.vars,length)),
                     ncol=prod(sapply(col.vars,length)),
                     byrow =T)
    structure(values,
              row.vars=row.vars,
              col.vars=col.vars,
              class="ftable")
}

as.data.frame.ftable<-
function(x,row.names=NULL,optional =F,...)
    as.data.frame(as.table(x),row.names,optional)