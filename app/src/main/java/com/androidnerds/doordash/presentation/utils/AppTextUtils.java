package com.androidnerds.doordash.presentation.utils;

public class AppTextUtils {

    public static String getTimeRange(int[] asapRange) {
        StringBuilder asapRangeBuilder = new StringBuilder();
        if(asapRange.length == 1) {
            asapRangeBuilder.append(asapRange[0])
                    .append(" ")
                    .append("min");
        }else if(asapRange.length == 2) {
            if(asapRange[0] == asapRange[1]) {
                asapRangeBuilder.append(asapRange[0])
                        .append(" ")
                        .append("min");
            } else {
                asapRangeBuilder.append(asapRange[0])
                        .append("-")
                        .append(asapRange[1])
                        .append(" ")
                        .append("min");
            }
        }
        return asapRangeBuilder.toString();
    }

    public static String getPriceRange(int priceRange) {
        if(priceRange == 1) {
            return "$";
        }else if(priceRange == 2) {
            return "$$";
        }else if(priceRange == 3) {
            return "$$$";
        }else {
            return "$$$+";
        }
    }
}
