package com.epam.batrachenko.task9.util;

public class Constants {
    public static final Integer TCP_PORT = 3000;
    public static final Integer HTTP_PORT = 8080;
    public static final Integer LIMIT_REQUEST = 10;
    public static final String INPUT_COMMAND = "Input command";

    /**
     * Regular expression to get item name from http request
     * Examples: GET /shop/item?get_info=product12&price=10 ==> group1:item?get_info=, g2:product12, g3:&;
     * GET /shop/item?get_info=produc ==> group1:item?get_info=, g2:produc, g3: ;
     */
    public static final String HTTP_GET_PRODUCT_NAME = "(item\\?get_info=)(\\w+)([ &])";

    /**
     * Regular expression to get http command name
     * Examples: GET /shop/item?get_info=product12&price=10 ==> group1:GET , g2:/shop/item, g3:?;
     * GET /shop/count ==> group1:item?get_info=, g2:/shop/count, g3: ;
     */
    public static final String HTTP_GET_COMMAND = "(GET )([\\w/]+)( ?)";

    /**
     * Regular expression to get item name from tcp request
     * Examples: get item=product12 ==> group1:item=, g2:product12
     */
    public static final String TCP_GET_PRODUCT_NAME = "(item=)(\\w+)";

    /**
     * Regular expression to get tcp command name
     * Examples: get count ==> group1:get count, g:;
     * get item=product12 ==> group1:get item, g2:=;
     */
    public static final String TCP_GET_COMMAND = "([\\w ]+)(=*)";
    public static final String PRODUCTS_FILE_NAME = "C:\\\\Users\\\\Vl\\\\pre_prod_java_q3_2021\\\\save.txt";
}
