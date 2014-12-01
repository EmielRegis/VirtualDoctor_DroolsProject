package com.sample;
/**
 * Created by Karol on 2014-11-27.
 */
public class MedicalQuestionCommunicator implements QuestionCommunicator {

    private QuestionCommunicatorMessageListener questionCommunicatorMessageListener = null;

    @Override
    public void setQuestionCommunicatorListener(QuestionCommunicatorMessageListener listener) {
        questionCommunicatorMessageListener = listener;
    }

    @Override
    public void removeCurrentListener() {
        questionCommunicatorMessageListener = null;
    }

    @Override
    public boolean createQuestion(String message) {
        if (questionCommunicatorMessageListener != null)
        {
            return questionCommunicatorMessageListener.processMessage(message);
        }
        else
        {
//            new NullPointerException("No listener set");
            return false;
        }
    }
    
    @Override 
    public String createSelectOptionQuestion(String message, String[] options)
    {
    	if (questionCommunicatorMessageListener != null)
    	{
    		return questionCommunicatorMessageListener.processSelectOptionMessage(message, options);
    	}
    	else
    	{
//          new NullPointerException("No listener set");
    		return null;
    	}
    }
    
    @Override 
    public String[] createSelectOptionsQuestion(String message, String[] options)
    {
    	if (questionCommunicatorMessageListener != null)
    	{
    		return questionCommunicatorMessageListener.processSelectOptionsMessage(message, options);
    	}
    	else
    	{
//          new NullPointerException("No listener set");
    		return null;
    	}
    }
}
