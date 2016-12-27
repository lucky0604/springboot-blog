package com.lucky.config;

/**
 * Created by lucky on 16-12-27.
 */
public class Constants {
    public enum ArticleStatus {
        Draft("草稿"), Publish("发布");

        private String name;

        ArticleStatus(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }
}
