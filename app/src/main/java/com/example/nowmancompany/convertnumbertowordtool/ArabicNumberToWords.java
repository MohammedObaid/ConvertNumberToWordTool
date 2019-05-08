package com.example.nowmancompany.convertnumbertowordtool;

import java.text.DecimalFormat;

public class ArabicNumberToWords {

    private static final String[] tensNames = {
            "",
            "عشرة",
            "عشرون",
            "ثلاثون",
            "أربعين",
            "خمسون",
            "ستون",
            "سبعون",
            "ثمانون",
            "تسعين"
    };

    private static final String[] numNames = {
            "",
            "احد",
            "اثنان",
            " ثلاثة",
            " أربعة",
            " خمسة",
            " ستة",
            " سبعة",
            " ثمانية",
            " تسعة",
            " عشرة",
            " أحد عشر",
            " اثني عشر",
            " ثلاثة عشر",
            " أربعة عشرة",
            " خمسة عشر",
            " السادس عشر",
            " سبعة عشر",
            " الثامنة عشر",
            " تسعة عشر"
    };

    private ArabicNumberToWords() {}

    private static String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20){
            soFar = numNames[number % 100];
            number /= 100;
        }
        else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " مائة " + soFar;
    }


    public static String convert(long number) {
        // 0 to 999 999 999 999
        if (number == 0) { return "صفر"; }

        String snumber = Long.toString(number);

        // pad with "0"
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        // XXXnnnnnnnnn
        int billions = Integer.parseInt(snumber.substring(0,3));
        // nnnXXXnnnnnn
        int millions  = Integer.parseInt(snumber.substring(3,6));
        // nnnnnnXXXnnn
        int hundredThousands = Integer.parseInt(snumber.substring(6,9));
        // nnnnnnnnnXXX
        int thousands = Integer.parseInt(snumber.substring(9,12));

        String tradBillions;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1 :
                tradBillions = convertLessThanOneThousand(billions)
                        + " مليار ";
                break;
            default :
                tradBillions = convertLessThanOneThousand(billions)
                        + " مليار ";
        }
        String result =  tradBillions;

        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            case 1 :
                tradMillions = convertLessThanOneThousand(millions)
                        + " مليون ";
                break;
            default :
                tradMillions = convertLessThanOneThousand(millions)
                        + " مليون ";
        }
        result =  result + tradMillions;

        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1 :
                tradHundredThousands = "ألف ";
                break;
            default :
                tradHundredThousands = convertLessThanOneThousand(hundredThousands)
                        + " ألف ";
        }
        result =  result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result =  result + tradThousand;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }

    /**
     * testing
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("*** " + ArabicNumberToWords.convert(0));
        System.out.println("*** " + ArabicNumberToWords.convert(1));
        System.out.println("*** " + ArabicNumberToWords.convert(16));
        System.out.println("*** " + ArabicNumberToWords.convert(100));
        System.out.println("*** " + ArabicNumberToWords.convert(118));
        System.out.println("*** " + ArabicNumberToWords.convert(200));
        System.out.println("*** " + ArabicNumberToWords.convert(219));
        System.out.println("*** " + ArabicNumberToWords.convert(800));
        System.out.println("*** " + ArabicNumberToWords.convert(801));
        System.out.println("*** " + ArabicNumberToWords.convert(1316));
        System.out.println("*** " + ArabicNumberToWords.convert(1000000));
        System.out.println("*** " + ArabicNumberToWords.convert(2000000));
        System.out.println("*** " + ArabicNumberToWords.convert(3000200));
        System.out.println("*** " + ArabicNumberToWords.convert(700000));
        System.out.println("*** " + ArabicNumberToWords.convert(9000000));
        System.out.println("*** " + ArabicNumberToWords.convert(9001000));
        System.out.println("*** " + ArabicNumberToWords.convert(123456789));
        System.out.println("*** " + ArabicNumberToWords.convert(2147483647));
        System.out.println("*** " + ArabicNumberToWords.convert(3000000010L));

        /*
         *** zero
         *** one
         *** sixteen
         *** one hundred
         *** one hundred eighteen
         *** two hundred
         *** two hundred nineteen
         *** eight hundred
         *** eight hundred one
         *** one thousand three hundred sixteen
         *** one million
         *** two millions
         *** three millions two hundred
         *** seven hundred thousand
         *** nine millions
         *** nine millions one thousand
         *** one hundred twenty three millions four hundred
         **      fifty six thousand seven hundred eighty nine
         *** two billion one hundred forty seven millions
         **      four hundred eighty three thousand six hundred forty seven
         *** three billion ten
         **/
    }
}