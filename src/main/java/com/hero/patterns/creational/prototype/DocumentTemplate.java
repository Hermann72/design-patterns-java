package com.hero.patterns.creational.prototype;

import org.w3c.dom.stylesheets.DocumentStyle;

import java.util.ArrayList;
import java.util.List;

public class DocumentTemplate implements Cloneable {
    private String name;
    private String header;
    private String footer;
    private String watermark;
    private List<String> sections;
    private DocumentStyle style;

    public DocumentTemplate(String name, String header, String footer,
                            String watermark, List<String> sections,
                            DocumentStyle style) {
        this.name = name;
        this.header = header;
        this.footer = footer;
        this.watermark = watermark;
        this.sections = new ArrayList<>(sections);
        this.style = style;
    }

    // Deep copy — each nested object is copied independently
    @Override
    public DocumentTemplate clone() {
        try {
            DocumentTemplate clone = (DocumentTemplate) super.clone(); // Shallow copy base
            clone.sections = new ArrayList<>(this.sections);           // Deep copy - list
            clone.style = this.style.clone();                          // Deep copy - style
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    // Methods for customizing the clone
    public DocumentTemplate withName(String name) {
        this.name = name;
        return this;
    }

    public DocumentTemplate withWatermark(String watermark) {
        this.watermark = watermark;
        return this;
    }

    public DocumentTemplate addSection(String section) {
        this.sections.add(section);
        return this;
    }

    public DocumentTemplate withFooter(String footer) {
        this.footer = footer;
        return this;
    }
    @Override
    public String toString() {
        return """
                ==========================================
                Template: %s
                Header: %s
                Footer: %s
                Watermark: %s
                Style: %s
                Sections: %s
                ==========================================
                """.formatted(
                name,
                header,
                footer != null ? footer : "None",
                watermark != null ? watermark : "None",
                style,
                String.join(", ", sections)
        );
    }

    // Getters
    public String getName() { return name; }
    public List<String> getSections() { return sections; }
    public DocumentStyle getStyle() { return style; }

    // ============================================
    // Nested class — represents the document style
    // It must also be cloned to ensure Deep Copy
    // ============================================
    public static class DocumentStyle implements Cloneable {
        private String fontFamily;
        private int fontSize;
        private String primaryColor;

        public DocumentStyle(String fontFamily, int fontSize, String primaryColor) {
            this.fontFamily = fontFamily;
            this.fontSize = fontSize;
            this.primaryColor = primaryColor;
        }
        @Override
        public DocumentStyle clone() {
            try {
                return (DocumentStyle) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("Clone not supported", e);
            }
        }
        public DocumentStyle withFontSize(int fontSize) {
            this.fontSize = fontSize;
            return this;
        }
        public DocumentStyle withPrimaryColor(String color) {
            this.primaryColor = color;
            return this;
        }
        @Override
        public String toString() {
            return fontFamily + " " + fontSize + "pt, color: " + primaryColor;
        }
    }
}
