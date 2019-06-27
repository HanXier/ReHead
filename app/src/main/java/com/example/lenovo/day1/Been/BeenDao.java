package com.example.lenovo.day1.Been;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author: 汐er
 * @QQ: 2044273990
 * @date: 2019/6/26
 * @Week: 星期三
 * @GitHub: https://github.com/HanXier
 */
@Entity
public class BeenDao {

    @Id(autoincrement = true)
    private Long id;
    private String publishTime;
    private String newsId;
    private String newsImg;
    private String source;
    private String category;
    private String title;
    @Generated(hash = 536432754)
    public BeenDao(Long id, String publishTime, String newsId, String newsImg,
            String source, String category, String title) {
        this.id = id;
        this.publishTime = publishTime;
        this.newsId = newsId;
        this.newsImg = newsImg;
        this.source = source;
        this.category = category;
        this.title = title;
    }
    @Generated(hash = 1858233667)
    public BeenDao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPublishTime() {
        return this.publishTime;
    }
    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
    public String getNewsId() {
        return this.newsId;
    }
    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }
    public String getNewsImg() {
        return this.newsImg;
    }
    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg;
    }
    public String getSource() {
        return this.source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
