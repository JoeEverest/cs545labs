    package edu.miu.cs545labs.domain;

    import jakarta.persistence.*;

    @Entity
    public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        String title;
        String content;

        public Post() {
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
