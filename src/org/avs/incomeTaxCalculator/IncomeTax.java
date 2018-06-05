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

        if (taxableIncome < federalBaseAmounts.get(0))
        {

            // NOTE: "Remember to claim the corresponding provincial or territorial non-refundable tax credit to which
            // you are entitled."
            return 0.0;

        } else
        {

            for (int i = 0; i < (federalBaseAmounts.size() - 1); i++)
            {

                if (taxableIncome > federalBaseAmounts.get((i + 1)))
                {

                    federalTax = federalTax
                            + (federalBaseAmounts.get((i + 1)) - federalBaseAmounts.get(i)) * federalTaxRates.get(i);

                } else
                {

                    federalTax = federalTax + (taxableIncome - federalBaseAmounts.get(i)) * federalTaxRates.get(i);

                }

            }

            // Calculates federal tax for the last bracket portion.

            if (taxableIncome > federalBaseAmounts.get(federalBaseAmounts.size() - 1))
            {

                federalTax = federalTax + (taxableIncome - federalBaseAmounts.get(federalBaseAmounts.size() - 1))
                        * federalTaxRates.get(federalBaseAmounts.size() - 1);

            }

            return federalTax;

        }

    }

    public double getProvincialTax()
    {

        if (taxableIncome < provincialBaseAmounts.get(0))
        {

            return 0.0;

        } else
        {

            for (int i = 0; i < (provincialBaseAmounts.size() - 1); i++)
            {

                if (taxableIncome > provincialBaseAmounts.get((i + 1)))
                {

                    provincialTax = provincialTax + (provincialBaseAmounts.get((i + 1)) - provincialBaseAmounts.get(i))
                            * provincialTaxRates.get(i);

                } else
                {

                    provincialTax = provincialTax
                            + (taxableIncome - provincialBaseAmounts.get(i)) * provincialTaxRates.get(i);

                }

            }

            // Calculates provincial tax for the last bracket portion.

            if (taxableIncome > provincialBaseAmounts.get(provincialBaseAmounts.size() - 1))
            {

                provincialTax = provincialTax
                        + (taxableIncome - provincialBaseAmounts.get(provincialBaseAmounts.size() - 1))
                                * provincialTaxRates.get(provincialBaseAmounts.size() - 1);

            }

            return provincialTax;

        }

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