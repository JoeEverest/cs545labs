    package edu.miu.cs545labs.domain;

    import jakarta.persistence.*;

    import java.util.List;

    @Entity
    public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        String title;
        String content;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "post_id")
        List<Comment> comments;

        public Post() {
        }

        public List<Comment> getComments() {
            return comments;
        }

        public void setComments(List<Comment> comments) {
            this.comments = comments;
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
