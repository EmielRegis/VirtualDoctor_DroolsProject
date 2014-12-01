package com.sample;

/**
 * Created by Karol on 2014-11-27.
 */
public interface QuestionCommunicatorMessageListener {
    public boolean processMessage (String message);
    public String processSelectOptionMessage (String message, String[] options);
    public String[] processSelectOptionsMessage (String message, String[] options);
}
