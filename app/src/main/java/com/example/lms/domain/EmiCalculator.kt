package com.example.lms.domain
import kotlin.math.pow
data class EmiResult(val emi:Double,val interest:Double,val total:Double)
object EmiCalculator{fun calculate(p:Double,rAnnual:Double,n:Int):EmiResult{if(p<=0||n<=0)return EmiResult(0.0,0.0,0.0);if(rAnnual==0.0)return EmiResult(p/n,0.0,p);val r=rAnnual/1200;val f=(1+r).pow(n);val e=p*r*f/(f-1);val t=e*n;return EmiResult(e,t-p,t)}}
