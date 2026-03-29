package com.hero.patterns.structural.decorator;

import java.util.Base64;

public class EncryptionDecorator extends ReportDecorator {
    public EncryptionDecorator(ReportGenerator wrapped) {
        super(wrapped);
    }
    @Override
    public String generate(String title, String content) {
        String result = wrapped.generate(title, content); // Delegate first
        System.out.println("  [ENCRYPTION] Encrypting report content...");
        String encrypted = Base64.getEncoder().encodeToString(result.getBytes());
        return "*** ENCRYPTED REPORT ***\n" + encrypted + "\n*** END ENCRYPTED ***";
    }

    @Override
    public String getFormat() {
        return wrapped.getFormat() + "+ENCRYPTED";
    }
}
