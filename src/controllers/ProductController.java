package controllers;

import base.Fiscal;
import base.Income;
import models.Product;
import utils.Rounder;
import views.SalesView;

public class ProductController {

    Product model;
    SalesView view;


    public ProductController(Product model, SalesView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {

        view.getInputs();
        new Fiscal() {
            @Override
            public float fiscal() {
                return 0;
            }
        };
        new Income() {
            @Override
            public float income() {
                return 0;
            }

            @Override
            public float income(float tax) {
                return 0;
            }
        };


        String name = model.getName();
        float income = Product.calculateIncome(model.getQuantity(), model.getPrice());
        String incomeResult = Rounder.round(income);

        float taxExpense = Product.calculateTaxExpense(model.getTax(), income);
        String taxExpenseResult = Rounder.round(taxExpense);

        float netIncome = Product.calculateNetIncome(income, taxExpense);
        String netIncomeResult = Rounder.round(netIncome);

        String output = "Наименование товара: " + name + "\n"
                + "Общий доход (грн.): " + incomeResult + "\n"
                + "Сумма налога (грн.): " + taxExpenseResult + "\n"
                + "Чистый доход (грн.): " + netIncomeResult;
        view.getOutput(output);
    }
}
