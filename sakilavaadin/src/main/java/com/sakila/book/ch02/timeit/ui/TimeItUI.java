package com.sakila.book.ch02.timeit.ui;

import com.sakila.book.ch02.timeit.biz.Test;
import com.sakila.book.ch02.timeit.biz.TestExecutor;
import com.sakila.book.ch02.timeit.biz.TestSet;
import com.sakila.book.ch02.timeit.biz.test.LongVsIntTest;
import com.sakila.book.ch02.timeit.biz.test.ShortCircuitVsNoShortCircuit;
import com.sakila.book.ch02.timeit.biz.test.StringVsStringBuffer;
import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.Collection;
import java.util.function.Function;

@SpringUI
public class TimeItUI extends UI {

    private static final TestSet[] testSets = new TestSet[]{
            new LongVsIntTest(),
            new StringVsStringBuffer(),
            new ShortCircuitVsNoShortCircuit()
    };

    private VerticalLayout layout = new VerticalLayout();
    private ComboBox<TestSet> comboBox = new ComboBox<>("Test");
    private final TextField textField = new TextField("Number of iterations", "1000");
    private CheckBox checkBox = new CheckBox("Keep previous results");
    private Button button = new Button("Time it!");
    private VerticalLayout resultsLayout = new VerticalLayout();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        initCombo();
        initButton();
        initLayout();
    }

    private void initLayout() {
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.addComponent(comboBox);
        layout.addComponent(textField);
        layout.addComponent(checkBox);
        layout.addComponent(button);
        layout.addComponent(resultsLayout);

        setContent(layout);
    }

    private void initButton() {
        button.addClickListener(e -> {
            if(isValid())
                runSelectedTests();
        });
    }

    private void initCombo() {
        comboBox.setItems(testSets);
        comboBox.setItemCaptionGenerator(this::getCaption);
        comboBox.addValueChangeListener(e -> {
            TestSet ts = (TestSet) e.getValue();
            textField.setValue("" + ts.getDefaultTimes());
            button.setDescription("<big>" + ts.getDescription() + "</big>");
        });
    }

    private String getCaption(TestSet ts) {
        return ts.getTitle();
    }


    public boolean isValid() {
        comboBox.setComponentError(null);
        textField.setComponentError(null);

        boolean isValid = true;

        if (comboBox.getValue() == null) {
            comboBox.setComponentError(new UserError("Select a test from the list."));
            isValid = false;
        }

        if (textField.getValue().toString().isEmpty()) {
            textField.setComponentError(new UserError("You must introduce the number of iterations to execute"));
            isValid = false;
        }

        return isValid;
    }

    private void runSelectedTests() {
        showResults(TestExecutor.execute((TestSet) comboBox.getValue(), Long.parseLong(textField.getValue())));
    }

    private void showResults(Collection<String> results) {
        if (!checkBox.getValue()) {
            resultsLayout.removeAllComponents();
        } else {
            if (resultsLayout.getComponentCount() > 0)
                resultsLayout.addComponent(new Label("--"));
            results.forEach(c -> resultsLayout.addComponent(new Label(c)));
        }
    }

}
