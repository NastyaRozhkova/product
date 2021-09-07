package com.epam.batrachenko.task9.util;

public class Constants {
    public static final Integer TCP_PORT = 3000;
    public static final Integer HTTP_PORT = 8080;
    public static final Integer LIMIT_REQUEST = 10;
    public static final String INPUT_COMMAND = "Input command";
    public static final String HTTP_GET_PRODUCT_NAME = "(item\\?get_info=)(\\w+)([ &])";
    public static final String HTTP_GET_COMMAND = "(GET )([\\w/]+)( ?)";
    public static final String TCP_GET_PRODUCT_NAME = "(item=)(\\w+)";
    public static final String TCP_GET_COMMAND = "([\\w ]+)(=*)";
    public static final String PRODUCTS_FILE_NAME = "C:\\\\Users\\\\Vl\\\\pre_prod_java_q3_2021\\\\save.txt";
}
