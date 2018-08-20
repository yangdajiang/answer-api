package com.creatshare.answerapi.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question implements Serializable {

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.qu_id
     *
     * @mbg.generated
     */
    private Integer quId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.qu_type
     *
     * @mbg.generated
     */
    @DecimalMin(value = "1",message = "题目类型错误")
    @DecimalMax(value = "12",message = "题目类型错误")
    private Integer quType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.qu_content
     *
     * @mbg.generated
     */
    @NotBlank(message = "题目内容不能为空")
    private String quContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column question.qu_answer
     *
     * @mbg.generated
     */
    private String quAnswer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table question
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.qu_id
     *
     * @return the value of question.qu_id
     *
     * @mbg.generated
     */
    public Integer getQuId() {
        return quId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.qu_id
     *
     * @param quId the value for question.qu_id
     *
     * @mbg.generated
     */

    public void setQuId(Integer quId) {
        this.quId = quId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.qu_type
     *
     * @return the value of question.qu_type
     *
     * @mbg.generated
     */
    public Integer getQuType() {
        return quType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.qu_type
     *
     * @param quType the value for question.qu_type
     *
     * @mbg.generated
     */
    public void setQuType(Integer quType) {
        this.quType = quType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.qu_content
     *
     * @return the value of question.qu_content
     *
     * @mbg.generated
     */
    public String getQuContent() {
        return quContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.qu_content
     *
     * @param quContent the value for question.qu_content
     *
     * @mbg.generated
     */
    public void setQuContent(String quContent) {
        this.quContent = quContent == null ? null : quContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column question.qu_answer
     *
     * @return the value of question.qu_answer
     *
     * @mbg.generated
     */
    public String getQuAnswer() {
        return quAnswer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column question.qu_answer
     *
     * @param quAnswer the value for question.qu_answer
     *
     * @mbg.generated
     */
    public void setQuAnswer(String quAnswer) {
        this.quAnswer = quAnswer == null ? null : quAnswer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", quId=").append(quId);
        sb.append(", quType=").append(quType);
        sb.append(", quContent=").append(quContent);
        sb.append(", quAnswer=").append(quAnswer);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}