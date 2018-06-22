package solutions.avs.incomeTaxCalculator;

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

    public IncomeTax calculateIncomeTax(String territory, Double taxableIncome) throws Exception
    {
        Connection myConnection = null;
        PreparedStatement myStatement = null;
        ResultSet myResultSet = null;

        try
        {
            // Connects to a database.
            myConnection = dataSource.getConnection();

            // Searches for tax rates in case taxable income is not empty.
            if (taxableIncome != null)
            {
                // Creates SQL statement to search for federal/provincial tax rates.
                String sql = "SELECT * FROM federal_tax UNION ALL SELECT * FROM provincial_tax WHERE provincial_tax.territory LIKE ?";

                // Creates Prepared Statement.
                myStatement = myConnection.prepareStatement(sql);

                // Sets parameters.
                String theTerritory = "%" + territory.toLowerCase() + "%";
                myStatement.setString(1, theTerritory);
            }

            // Executes SQL statements.
            myResultSet = myStatement.executeQuery();

            // Retrieves data from the result set.
            List<Double> federalBaseAmounts = new ArrayList<>();
            List<Double> federalTaxRates = new ArrayList<>();
            List<Double> provincialBaseAmounts = new ArrayList<>();
            List<Double> provincialTaxRates = new ArrayList<>();

            while (myResultSet.next())
            {
                if (myResultSet.getString(2).equals("federal") && myResultSet.getDouble(3) != 0
                        && myResultSet.getDouble(4) != 0)
                {
                    federalBaseAmounts.add(myResultSet.getDouble(3));
                    federalTaxRates.add(myResultSet.getDouble(4));
                } else if (myResultSet.getDouble(3) != 0 && myResultSet.getDouble(4) != 0)
                {
                    provincialBaseAmounts.add(myResultSet.getDouble(3));
                    provincialTaxRates.add(myResultSet.getDouble(4));
                }
            }

            // Returns a new IncomeTax object.
            return new IncomeTax(taxableIncome, federalBaseAmounts, federalTaxRates, provincialBaseAmounts,
                    provincialTaxRates);
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