package yovel.danil.lecturers;

import yovel.danil.Degree;
import yovel.danil.Department;

public class DocDegLecturer extends SecDegLecturer {

    private String[] publishedArticles;
    private int publishedArticlesCount;

    public DocDegLecturer(String name, int id, String major, float salary, Department department) {
        super(name, id, major, salary, department);
        this.publishedArticles = new String[1];
        this.publishedArticlesCount = 0;
    }

    public String[] getPublishedArticles() {
        return publishedArticles;
    }


    public int getPublishedArticlesCount() {
        return publishedArticlesCount;
    }

    public void addArticle(String article) {
        if (hasPublishedArticles(article)) { return;}
        if (publishedArticlesCount == publishedArticles.length) {
            String[] temp = new String[publishedArticlesCount * 2];
            for (int i = 0; i < publishedArticlesCount; i++) {
                temp[i] = publishedArticles[i];
            }
            publishedArticles = temp;
        }

        publishedArticles[publishedArticlesCount++] = article;
    }

    public void addArticles(String[] articles) {
        for (String article : articles) {
            addArticle(article);
        }
    }

    public Degree getDegree(){
        return Degree.DOCTOR;
    }



    public boolean hasPublishedArticles(String articleTitle) {
        for (String article : publishedArticles) {
            if (article.equals(articleTitle)) {
                return true;
            }
        }

        return false;
    }
}
