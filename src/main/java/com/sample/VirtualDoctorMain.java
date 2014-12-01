package com.sample;

/**
 * Created by Karol on 2014-10-30.
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.*;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;


/**
 * This is a sample class to launch a rule.
 */
public class VirtualDoctorMain {

    public static void main(String[] args) {
        try 
        {
        	final MainWindow frame = new MainWindow();
        	frame.setVisible(true);
      	
            // load up the knowledge base
            KnowledgeBase kBase = readKnowledgeBase();
            StatefulKnowledgeSession kSession = kBase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(kSession, "test");

            QuestionCommunicator qCom = new MedicalQuestionCommunicator();

            qCom.setQuestionCommunicatorListener(new QuestionCommunicatorMessageListener() {
            	boolean isClicked;
            	boolean answer;
            	String textAnswer;
            	JLabel questionLabel;
            	JButton yesButton, noButton, okButton;
            	JRadioButton[] singleSelectionOptions;
            	JCheckBox[] multipleSelectionOptions;
            	ArrayList<String> selectedAnswers;
            	
                @Override
                public boolean processMessage(String message) {
                	isClicked = false;
                	
                	if(frame.questionPanel.getComponentCount() > 0)
                	{
                		frame.questionPanel.removeAll();
                		frame.questionPanel.revalidate();
                	}
                	
                	questionLabel = new JLabel(message);
                	yesButton = new JButton("Yes");
                	noButton = new JButton("No");
                	
                	frame.questionPanel.add(questionLabel, BorderLayout.CENTER);
                	frame.questionPanel.add(yesButton, BorderLayout.WEST);
                	frame.questionPanel.add(noButton, BorderLayout.EAST);
                	frame.questionPanel.revalidate();
                	frame.revalidate();
                	              	
                	noButton.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
							answer = false;		
							isClicked = true;												
						}              		
                	});
                	
                	yesButton.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
							answer = true;		
							isClicked = true;
						}              		
                	});
                	
                	questionLabel.setText(message);
                    
                    while(!isClicked)
                    {
                    	try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                    }                    
                    
                    return answer;
                }

				@Override
				public String processSelectOptionMessage(String message, String[] options) {
					isClicked = false;
					
					if(frame.questionPanel.getComponentCount() > 0)
                	{
                		frame.questionPanel.removeAll();
                		frame.questionPanel.revalidate();
                	}
					
					questionLabel = new JLabel(message);
					okButton = new JButton("Ok");
					frame.questionPanel.add(questionLabel, BorderLayout.NORTH);
					singleSelectionOptions = new JRadioButton[options.length];
					ButtonGroup radiosGroup = new ButtonGroup();
					JPanel optionsPanel = new JPanel();	
					optionsPanel.setLayout(new FlowLayout());
					
					for(int i=0; i<options.length; i++)
					{
						singleSelectionOptions[i] = new JRadioButton();
						singleSelectionOptions[i].setText(options[i]);
						radiosGroup.add(singleSelectionOptions[i]);
						optionsPanel.add(singleSelectionOptions[i]);						
					}
					
					if (singleSelectionOptions.length > 0) {singleSelectionOptions[0].setSelected(true);}
					
					frame.questionPanel.add(optionsPanel, BorderLayout.CENTER);			
                	frame.questionPanel.add(okButton, BorderLayout.SOUTH);
                	frame.questionPanel.revalidate();
                	frame.revalidate();
                	
                	okButton.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							for(JRadioButton option : singleSelectionOptions)
							{
								if(option.isSelected())
								{
									textAnswer = option.getText();
									break;
								}
							}
													
							isClicked = true;													
						}              		
                	});
                	
                	questionLabel.setText(message);
                	
                	 while(!isClicked)
                     {
                     	try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                     }
					
					return textAnswer;
				}

				@Override
				public String[] processSelectOptionsMessage(String message, String[] options) {
					isClicked = false;
					selectedAnswers = new ArrayList<String>();
					
					if(frame.questionPanel.getComponentCount() > 0)
                	{
                		frame.questionPanel.removeAll();
                		frame.questionPanel.revalidate();
                	}
					
					questionLabel = new JLabel(message);
					okButton = new JButton("Ok");
					frame.questionPanel.add(questionLabel, BorderLayout.NORTH);
					multipleSelectionOptions = new JCheckBox[options.length];
					JPanel optionsPanel = new JPanel();	
					optionsPanel.setLayout(new FlowLayout());
					
					for(int i=0; i<options.length; i++)
					{
						multipleSelectionOptions[i] = new JCheckBox();
						multipleSelectionOptions[i].setText(options[i]);
						optionsPanel.add(multipleSelectionOptions[i]);						
					}
					
					if (multipleSelectionOptions.length > 0) {multipleSelectionOptions[0].setSelected(true);}
					
					frame.questionPanel.add(optionsPanel, BorderLayout.CENTER);			
                	frame.questionPanel.add(okButton, BorderLayout.SOUTH);
                	frame.questionPanel.revalidate();
                	frame.revalidate();
                	
                	okButton.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							for(JCheckBox option : multipleSelectionOptions)
							{
								if(option.isSelected()) { selectedAnswers.add(option.getText());}
							}
													
							isClicked = true;													
						}              		
                	});
                	
                	questionLabel.setText(message);
                	
               	 	while(!isClicked)
                    {
                    	try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                    }
					
               	 	return selectedAnswers.toArray(new String[selectedAnswers.size()]);									
				}
            });

            kSession.setGlobal("questionCommunicator", qCom);

            kSession.fireAllRules();

            
			frame.setVisible(true);

            logger.close();
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static KnowledgeBase readKnowledgeBase() throws Exception {
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