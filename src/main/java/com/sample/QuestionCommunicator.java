package com.sample;

/**
 * Created by Karol on 2014-11-27.
 */
public interface QuestionCommunicator {

    public void setQuestionCommunicatorListener(QuestionCommunicatorMessageListener listener);
    public void removeCurrentListener();
    public boolean createQuestion(String message);
    public String createSelectOptionQuestion(String message, String[] options);
    public String[] createSelectOptionsQuestion (String message, String[] options);
}
