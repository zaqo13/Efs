package com.efs.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.efs.utility.ExcelUtilityVr2;

/**
 * This class provides data providers for various test cases.
 */
public class DataProviders {

    /**
     * Provides login and password data for login tests.
     *
     * @return an array of arrays containing login and password data
     */
    @DataProvider(name = "data-providerLogIn")
    public Object[][] getLoginPasswordData() {
        return new Object[][] {{"superadmin@gmail.com", "123456"}};		//(userName, password)
    }

    /**
     * Provides account creation data from an Excel file.
     *
     * @return an array of arrays containing account creation data
     * 
     */
    @DataProvider(name = "accountCreationData")
    public Object[][] getAccountCreationData() {
        return ExcelUtilityVr2.getTestDataVr2("AddCustomerDataProvider.xlsx", 0);		//(excelFile, sheetNumber)
    }

}





