package com.juxtapose.juxtaposeapi.javaBasic.examQuestions;

import java.util.*;

public class ShopSalesQuestion {

    public static void main(String[] args) {
        ShopSalesQuestion shopSalesQuestion = new ShopSalesQuestion();
        shopSalesQuestion.findIncorrectSales();
    }

    private void findIncorrectSales() {
        Set<String> products = new HashSet<>();
        ArrayList<Double> productPrices = new ArrayList<>();

        ArrayList<String> saleProducts = new ArrayList<>();
        ArrayList<Double> salesProductPrices = new ArrayList<>();

        this.getProductPrices(products, productPrices);
        this.recordSalesPrices(saleProducts, salesProductPrices);

        ArrayList<String> product_stringsList = new ArrayList<>(products.size());

        for (String s: products) {
            product_stringsList.add(s);
        }

        saleProducts.forEach(saleProductsEach -> {
//            System.out.println(saleProductsEach);

            products.forEach(product -> {
                if(saleProductsEach == product) {
                    int index = product_stringsList.indexOf(saleProductsEach);

                    if(product_stringsList.get(index) == saleProducts.get(index)) {
                        System.out.println( saleProductsEach + "=>" + "same price" + productPrices.get(index) + " " + salesProductPrices.get(index));
                    } else {
                        System.out.println(saleProductsEach + "=>" +  productPrices.get(index) + " " + salesProductPrices.get(index));
                    }
                }
            });

        });
    }

    private void getProductPrices(Set<String> products,
                                  ArrayList<Double> productPrices) {

        products.add("eggs");
        products.add("milk");
        products.add("cheese");
        productPrices.add(2.89);
        productPrices.add(3.29);
        productPrices.add(5.79);

    }

    private void recordSalesPrices(ArrayList<String> saleProducts,
                                   ArrayList<Double> salesProductPrices) {

        saleProducts.add("eggs");
        saleProducts.add("eggs");
        saleProducts.add("milk");
        saleProducts.add("cheese");
        salesProductPrices.add(2.89);
        salesProductPrices.add(2.99);
        salesProductPrices.add(3.19);
        salesProductPrices.add(5.79);

    }
}
