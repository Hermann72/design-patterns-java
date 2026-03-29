package com.hero.patterns.structural.facade.services;

public class EmailService {
    public void send(String recipient, String subject, String content) {
        System.out.println("  [EMAIL] Sending to: " + recipient);
        System.out.println("  [EMAIL] Subject: " + subject);
        System.out.println("  [EMAIL] Content length: " + content.length() + " chars");
        System.out.println("  [EMAIL] Sent successfully ✓");
    }
}
