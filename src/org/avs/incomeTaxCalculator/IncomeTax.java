package org.avs.incomeTaxCalculator;

/**
 * 
 * Manages input and output data in a safe manner by utilizing getters and setters.
 * 
 * @author Andrey Skvortsov
 * 
 */

public class IncomeTax
{

    private int id;
    private String territory;
    private double taxableIncome;

    private double federalBaseAmount;
    private double federalTaxRate;
    private double provincialBaseAmount;
    private double provincialTaxRate;

    private double federalTax;
    private double provincialTax;
    private double totalTax;
    private double afterTaxIncome;
    private double averageTaxRate;
    private double marginalTaxRate;

    public IncomeTax(int id, double taxableIncome, double federalBaseAmount, double federalTaxRate,
            double provincialBaseAmount, double provincialTaxRate)
    {

        super();
        this.id = id;
        this.taxableIncome = taxableIncome;
        this.federalBaseAmount = federalBaseAmount;
        this.federalTaxRate = federalTaxRate;
        this.provincialBaseAmount = provincialBaseAmount;
        this.provincialTaxRate = provincialTaxRate;

    }

    public int getId()
    {

        return id;
    }

    public void setId(int id)
    {

        this.id = id;
    }

    public String getTerritory()
    {

        return territory;
    }

    public void setTerritory(String territory)
    {

        this.territory = territory;
    }

    public double getTaxableIncome()
    {

        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome)
    {

        this.taxableIncome = taxableIncome;
    }

    public double getFederalBaseAmount()
    {

        return federalBaseAmount;
    }

    public void setFederalBaseAmount(double federalBaseAmount)
    {

        this.federalBaseAmount = federalBaseAmount;
    }

    public double getFederalTaxRate()
    {

        return federalTaxRate;
    }

    public void setFederalTaxRate(double federalTaxRate)
    {

        this.federalTaxRate = federalTaxRate;
    }

    public double getProvincialBaseAmount()
    {

        return provincialBaseAmount;
    }

    public void setProvincialBaseAmount(double provincialBaseAmount)
    {

        this.provincialBaseAmount = provincialBaseAmount;
    }

    public double getProvincialTaxRate()
    {

        return provincialTaxRate;
    }

    public void setProvincialTaxRate(double provincialTaxRate)
    {

        this.provincialTaxRate = provincialTaxRate;
    }

    public double getFederalTax()
    {

        return federalTax;
    }

    public void setFederalTax(double federalTax)
    {

        this.federalTax = federalTax;
    }

    public double getProvincialTax()
    {

        return provincialTax;
    }

    public void setProvincialTax(double provincialTax)
    {

        this.provincialTax = provincialTax;
    }

    public double getTotalTax()
    {

        return totalTax;
    }

    public void setTotalTax(double totalTax)
    {

        this.totalTax = totalTax;
    }

    public double getAfterTaxIncome()
    {

        return afterTaxIncome;
    }

    public void setAfterTaxIncome(double afterTaxIncome)
    {

        this.afterTaxIncome = afterTaxIncome;
    }

    public double getAverageTaxRate()
    {

        return averageTaxRate;
    }

    public void setAverageTaxRate(double averageTaxRate)
    {

        this.averageTaxRate = averageTaxRate;
    }

    public double getMarginalTaxRate()
    {

        return marginalTaxRate;
    }

    public void setMarginalTaxRate(double marginalTaxRate)
    {

        this.marginalTaxRate = marginalTaxRate;
    }

    @Override
    public String toString()
    {

        return "IncomeTax [id=" + id + ", territory=" + territory + ", taxableIncome=" + taxableIncome
                + ", federalBaseAmount=" + federalBaseAmount + ", federalTaxRate=" + federalTaxRate
                + ", provincialBaseAmount=" + provincialBaseAmount + ", provincialTaxRate=" + provincialTaxRate
                + ", federalTax=" + federalTax + ", provincialTax=" + provincialTax + ", totalTax=" + totalTax
                + ", afterTaxIncome=" + afterTaxIncome + ", averageTaxRate=" + averageTaxRate + ", marginalTaxRate="
                + marginalTaxRate + "]";

    }

}