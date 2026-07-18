package com.example.tree.treefundamentals;

public class ExcelSheetColTitle_168 {
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0)
            return "";
        else {
            return convertToTitle((columnNumber - 1) / 26) + (char) ('A' + ((columnNumber - 1) % 26));
        }
    }

    public static void main(String[] args) {
        ExcelSheetColTitle_168 e = new ExcelSheetColTitle_168();
        System.out.println(e.convertToTitle(1));
        System.out.println(e.convertToTitle(28));
        System.out.println(e.convertToTitle(701));
    }
}
