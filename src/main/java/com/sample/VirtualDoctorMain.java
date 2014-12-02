package com.sample;

/**
 * Created by Karol on 2014-10-30.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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

    private static StatefulKnowledgeSession kSession;

	public static void main(String[] args) {
		
		final MainWindow frame = new MainWindow();
		
		final QuestionCommunicator qCom = new MedicalQuestionCommunicator();
        
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
            public boolean processMessage(String message) 
            {
            	isClicked = false;
            	
            	if(frame.questionPanel.getComponentCount() > 0)
            	{
            		frame.questionPanel.removeAll();
            		frame.questionPanel.revalidate();
            	}
            	
            	questionLabel = new JLabel(message);
            	questionLabel.setHorizontalTextPosition(JLabel.CENTER);
            	questionLabel.setHorizontalAlignment(JLabel.CENTER);
            	questionLabel.setFont(new Font("Sans", Font.BOLD, 14));
            	questionLabel.setBackground(Color.WHITE);
            	
            	yesButton = new JButton("Yes");
            	noButton = new JButton("No");
            	yesButton.setBackground(new Color(30,220,30));
                yesButton.setForeground(Color.WHITE);
                yesButton.setFont(new Font("Sans", Font.PLAIN, 14));
                noButton.setBackground(new Color(220,30,30));
                noButton.setForeground(Color.WHITE);
                noButton.setFont(new Font("Sans", Font.PLAIN, 14));
            	
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
			public String processSelectOptionMessage(String message, String[] options) 
			{
				isClicked = false;
				
				if(frame.questionPanel.getComponentCount() > 0)
            	{
            		frame.questionPanel.removeAll();
            		frame.questionPanel.revalidate();
            	}
				
				questionLabel = new JLabel(message);
				questionLabel.setHorizontalTextPosition(JLabel.CENTER);
            	questionLabel.setHorizontalAlignment(JLabel.CENTER);
            	questionLabel.setFont(new Font("Sans", Font.BOLD, 14));
            	questionLabel.setBackground(Color.WHITE);
				
				okButton = new JButton("Answer");
				okButton.setBackground(new Color(30,220,30));
                okButton.setForeground(Color.WHITE);
                okButton.setFont(new Font("Sans", Font.PLAIN, 14));
				
				frame.questionPanel.add(questionLabel, BorderLayout.NORTH);
				singleSelectionOptions = new JRadioButton[options.length];
				ButtonGroup radiosGroup = new ButtonGroup();
				JPanel optionsPanel = new JPanel();	
				optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.PAGE_AXIS));
				optionsPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
				optionsPanel.setAlignmentY(JPanel.CENTER_ALIGNMENT);
				optionsPanel.setBackground(Color.WHITE);
				
				JLabel helpLabel = new JLabel("   ");
				helpLabel.setBackground(Color.WHITE);
				optionsPanel.add(helpLabel);
				for(int i=0; i<options.length; i++)
				{
					singleSelectionOptions[i] = new JRadioButton();
					singleSelectionOptions[i].setText(options[i]);
					singleSelectionOptions[i].setAlignmentX(JRadioButton.CENTER_ALIGNMENT);
					singleSelectionOptions[i].setAlignmentY(JRadioButton.CENTER_ALIGNMENT);
					singleSelectionOptions[i].setFont(new Font("Sans", Font.PLAIN, 14));
					singleSelectionOptions[i].setBackground(Color.WHITE);
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
			public String[] processSelectOptionsMessage(String message, String[] options) 
			{
				isClicked = false;
				selectedAnswers = new ArrayList<String>();
				
				if(frame.questionPanel.getComponentCount() > 0)
            	{
            		frame.questionPanel.removeAll();
            		frame.questionPanel.revalidate();
            	}
				
				questionLabel = new JLabel(message);
				questionLabel.setHorizontalTextPosition(JLabel.CENTER);
            	questionLabel.setHorizontalAlignment(JLabel.CENTER);
            	questionLabel.setFont(new Font("Sans", Font.BOLD, 14));
            	questionLabel.setBackground(Color.WHITE);
				
				okButton = new JButton("Answer");
				okButton.setBackground(new Color(30,220,30));
                okButton.setForeground(Color.WHITE);
                okButton.setFont(new Font("Sans", Font.PLAIN, 14));
				
				frame.questionPanel.add(questionLabel, BorderLayout.NORTH);
				multipleSelectionOptions = new JCheckBox[options.length];
				JPanel optionsPanel = new JPanel();	
				optionsPanel.setLayout(new FlowLayout());
				optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.PAGE_AXIS));
				optionsPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
				optionsPanel.setAlignmentY(JPanel.CENTER_ALIGNMENT);
				optionsPanel.setBackground(Color.WHITE);
				
				JLabel helpLabel = new JLabel("   ");
				helpLabel.setBackground(Color.WHITE);
				optionsPanel.add(helpLabel);
				for(int i=0; i<options.length; i++)
				{
					multipleSelectionOptions[i] = new JCheckBox();
					multipleSelectionOptions[i].setText(options[i]);
					multipleSelectionOptions[i].setAlignmentX(JRadioButton.CENTER_ALIGNMENT);
					multipleSelectionOptions[i].setAlignmentY(JRadioButton.CENTER_ALIGNMENT);
					multipleSelectionOptions[i].setFont(new Font("Sans", Font.PLAIN, 14));
					multipleSelectionOptions[i].setBackground(Color.WHITE);
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
		
		
		frame.startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{				
				Thread t1 = new Thread(new Runnable() {
				     public void run() 
				     {
				    	 try 
					     {
				    		 AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("house_voice.wav"));
				    		 Clip clip = AudioSystem.getClip();
				    		 clip.open(audioIn);
				    		 clip.start();
				    		 
				    		 
				    		 KnowledgeBase kBase = readKnowledgeBase();
					         kSession = kBase.newStatefulKnowledgeSession();
					         KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(kSession, "test");           

					         kSession.setGlobal("questionCommunicator", qCom);          
					            
					         kSession.fireAllRules();

					         logger.close();
					     }
					     catch (Throwable t) { t.printStackTrace(); }
				     }
				});  
				t1.start();							
			}
		});
			
		ImageIcon img = new ImageIcon("medicine_icon.png");
        frame.setIconImage(img.getImage());
        
        BufferedImage myPicture;
		try 
		{ 
			myPicture = ImageIO.read(new File("house_1.jpg")); 
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	        frame.imagePanel.add(picLabel, BorderLayout.CENTER);
		
		} catch (IOException e1) { e1.printStackTrace(); }		
        
        frame.revalidate();        
        frame.setVisible(true);
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
