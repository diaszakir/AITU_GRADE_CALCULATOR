package grade;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            sc.useLocale(Locale.US);
            double finalExamStep;
            double finalExamUp;
            System.out.print("Введите register midterm: ");
            double regmid = sc.nextDouble();
            if (regmid < 25) {
                System.out.println("Ваш regmid ниже 25, у вас Retake");
                System.exit(0);
            }
            System.out.print("Введите register endterm: ");
            double regend = sc.nextDouble();
            if (regend < 25) {
                System.out.println("Ваш regend ниже 25, у вас Retake");
                System.exit(0);
            }
            if ((regmid > 25 && regend > 25) && ((regmid + regend) / 2) >= 50) {
                DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                double regterm = (regmid + regend) / 2;
                System.out.print("Для того чтобы не получить Retake or FX: ");
                System.out.println(50.0);
                System.out.print("Для стипендии final exam: ");
                finalExamStep = (70 - regterm * 0.6) / 0.4;
                if (finalExamStep < 50) finalExamStep = 50;
                String resultStep = decimalFormat.format(finalExamStep);
                System.out.println(resultStep);
                System.out.print("Для повышенной стипендии final exam: ");
                finalExamUp = (90 - regterm * 0.6) / 0.4;
                if (finalExamUp > 100) {
                    System.out.println("Невозможно");
                } else {
                    String resultUp = decimalFormat.format(finalExamUp);
                    System.out.println(resultUp);
                }
                double courseGrade = (regterm * 0.6) + 40;
                System.out.println("Ваша оценка если наберете 100% на Final Exam: " + courseGrade + "%");
            } else {
                System.out.println("У вас regterm ниже 50, у вас Retake");
            }
        } catch (InputMismatchException e) {
            System.out.println("");
        }
        catch (Exception e){
            System.out.println("");
            e.printStackTrace();
        }
    }
}
