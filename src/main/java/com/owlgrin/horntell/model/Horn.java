package com.owlgrin.horntell.model;

import java.util.Map;

/**
 * Created by dave on 15/11/15.
 */
public class Horn {

    protected String link;
    protected String format;
    protected Boolean bubble;
    protected String type;
    protected String text;
    protected String html;
    protected Boolean new_window;


    private Horn(Builder hornBuilder){
        link = hornBuilder.link;
        format = hornBuilder.format;
        bubble = hornBuilder.bubble;
        type = hornBuilder.type;
        text = hornBuilder.text;
        html = hornBuilder.html;
        new_window = hornBuilder.new_window;
    }

    public static class Builder {

        protected String link;
        protected String format;
        protected Boolean bubble;
        protected String type;
        protected String text;
        protected String html;
        protected Boolean new_window;


        public Builder setLink(String link) {
            this.link = link;
            return this;
        }

        public Builder setNew_window(Boolean new_window) {
            this.new_window = new_window;
            return this;
        }

        public Builder setBubble(Boolean bubble) {
            this.bubble = bubble;
            return this;
        }

        public Builder setFormat(String format) {
            this.format = format;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setHtml(String html) {
            this.html = html;
            return this;
        }

        public Horn build(){
            return new Horn(this);
        }
    }
}
