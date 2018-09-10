package com.creatshare.answerapi.enums;

public enum QuestionTypeEnum {

    SERVICE(1,3,8,12),
    FRONT(1,2,7,12),
    PRODUCT(1,4,9),
    OPERATE(1,5,10),
    VISION(1,6,11);

    private int base;
    private int choice;
    private int answer;
    private int program;

    QuestionTypeEnum(int base, int choice, int answer, int program) {
        this.base = base;
        this.choice = choice;
        this.answer = answer;
        this.program = program;
    }

    QuestionTypeEnum(int base, int choice, int answer){
        this.base = base;
        this.choice = choice;
        this.answer = answer;
    }

    public int getBase() {
        return base;
    }

    public int getChoice() {
        return choice;
    }

    public int getAnswer() {
        return answer;
    }

    public int getProgram() {
        return program;
    }

}
