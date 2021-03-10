package com.androidnerds.doordash.core.utils;

import java.text.DecimalFormat;

public class MathUtils {

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public static String formatNumber(long number) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(number);
    }

    public static String formatDistance(double distance) {
        DecimalFormat formatter = new DecimalFormat("#,###.##");
        return formatter.format(distance);
    }
}
