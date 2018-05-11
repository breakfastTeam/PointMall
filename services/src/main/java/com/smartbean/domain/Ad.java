package com.smartbean.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_ad", uniqueConstraints = {})
public class Ad {

  private long id;
  private long adPositionId;
  private long mediaType;
  private String name;
  private String link;
  private String imageUrl;
  private String content;
  private long endTime;
  private long enabled;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getAdPositionId() {
    return adPositionId;
  }

  public void setAdPositionId(long adPositionId) {
    this.adPositionId = adPositionId;
  }


  public long getMediaType() {
    return mediaType;
  }

  public void setMediaType(long mediaType) {
    this.mediaType = mediaType;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }


  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public long getEndTime() {
    return endTime;
  }

  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }


  public long getEnabled() {
    return enabled;
  }

  public void setEnabled(long enabled) {
    this.enabled = enabled;
  }

}
