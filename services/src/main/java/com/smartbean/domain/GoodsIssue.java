package com.smartbean.domain;

import javax.persistence.*;

@Entity
@Table(name = "nideshop_goods_issue", uniqueConstraints = {})
public class GoodsIssue {

  private long id;
  private Long goodsId;
  private String question;
  private String answer;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "goods_id")
  public Long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Long goodsId) {
    this.goodsId = goodsId;
  }

  @Column(name = "question")
  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  @Column(name = "answer")
  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

}
