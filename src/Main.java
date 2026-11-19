import dip.EmailSender;
import dip.NotificationService;
import dip.SmsSender;
import isp.OldPrinter;
import isp.Printer;
import lsp.Bird;
import lsp.Flyable;
import lsp.Penguin;
import lsp.Sparrow;
import ocp.DiscountCalculator;
import ocp.StudentDiscount;
import srp.ReportManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ---------- S ----------
        ReportManager manager = new ReportManager(List.of(5, 10, 15, 20));
        manager.generateReport();

        // ---------- O ----------
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Regular: " + calculator.calculateDiscount("regular", 1000));
        System.out.println("VIP: " + calculator.calculateDiscount("vip", 1000));
        System.out.println("Super VIP: " + calculator.calculateDiscount("super_vip", 1000));

        calculator.register("student", new StudentDiscount());
        System.out.println("Student: " + calculator.calculateDiscount("student", 1000));

        // ---------- L ----------
        displayBird(new Sparrow());
        displayBird(new Penguin());

        displayFlyingBird(new Sparrow());
        // displayFlyingBird(new Penguin()); // нельзя: Penguin не реализует Flyable

        // ---------- I ----------
        Printer printer = new OldPrinter();
        printer.print("Отчёт за неделю");

        // ---------- D ----------
        NotificationService emailService = new NotificationService(new EmailSender());
        emailService.send("Ваш заказ готов к выдаче!");

        NotificationService smsService = new NotificationService(new SmsSender());
        smsService.send("Ваш заказ готов к выдаче!");
    }

    public static void displayBird(Bird bird) {
        bird.eat();
    }

    public static void displayFlyingBird(Flyable bird) {
        bird.fly();
    }
}