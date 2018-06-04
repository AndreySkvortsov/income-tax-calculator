package org.avs.incomeTaxCalculator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * 
 * Implements database utility class IncomeTaxCalculatorDbUtil.
 * 
 * @author Andrey Skvortsov
 * 
 */

public class IncomeTaxCalculatorDbUtil
{

    private DataSource dataSource;

    public IncomeTaxCalculatorDbUtil(DataSource dataSource)
    {

        this.dataSource = dataSource;

    }

    public List<IncomeTax> calculateIncomeTax(String territory, Double taxableIncome) throws Exception
    {

        List<IncomeTax> incomeTax = new ArrayList<>();

        Connection myConnection = null;
        PreparedStatement myStatement = null;
        ResultSet myResultSet = null;

        try
        {

            // Connects to a database.

            myConnection = dataSource.getConnection();

            // Searches for tax rates in case taxable income is not empty/greater than zero.

            if (taxableIncome != null && taxableIncome >= 0)
            {

                // Creates SQL statement to search for federal/provincial tax rates.

                String sql = "SELECT * FROM federal_tax WHERE federal_tax.base_amount <= ? UNION ALL SELECT * FROM provincial_tax WHERE provincial_tax.base_amount <= ? AND provincial_tax.territory LIKE ?";

                // Creates Prepared Statement.

                myStatement = myConnection.prepareStatement(sql);

                // Sets parameters.

                String theTerritory = "%" + territory.toLowerCase() + "%";

                myStatement.setDouble(1, taxableIncome);
                myStatement.setDouble(2, taxableIncome);
                myStatement.setString(3, theTerritory);

            }

            // Executes SQL statements.

            myResultSet = myStatement.executeQuery();

            // Retrieves data from the result set.

            double federalBaseAmount = 0;
            double federalTaxRate = 0;
            
            double provincialBaseAmount = 0;
            double provincialTaxRate = 0;

            while (myResultSet.next())
            {
                
                int id = myResultSet.getInt(1);
                
                if (myResultSet.getString(2).equals("federal"))
                {

                    federalBaseAmount = myResultSet.getDouble(3);
                    federalTaxRate = myResultSet.getDouble(4);

                } else
                {
                
                    provincialBaseAmount = myResultSet.getDouble(3);
                    provincialTaxRate = myResultSet.getDouble(4);
                    
                }

                // Creates a new IncomeTax object.

                IncomeTax tempIncomeTax = new IncomeTax(id, taxableIncome, federalBaseAmount, federalTaxRate, provincialBaseAmount, provincialTaxRate);

                // Adds to a list of IncomeTax objects.

                incomeTax.add(tempIncomeTax);

            }

            return incomeTax;

        } finally
        {

            // Closes up JDBC objects.

            close(myConnection, myStatement, myResultSet);

        }

    }

    private void close(Connection myConnection, PreparedStatement myStatement, ResultSet myResultSet) throws Exception
    {

        try
        {

            if (myResultSet != null)
            {

                myResultSet.close();

            }

            if (myStatement != null)
            {

                myStatement.close();

            }

            if (myConnection != null)
            {

                myConnection.close(); // Returns back to the pool.

            }

        } catch (Exception e)
        {

            e.printStackTrace();

        }

    }

}