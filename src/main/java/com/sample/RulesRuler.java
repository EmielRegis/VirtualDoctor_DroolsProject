package com.sample;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class RulesRuler implements Runnable
{
	private boolean flag;
	private QuestionCommunicator qCom;
	private StatefulKnowledgeSession kSession;
	
	public RulesRuler(QuestionCommunicator qCom)
	{
		this.flag = false;
		this.qCom = qCom;
	}
	
	public void startRules()
	{
		try{   kSession.insert(new Double(13.00));} catch (Exception ex) {}	
		try{   kSession.halt(); } catch (Exception ex) {}	
		flag = true;
	}
	
	@Override
	public void run() 
     {
		while(true)
		{
			while(!flag)
	    	 	{
	    		 	try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
	    	 	}
	    	 
	    	 	flag = false;
	    	 	makeNewRulesMagic();
		}	    	 	    	    	 
     }
	
	private void makeNewRulesMagic()
	{
		try 
	     {
    		 try {
    		 AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("house_voice.wav"));
    		 Clip clip = AudioSystem.getClip();
    		 clip.open(audioIn);
    		 clip.start();
    		 } catch (Exception e){};
    		 
    		 
    		 KnowledgeBase kBase = readKnowledgeBase();
	         kSession = kBase.newStatefulKnowledgeSession();
	         KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(kSession, "test");           

	         kSession.setGlobal("questionCommunicator", qCom);
	         kSession.setGlobal("diagnosis", new DiagnosisMaster());
	            
	         kSession.fireUntilHalt();

	         logger.close();
	     }
	     catch (Throwable t) { t.printStackTrace(); }
	}
	
	private KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kBuilder.add(ResourceFactory.newClassPathResource("VirtualDoctorRules.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kBuilder.getErrors();

        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }

        KnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase();
        kBase.addKnowledgePackages(kBuilder.getKnowledgePackages());

        return kBase;
    }
}  		 