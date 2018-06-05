package org.avs.incomeTaxCalculator;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * 
 * Implements class IncomeTaxCalculatorServlet (controller).
 * 
 * @author Andrey Skvortsov
 * 
 */

@WebServlet("/IncomeTaxCalculatorServlet")
public class IncomeTaxCalculatorServlet extends HttpServlet
{
    
    private static final long serialVersionUID = 1L;

    private IncomeTaxCalculatorDbUtil incomeTaxCalculatorDbUtil;

    @Resource(name = "jdbc/income_tax_calculator")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException
    {

        super.init();

        // Creates a database utility and passes in the connection pool (dataSource).

        try
        {

            incomeTaxCalculatorDbUtil = new IncomeTaxCalculatorDbUtil(dataSource);

        } catch (Exception e)
        {

            throw new ServletException(e);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        // Reads the "command" parameter.

        try
        {

            String theCommand = request.getParameter("command");

            // Sets default command to CALCULATE, in case it is missing.

            if (theCommand == null)
            {

                theCommand = "CALCULATE";

            }

            // Routes to the appropriate method.

            switch (theCommand)
            {

            case "CALCULATE":

                calculateIncomeTax(request, response);
                break;

            default:
                calculateIncomeTax(request, response); // In case there will be more than one option in future.

            }

        } catch (Exception e)
        {

            throw new ServletException(e);

        }

    }

    private void calculateIncomeTax(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        
        // Reads territory from a drop-down list.
        
        String territory = request.getParameter("territory");        
            
        // Reads taxable income from a text field.
        
        Double taxableIncome = Double.parseDouble(request.getParameter("taxableIncome"));
        
        // Receives tax rates from a database. 
        
        IncomeTax incomeTax = incomeTaxCalculatorDbUtil.calculateIncomeTax(territory, taxableIncome);
        
        // Adds result to the request.
        
        request.setAttribute("INCOME_TAX", incomeTax);
        
        // Sends results to a JSP page (view).
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/income_tax_calculator.jsp");
        dispatcher.forward(request, response);        

    }

}