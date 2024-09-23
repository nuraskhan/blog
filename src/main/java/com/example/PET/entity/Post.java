package com.example.PET.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name="authorId" , nullable = false)
    private User authorId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="parentId")
    private Post parent;

    @OneToMany(mappedBy = "parent")
    private List<Post> children;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="slug", nullable = false, unique = true)
    private String slug;

    @Column(name="published")
    private boolean published;

    @Column(name="createdAt")
    private LocalDateTime created;

    @Column(name="updatedAt")
    private LocalDateTime updated;

    @Column(name="publishedAt")
    private LocalDateTime publishedAt;

    @Column(name="content")
    private String content;

    @OneToMany(mappedBy = "postId")
    private List<PostComment> comments;

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return authorId;
    }

    public void setAuthor(User author) {
        this.authorId = author;
    }

    public Post getParent() {
        return parent;
    }

    public void setParent(Post parent) {
        this.parent = parent;
    }

    public List<Post> getChildren() {
        return children;
    }

    public void setChildren(List<Post> children) {
        this.children = children;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void addChild(Post child) {
        if(children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author=" + authorId +
                ", parent=" + parent +
                ", children=" + children +
                ", title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", published=" + published +
                ", created=" + created +
                ", updated=" + updated +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                '}';
    }
}
