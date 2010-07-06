package org.errai.samples.helloworld.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.jboss.errai.bus.client.api.Message;
import org.jboss.errai.bus.client.api.MessageCallback;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.bus.client.api.base.MessageBuilder;
import org.jboss.errai.bus.client.framework.RequestDispatcher;
import org.jboss.errai.bus.server.annotations.Service;
import org.jboss.errai.ioc.client.api.CreatePanel;
import org.jboss.errai.ioc.client.api.ToRootPanel;

import javax.annotation.PostConstruct;
import javax.inject.Inject;


@CreatePanel
@ToRootPanel
public class MyPanel extends VerticalPanel {

    private Label label;

    @Inject
    public RequestDispatcher dispatcher;

    @Service("DataThing")
    public MessageCallback callback = new MessageCallback() {
        public void callback(Message message) {
            String msg = message.get(String.class, "Data");

            label.setText(msg);
        }
    };

    @PostConstruct
    public void init() {
        final Button start = new Button("Start");
        label = new Label();

        start.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                MessageBuilder.createMessage()
                        .toSubject("HelloWorldService")
                        .noErrorHandling()
                        .sendNowWith(dispatcher);
            }
        });

        add(start);
        add(label);

        final TextBox numX = new TextBox();
        final TextBox numY = new TextBox();
        final Button addButton = new Button("Add");

        addButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                MessageBuilder.createCall(new RemoteCallback<Long>() {
                    public void callback(Long response) {
                        label.setText(response + "");
                    }
                }, MyRemote.class).addTwoNumbers(Long.parseLong(numX.getText()), Long.parseLong(numY.getText()));
            }
        });

        add(numX);
        add(numY);
        add(addButton);


    }
}
