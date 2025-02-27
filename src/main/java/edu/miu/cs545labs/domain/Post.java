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

        public Post(long id, String title, String content, String author) {
            this.id = id;
            this.title = title;
            this.content = content;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
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
