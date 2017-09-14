package observor;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
	private List<Observer> obervers = 
			new ArrayList<Observer>();
	private int state;
	
	public int getState(){
		return state;
	}
	
	public void setState(int state){
		this.state = state;
		notifyAllObservers();
	}
	
	public void attach(Observer observer){
		obervers.add(observer);
	}
	
	public void notifyAllObservers(){
		for(Observer observer: obervers){
			observer.update();
		}
	}
}
