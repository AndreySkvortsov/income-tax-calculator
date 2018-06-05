package org.avs.incomeTaxCalculator;

import java.util.List;

/**
 * 
 * Manages input and output data in a safe manner by utilizing getters and setters.
 * 
 * @author Andrey Skvortsov
 * 
 */

public class IncomeTax
{

    private double taxableIncome;

    private List<Double> federalBaseAmounts;
    private List<Double> federalTaxRates;
    private List<Double> provincialBaseAmounts;
    private List<Double> provincialTaxRates;

    private double federalTax;
    private double provincialTax;
    private double totalTax;
    private double afterTaxIncome;
    private double averageTaxRate;
    private double marginalTaxRate;

    public IncomeTax(double taxableIncome, List<Double> federalBaseAmounts, List<Double> federalTaxRates,
            List<Double> provincialBaseAmounts, List<Double> provincialTaxRates)
    {

        this.taxableIncome = taxableIncome;
        this.federalBaseAmounts = federalBaseAmounts;
        this.federalTaxRates = federalTaxRates;
        this.provincialBaseAmounts = provincialBaseAmounts;
        this.provincialTaxRates = provincialTaxRates;

    }

    public double getFederalTax()
    {

        return federalTax;

    }

    public double getProvincialTax()
    {

        return provincialTax;

    }

    public double getTotalTax()
    {

        return (federalTax + provincialTax);

    }

    public double getAfterTaxIncome()
    {

        return (taxableIncome - getTotalTax());

    }

    public double getAverageTaxRate()
    {

        return averageTaxRate;

    }

    public double getMarginalTaxRate()
    {

        return marginalTaxRate;

    }

    @Override
    public String toString()
    {

        return "IncomeTax [taxableIncome=" + taxableIncome + ", federalBaseAmounts=" + federalBaseAmounts
                + ", federalTaxRates=" + federalTaxRates + ", provincialBaseAmounts=" + provincialBaseAmounts
                + ", provincialTaxRates=" + provincialTaxRates + ", federalTax=" + federalTax + ", provincialTax="
                + provincialTax + ", totalTax=" + totalTax + ", afterTaxIncome=" + afterTaxIncome + ", averageTaxRate="
                + averageTaxRate + ", marginalTaxRate=" + marginalTaxRate + "]";
    }

}