package ru.desnol.domain;

public class domain {
    public enum ItemsForSearch {
        SWEATSHIRT("свитшот"),
        SWEATER("свитер"),
        HOODIE("худи");


        private final String description;

        ItemsForSearch(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}

