package net.vergien.jbehave.demo.simple.steps;

import java.util.Stack;

import org.jbehave.core.annotations.Given;

// Inheritance works for steps, good to know for generated code
public abstract class AbstractStack {

	protected Stack<String> testStack;

	public AbstractStack() {
		super();
	}

	@Given("an empty stack")
	public void anEmptyStack() {
		testStack = new Stack<String>();
	}

}