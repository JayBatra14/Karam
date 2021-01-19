package com.client;

import com.shared.FieldVerifier;

import gwt.material.design.client.ui.MaterialButton;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class rozgaar implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

  /**
   * This is the entry point method.
   */

  @SuppressWarnings("deprecation")
  @Override
public void onModuleLoad() {
	  

/*final FormPanel form = new FormPanel();
form.setAction("/fileupload");
form.setEncoding(FormPanel.ENCODING_MULTIPART);
form.setMethod(FormPanel.METHOD_POST); 

FileUpload upload = new FileUpload(); 
Singleton.getInstance().up=upload;  
Singleton.getInstance().getCustomerPortal().submit.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub 
		Window.alert("hello");
		form.submit();
		form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
			
			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				// TODO Auto-generated method stub
				Window.alert("File Uploaded");
			}
		});
	}
});
*/


	  /*final FormPanel form = new FormPanel();
	  form.setAction("/fileupload");
	  
	  form.setEncoding(FormPanel.ENCODING_MULTIPART);
	  form.setMethod(FormPanel.METHOD_POST);
	  
	  VerticalPanel panel = new VerticalPanel();
	  form.setWidget(panel);
	  
	  FileUpload upload = new FileUpload();
	  upload.setName("uploadFormElement");
	  panel.add(upload);
	  panel.add(new Button("Submit",new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			form.submit();
			
		}
	}));
	  
	  form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
		
		@Override
		public void onSubmitComplete(SubmitCompleteEvent event) {
			// TODO Auto-generated method stub
			Window.alert("File Uploaded");
		}
	});
	  RootPanel.get().add(form);*/
  

	  
	// RootPanel.get().add(new Image());
	  History.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				// TODO Auto-generated method stub
				Singleton.getInstance().function();
			}
		});

	  History.newItem("gg");
		Singleton.getInstance().function();
		
	History.removeHistoryListener(new HistoryListener() {
		
		@Override
		public void onHistoryChanged(String historyToken) {
			// TODO Auto-generated method stub
			historyToken=null;
		}
	});	
		
}
}
